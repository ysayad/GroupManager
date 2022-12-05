package fr.iutfbleau.projetIHM2022FI2.MP;

import fr.iutfbleau.projetIHM2022FI2.API.*;
import java.util.*;
import org.mariadb.jdbc.*;

/**
 * L'implémentation de l'interface Groupe.java de l'API
 * @see fr.iutfbleau.projetIHM2022FI2.API.Groupe.java
 *
 * @author Adam Meddahi
 * @author Youcef Sayad
 * @author Yanis Bouarroudj
 */
public class GroupeP implements Groupe {

    private String nom;
    private TypeGroupe type;
    private int id;
    private int min;
    private int max;
    private Groupe father;
    private Set<Etudiant> students;
    private Set<Groupe> subGroups;

    //Dans GroupeP : un constucteur pour créer un groupe via un id (permet de créer un objet Groupe en local pour un groupe existant sur la bdd)
    //Dans GroupeFactoryP : une méthode pour récuperer un groupes déja existant qui appellera donc le constructeur expliqué juste au dessus 
    /**
     * Constructeur de la classe GroupeP, crée un nouveau groupe vide de type ROOT sans étudiants, sans sous-Groupe
     * @param name - Le nom du groupe
     * @param min - Le nombre minimum d'étudiants souhaités dans le groupe
     * @param max - Le nombre maximum d'étudiants souhaités dans le groupe 
     * @exceptions
     */
     public GroupeP(String name, int min, int max) throws IllegalStateException{ //1
        //Connection à la Bdd 
        Connection cnx;
        try{
            cnx = this.connectToDataBase();
        }catch(IllegalStateException ex){
            IllegalStateException newEx = new IllegalStateException(ex.getMessage());
            throw newEx;
        }

        // Création et initialisation du groupe racine dans la BdD
        try{
            PreparedStatement pst1 = cnx.PrepareStatement("INSERT INTO PJIHM_Groups(id,name,type,min,max,fatherId) VALUES(?,?,?,?,?,?)");
            pst1.setInt(1,1);
            pst1.setString(2,name);
            pst1.setString(3,"ROOT");
            pst1.setInt(4,min);
            pst1.setInt(5,max);
            pst1.setInt(6,1);
            pst1.executeUpdate();
        }catch(SQLException ex){
            this.endConnection(cnx);
            IllegalStateException newEx = new IllegalStateException(ex.getMessage());
            throw newEx;
        }
        
        // Attribution à tous les étudiant du groupe Racine (groupId = 1)
        try{
            PreparedStatement pst1 = cnx.PrepareStatement("SELECT * FROM PJIHM__Students");
            PreparedStatement pst2 = cnx.PrepareStatement("INSERT INTO PJIHM_StudentsGroups VALUES(?,?)");
            ResultSet rs = pst1.executeQuery();
            while(rs.next()){
                //Ajoute l'étudiant au groupe sur la bd
                pst2.SetInt(1,rs.getInt(1));
                pst2.SetInt(2,1);
                pst2.executeUpdate();

                //Ajoute l'étudiant au groupe en local
                Etudiant students = new Etudiant(rs.getString(3), rs.getString(2), rs.getInt(1)); //nom prenom id
                this.students.add(student);
            }
        }catch(SQLException ex){
            this.endConnection(cnx);
            IllegalStateException newEx = new IllegalStateException(ex.getMessage());
            throw newEx;
        }

        //Initialisation en local des attributs du groupes 
        this.nom = name;
        this.type = TypeGroupe.ROOT;
        this.id = 1;
        this.min = min;
        this.max = max;
        this.father = this;
     }
     
    /**
     * Surcharge du constructeur de la classe GroupeP, crée un nouveau groupe vide de type FREE sans étudiants, sans sous-Groupe
     * @param pere - Le groupe pere du groupe à créer
     * @param name - Le nom du groupe
     * @param min - Le nombre minimum d'étudiants souhaités dans le groupe
     * @param max - Le nombre maximum d'étudiants souhaités dans le groupe 
     */
     public GroupeP(Groupe pere, String name, int min, int max){ //2

        this.id = this.createId();
        this.name = name;
        this.min = min;
        this.max = max;
        this.type = TypeGroupe.FREE;
        this.father = pere;
        //Connection à la Bdd 
        Connection cnx;
        try{
            cnx = this.connectToDataBase();
        }catch(IllegalStateException ex){
            IllegalStateException newEx = new IllegalStateException(ex.getMessage());
            throw newEx;
        }

        //Création du groupe dans la BdD
        try{
            PreparedStatement pst1 = cnx.PrepareStatement("INSERT INTO PJIHM_Groups(id,name,type,min,max,fatherId) VALUES(?,?,?,?,?,?)");
            pst1.setInt(1,this.id);
            pst1.setString(2,name);
            pst1.setString(3,"FREE");
            pst1.setInt(4,min);
            pst1.setInt(5,max);
            pst1.setInt(6,pere.getId());
            pst1.executeUpdate();
        }catch(SQLException ex){
            IllegalStateException newEx = new IllegalStateException(ex.getMessage());
            throw newEx;
        }

    }

