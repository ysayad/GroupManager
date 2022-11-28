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

    private Set<Etudiant> setEtudiants;
    private Set<Groupe> setSousGroupes;
    private Groupe groupePere;
    private String nom;
    private TypeGroupe type;
    private int id;
    private int min;
    private int max;
    private Connection cnx;
    
    /**
     * Constructeur de la classe GroupeP, crée un nouveau groupe vide de type ROOT sans étudiants, sans sous-Groupe
     * @param name - Le nom du groupe
     * @param min - Le nombre minimum d'étudiants souhaités dans le groupe
     * @param max - Le nombre maximum d'étudiants souhaités dans le groupe 
     */
     public GroupeP(String name, int min, int max) throws IllegalStateException{
        
        //Verifier si le nom est deja pris
        //1ere étape se connecter
        //2eme etape inserer dans la bdd
        //3eme etapes remplir l'objet en local 
        
        try{
            this.connectToDataBase();
        }catch(IllegalStateException ex){
            IllegalStateException newEx = new IllegalStateException(ex.getMessage());
            throw newEx;
        }

        this.nom = name;
        this.min = min;
        this.max = max;
        this.type = TypeGroupe.ROOT;
        this.GroupePere = ;
        

        Objects.requireNonNull(name,"On ne peut pas créer un groupe dont le nom est null");
        this.id=++this.nextId;
        this.name=name;
        this.min=min;
        this.max=max;
        this.type=TypeGroupe.ROOT;
        this.groupePere=this;
        this.setSousGroupes= new LinkedHashSet<Groupe>();
        this.setEtudiants= new LinkedHashSet<Etudiant>();
     }
     
    /**
     * Surcharge du constructeur de la classe GroupeP, crée un nouveau groupe vide de type FREE sans étudiants, sans sous-Groupe
     * @param pere - Le groupe pere du groupe à créer
     * @param name - Le nom du groupe
     * @param min - Le nombre minimum d'étudiants souhaités dans le groupe
     * @param max - Le nombre maximum d'étudiants souhaités dans le groupe 
     */
     public GroupeP(Groupe pere, String name, int min, int max){
        Objects.requireNonNull(pere,"On ne peut pas créer un groupe dont le père est null");
        Objects.requireNonNull(name,"On ne peut pas créer un groupe dont le nom est null");
        this.id=++this.nextId;
        this.name=name;
        this.min=min;
        this.max=max;
        this.type=TypeGroupe.FREE;
        this.groupePere=pere;
        this.setSousGroupes= new LinkedHashSet<Groupe>();
        this.setEtudiants= new LinkedHashSet<Etudiant>();
    }

    /**
    * Surcharge du constructeur de la classe GroupeP, crée un nouveau groupe de type PARTITION dupliquant le groupe passé en paramètre (pour servir de racine à une partition de ce groupe de type FREE passé en paramètre).
    * @param pere - Le groupe pere du groupe à créer
    */
    public GroupeNP(Groupe pere){
        Objects.requireNonNull(pere,"On ne peut pas créer un groupe dont le père est null");
        this.id=++this.nextId;
        this.name=pere.getName()+"_PARTITION_"+ this.id;
        this.min=pere.getMin();
        this.max=pere.getMax();
        this.type=TypeGroupe.PARTITION;
        this.pointPoint=pere;
        this.sousGroupes= new LinkedHashSet<Groupe>();
        this.membresDuGroupe= pere.getEtudiants();
    }
    
     public GroupeP(Groupe pere, String name, int min, int max, TypeGroupe type){
        this.groupePere = pere;
        this.nom = name;
        this.min = min;
        this.max = max;
        this.setEtudiants = new HashSet<Etudiant>(max-min);
        this.setSousGroupes = new HashSet<Groupe>(0);
     }
    
    /**
     * permet de récupérer l'identifiant de l'étudiant.
     * @return l'identifiant.
     */
    public boolean addEtudiant(Etudiant e) {
        Objects.requireNonNull(e,"On ne peut pas ajouter un Étudiant qui est null");
        return this.setEtudiants.add(e)
    }

    public boolean removeEtudiant(Etudiant e) {
         Objects.requireNonNull(e,"On ne peut pas enlever un Étudiant qui est null");
         return this.setEtudiants.remove(e);
    }

    public boolean addSousGroupe(Groupe g) {
        if(this.setSousGroupes == null){
            this.setSousGroupes = new HashSet<Groupe>(1);
        }
        this.setSousGroupes.
        return false;
    }

    public boolean removeSousGroupe(Groupe g) {
        return false;
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
        return this.nom;
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
        return this.setEtudiants.size();
    }

    public TypeGroupe getType() {
        return this.type;
    }

    public Groupe getPointPoint() {
        return this.groupePere;
    }

    public Set<Groupe> getSousGroupes() {
        return this.setSousGroupes;
    }

    public Set<Etudiant> getEtudiants() {
        return this.setEtudiants;
    }
    
    /**
     * Permet de se connecter à la base de données
     * @throws IllegalStateException si la connexion a échouée
     */
    private void connectToDataBase() throws IllegalStateException{
       try{
        Connection cnx = DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/meddahi","meddahi", "jaimelespizza");
        Class.forName("org.mariadb.jdbc.Driver");
        this.cnx = cnx;
       } catch(SQLException ex){
            throw new IllegalStateException("Erreur lors de la connexion à la base de données : "+ex.getMessage());
       } catch(ClassNotFoundException ex){
            throw new IllegalStateException("Le pilote pour se connecter à la base de données n'est pas disponible : "+ex.getMessage());
       }
    }

    /**
    * Permet de se déconnecter de la base de données en nettoyant correctement les ressources occupées  
     */
    private void endConnection(){
        this.cnx.close();
    }
}