    /**
    * Surcharge du constructeur de la classe GroupeP, crée un nouveau groupe de type PARTITION dupliquant le groupe passé en paramètre (pour servir de racine à une partition de ce groupe de type FREE passé en paramètre).
    * @param pere - Le groupe pere du groupe à créer
    */
    public GroupeP(Groupe pere){
        
        this.id = this.createId();
        this.name = pere.getName()+"_PARTITION_"+this.id;
        this.min = pere.getMin();
        this.max = pere.getMax();
        this.type = TypeGroupe.PARTITION;
        this.father = pere;

        //Connection à la Bdd 
        Connection cnx;
        try{
            cnx = this.connectToDataBase();
        }catch(IllegalStateException ex){
            IllegalStateException newEx = new IllegalStateException(ex.getMessage());
            throw newEx;
        }
        //Création dans la BdD du nouveau groupe de type PARTITION
        try{
            PreparedStatement pst1 = cnx.PrepareStatement("INSERT INTO PJIHM_Groups(id,name,type,min,max,fatherId) VALUES(?,?,?,?,?,?)");
            pst1.setInt(1,1);//A MODIFIER (PEUT ETRE AUTO INCREMENT)
            pst1.setString(2,this.name);
            pst1.setString(3,"PARTITION");
            pst1.setInt(4,pere.getMin());
            pst1.setInt(5,pere.getMax());
            pst1.setInt(6,pere.getId());
        }catch(SQLException ex){
            IllegalStateException newEx = new IllegalStateException(ex.getMessage());
            throw newEx;
        }

        //Chaque éléve du groupe pere appartient desormais aussi à la partition
        try{
            PreparedStatement pst1 = cnx.PrepareStatement("SELECT studentsId FROM PJIHM__StudentsGroups WHERE groupId = ?");
            pst1.setInt(1,pere.getId());
            PreparedStatement pst2 = cnx.PrepareStatement("SELECT nom,prenom FROM PJIHM__Students WHERE id=?");
            PreparedStatement pst3 = cnx.PrepareStatement("INSERT INTO PJIHM_StudentsGroups VALUES(?,?)");
            ResultSet rs1 = pst1.executeQuery();
            while(rs1.next()){
                //Ajoute l'étudiant au groupe sur la bd
                pst3.SetInt(1,rs1.getInt(1));
                pst3.SetInt(2,this.getId());
                pst3.executeUpdate();
                //Ajoute l'étudiant au groupe en local
                pst2.setInt(rs1.getInt(1));
                ResultSet rs2 = pst2.executeQuery();
                rs2.next();
                Etudiant student = new Etudiant(rs2.getString(1), rs2.getString(2), rs1.getInt(1));
                this.students.add(student);
            }
        }
    }
    
    public boolean addEtudiant(Etudiant e) {
        if((!this.students.contains(e)) || this.students.size()==this.max || (!this.students.add(e)))
            return false;
        
        //Connexion
        Connection cnx;
        try{
            cnx = this.connectToDataBase();
        }catch(IllegalStateException ex){
           this.endConnection(cnx);
           return false;
        }

        //Ajouter l'étudiant sur la bd
        try{
            PreparedStatement pst1 = cnx.PrepareStatement("INSERT INTO PJHIHM__StudentsGroups VALUES(?,?)");
            pst1.setInt(1,e.getId());
            pst1.setInt(2,this.getId());
            pst1.executeUpdate();
        }catch(SQLException ex){
            this.endConnection(cnx);
            return false;
        }

        return true;
    }

    public boolean removeEtudiant(Etudiant e) {
        if((!this.students.contains(e)) || this.students.size()==this.min || (!this.students.remove(e)))
        return false;

        Connection cnx;
        try{
            cnx = this.connectToDataBase();
        }catch(IllegalStateException ex){
           this.endConnection(cnx);
           return false;
        }
        
        //Ajouter l'étudiant sur la bd
        try{
            PreparedStatement pst1 = cnx.PrepareStatement("DELETE FROM PJHIHM__StudentsGroups WHERE studentsId=? AND groupsId=?");
            pst1.setInt(1,e.getId());
            pst1.setInt(2,this.getId());
            pst1.executeUpdate();
        }catch(SQLException ex){
            this.endConnection(cnx);
            return false;
        }

        return true;
    }

    public boolean addSousGroupe(Groupe g){
        if(this.setSousGroupes == null){
            this.setSousGroupes = new HashSet<Groupe>(1);
        }
        this.setSousGroupes.
        return false;
    }

    public boolean removeSousGroupe(Groupe g) {
        if((!this.subGroups.contains(g)) || this.subGroups.remove(g))
            return false;

        Connection cnx;
        try{
            cnx = this.connectToDataBase();
        }catch(IllegalStateException ex){
        this.endConnection(cnx);
        return false;
        }
        
        //Ajouter l'étudiant sur la bd
        try{
            PreparedStatement pst1 = cnx.PrepareStatement("DELETE FROM PJIHM__StudentsGroups WHERE studentsId=? AND groupsId=?");
            pst1.setInt(1,e.getId());
            pst1.setInt(2,this.getId());
            pst1.executeUpdate();
        }catch(SQLException ex){
            this.endConnection(cnx);
            return false;
        }

        return true;
    }

    /**
     * permet de récupérer l'identifiant du groupe.
     * @return l'identifiant.
     */
    public int getId() {
        return this.id;
    }

    /**
     * permet de récupérer le nom du groupe.
     * @return l'identifiant.
     */
    public String getName() {
        return this.name;
    }

    /**
     * permet de récupérer l'identifiant de l'étudiant.
     * @return l'identifiant.
     */
    public int getMin() {
        return this.min;
    }

    public int getMax() {
        return this.max;
    }

    public int getSize() {
        return this.students.size();
    }

    public TypeGroupe getType() {
        return this.type;
    }

    public Groupe getPointPoint() {
        return this.father;
    }

    public Set<Groupe> getSousGroupes() {
        return this.subGroups;
    }

    public Set<Etudiant> getEtudiants() {
        return this.students;
    }
    
    /**
     * Permet de se connecter à la base de données
     * @throws IllegalStateException si la connexion a échouée, la connexion est fermée 
     */
    private Connection connectToDataBase() throws IllegalStateException{
       Connection cnx;
       try{
        cnx = DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/meddahi","meddahi", "jaimelespizza");
        Class.forName("org.mariadb.jdbc.Driver");
        return cnx;
       } catch(SQLException ex){
            throw new IllegalStateException("Erreur lors de la connexion à la base de données : "+ex.getMessage());
       } catch(ClassNotFoundException ex){
            throw new IllegalStateException("Le pilote pour se connecter à la base de données n'est pas disponible : "+ex.getMessage());
       }finally{
            this.endConnection(cnx);
       }
    }

    /**
     * Permet de se déconnecter de la base de données en nettoyant correctement les ressources occupées  
     */
    private void endConnection(Connection cnx){
        cnx.close();
    }

  /**
   *Permet de définir l'Id d'un groupe, il faut s'assurer que l'Id soit unique, car il identifie chaque groupe, la méthode est la suivante :
   *1. On additionne le Pid + l'adresse mac + le TimeStamp
   *2. Le Hash de cette addition sera l'ID du groupe
   *On s'assure ainsi que l'Id est unique même si:
   * - 2 Admin sur des machines différentes créent un groupe au même moment (grâce à l'adresse MAC)
   * - 2 Admin sur la même machine créent un groupe au même moment (grâce au Pid)
   * - L'Admin crée 2 groupes à la suite depuis la même machine et le même programme (grâce au TimeStamp)
   * @exception IllegalStateException Si une valeur de la somme n'a pas pu être récupérée
   */
    private int createId() throws IllegalStateException{
        //Récupere le timeStamp
        Date date = new Date();
        Long timeStamp = new Long(date.getTime());
        return timeStamp.hashCode();
    }

}