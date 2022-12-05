package fr.iutfbleau.projetIHM2022FI2.MP;

import fr.iutfbleau.projetIHM2022FI2.API.*;
import fr.iutfbleau.projetIHM2022FI2.MP.ConnectionSingleton;
import java.util.*;
import org.mariadb.jdbc.*;

/**
 * Usine gérant l'ensemble des groupes.
 */
public class AbstractGroupeFactoryP implements AbstractGroupeFactory {

    // la racine (promotion)
    private Groupe promo;

    //Retient tous les groupes (facon pas opti car duplication des données mais cet facon correspond mieux à l'essence de l'api)
    private HashMap<Integer,Groupe> groupsTable;
 

   /**
    * Constructeur de AbstractGroupeFactoryp;
    * On utilise cette version quand on veut totalement créer le groupe Promotion (c'est à dire qu'il n'existe pas sur la BdD)
    * @param name - Le nom du groupe promotion
    * @param min - Le minimun d'étudiants de la promo
    * @param max - Le maximum d'étudiants de la promo
    * @throws IllegalStateException si une opération relative la BdD échoue 
    */
    public AbstractGroupeFactory(String name, int min, int max) throws IllegalStateException{
        ConnectionSingleton singleton; 
        try{
            singleton = ConnectionSingleton.getInstance("meddahi","jaimelespizza");
        }catch(IllegalStateException ex){
            throw ex;
        }
        try{
            //Création du groupe en local et sur la BdD
            this.promo = new GroupeP(name, min, max);
            PreparedStatement pstCreatePromoGroup = singleton.cnx.PrepareStatement("INSERT INTO PJIHM__Groups VALUES (?,?,?,?,?,?)");
            pstCreatePromoGroup.addInt(1,this.promo.getId());
            pstCreatePromoGroup.addString(2,this.promo.getName());
            pstCreatePromoGroup.addString(3,this.typeToString(this.promo.getType()));
            pstCreatePromoGroup.addInt(4,this.promo.getMin());
            pstCreatePromoGroup.addInt(5,this.promo.getMax());
            pstCreatePromoGroup.addInt(6,this.promo.getPointPoint().getId());
            pstCreatePromoGroup.executeUpdate();

            //Ajout des étudiants au groupe promotion sur la BdD
            PreparedStatement pstGetAllStudents = singleton.cnx.PrepareStatement("SELECT * FROM PJIHM__Students"); // La promo contient tous les étudiants, on peut donc directement tous les récuperer au lieu de chercher les étudiant appartenants au groupe d'id 1. On économise ainsi une étape 
            ResultSet rsGetAllStudents = pstGetPromotionStudents.executeQuery();
            
            PreparedStatement pstAddStudentsToPromotion = singleton.cnx.PrepareStatement("INSERT INTO PJIHM__StudentsGroups VALUES (?,?)")
            pstAddStudentsToPromotion.setInt(2,this.promo.getId());
            
            Etudiant studentTmp;
            //Ajout de l'étudiant au groupe promotion...
            while(rsGetAllStudents.next()){
                //... sur la base de données
                pstAddStudentsToPromotion.setInt(1,rsGetAllStudents.getInt(1));
                pstAddStudentsToPromotion.executeUpdate();
                //... en local
                studentTmp = new Etudiant(rsGetAllStudents.getString(3),rsGetAllStudents.getString(2),rsGetAllStudents.getInt(1));
                this.promo.addEtudiant(student);
            }
            this.groupsTable.add(Integer.valueOf(this.promo.getId()),this.promo);
        }catch(SQLException ex){
            throw new IllegalStateException(ex.getMessage());
        }
    }

   /**
    * Surcharge du constructeur de AbstractGroupeFactoryP,
    * On utilise cette version quand le groupe Promotion existe déja sur la BdD
    * @throws IllegalStateException si une opération relative la BdD échoue 
    */
    public AbstractGroupeFactory() throws IllegalStateException{
        ConnectionSingleton singleton; 
        try{
            singleton = ConnectionSingleton.getInstance("meddahi","jaimelespizza");
        }catch(IllegalStateException ex){
            throw ex;
        }

        try{
            //Création de l'objet GroupeP correpondant à la promotion
            PreparedStatement pstGetMinMax = singleton.cnx.PrepareStatement("SELECT name,min,max FROM PJIHM__Groups WHERE id = ?");
            pstGetMinMax.setInt(1,1);
            ResultSet rsGetMinMax = pst1.executeQuery();
            rsGetMinMax.next();
            this.promo = new GroupeP(rsGetMinMax.getString(1),rsGetMinMax.getInt(2),rsGetMinMax.getInt(3));

            //Ajout des étudiants au GroupeP correspondant à la promotion
            PreparedStatement pstGetPromotionStudents = singleton.cnx.PrepareStatement("SELECT * FROM PJIHM__Students"); // La promo contient tous les étudiants, on peut donc directement tous les récuperer au lieu de chercher les étudiant appartenants au groupe d'id 1. On économise ainsi une étape 
            ResultSet rsGetPromotionStudents = pstGetPromotionStudents.executeQuery();
            
            Etudiant studentTmp;
            
            while(rsGetPromotionStudents.next()){
                Etudiant student = new Etudiant(rsGetPromotionStudents.getString(3),rsGetPromotionStudents.getString(2),rsGetPromotionStudents.getInt(1));
                this.promo.addEtudiant(student);
            }
            this.groupsTable.add(Integer.valueOf(this.promo.getId()),this.promo);
        }catch(SQLException ex){
            throw new IllegalStateException(ex.getMessage());
        }
    }
    
    /**
     * permet de récupérer le Groupe qui contient les étudiants de toute la promotion
     * @return la promo.
     */
    public Groupe getPromotion(){
       return this.promo;
    }

    /**
     * permet de supprimer un groupe connu de l'usine abstraite qui ne contient pas de groupes.
     * Pour détruire un groupe connu qui en contient d'autres il faut le faire récursivement.
     *
     * @throws java.lang.NullPointerException si un argument est null
     * @throws java.lang.IllegalStateException si le groupe contient des groupes ou que le groupe n'a pas pu être supprimé sur la BdD
     * @throws java.lang.IllegalArgumentException si le groupe n'est pas connu de l'usine abstraite ou bien si le groupe est celui de toute la promotion (renvoyé par getPromotion)
     */
    public void deleteGroupe(Groupe g){
        //Vérifications
        Objects.requireNonNull(g,"On ne peut pas enlever un groupe null car null n'est pas un groupe autorisé");
        if (!this.knows(g)) throw new IllegalArgumentException("Impossible d'enlever un groupe inconnu");
        if (this.getPromotion().equals(g)) throw new IllegalArgumentException("Impossible de détruire le groupe de toute la promotion");
        if (g.getSize()>0) throw new IllegalStateException("Impossible de détruire un groupe contenant un groupe");
        
        //On s'assure d'abord de supprimer le groupe sur la BdD puis on le supprime en local, on est ainsi sur que les données locales et distantes sont concordantes
        ConnectionSingleton singleton;
        try{
            singleton = ConnectionSingleton.getInstance("meddahi","jaimelespizza");
        }catch(IllegalStateException ex){
            throw ex;
        }
        //Supprimer le groupe et chaque liaison groupe<->etudiant avec ce groupe
        try{
            PreparedStatement pstDeleteGroupFromDB = singleton.cnx.PrepareStatement("DELETE FROM PJIHM__Groups WHERE id = ?");
            pstDeleteGroupFromDB.setInt(g.getId());
            pstDeleteGroupFromDB.executeUpdate();

            PreparedStatement pstDeleteStudentsOfThisGroup = singleton.cnx.PreparedStatement("DELETE FROM PJIHM__StudentsGroups WHERE groupId = ?");
            pstDeleteStudentsOfThisGroup.setInt(g.getInt());
            pstDeleteStudentsOfThisGroup.executeUpdate();
        }catch(SQLException ex){
            throw new IllegalStateException(ex.getMessage());
        }
        //Suppression en local
        g.getPointPoint().removeSousGroupe(g);
        this.groupsTable.remove(Integer.valueOf(g.getId()));
    }

    /**
     * permet d'ajouter un groupe vide de type FREE comme sous-groupe d'un groupe donné.
     * @param pere le groupe père du groupe à créer 
     * @param name le nom du groupe à créer
     * @param min,max bornes indicatives sur la taille du groupe à créer
     *
     * @throws java.lang.NullPointerException si un argument est null
     * @throws java.lang.IllegalArgumentException si le groupe pere est de type PARTITION
     *                                            ou si il n'y a pas 0 < min <= max 
     */
    public void createGroupe(Groupe pere, String name, int min, int max){
        //Vérifications
        Objects.requireNonNull(pere,"Le groupe pere ne peut pas être null");
        Objects.requireNonNull(name,"Le nouveau groupe ne peut pas avoir null comme nom");
        if(pere.getType() == TypeGroupe.PARTITION) throw new IllegalArgumentException("Impossible d'ajouter un sous-groupe à une partition");
        if(min<0 || min>max) throw new IllegalArgumentException(" min ne peut ni être > à max ni < 0");
        if(!this.knows(pere)) throw new IllegalArgumentException(" On ne peut pas ajouter de sous-groupes à un groupe inconnu");

        GroupeP newSubGroup = new GroupeP(pere,name,min,max);
        ConnectionSingleton singleton;
        try{
            singleton = ConnectionSingleton.getInstance("meddahi","jaimelespizza");
        }catch(IllegalStateException ex){
            throw ex;
        }
        //Création du groupe dans la bd
        try{
            PreparedStatement pstCreateGroupOnDB = singleton.cnx.PrepareStatement("INSERT INTO PJIHM__Groups VALUES (?,?,?,?,?,?)");
            pstCreateGroupOnDB.setInt(1,newSubGroup.getId());
            pstCreateGroupOnDB.setString(2,newSubGroup.getName());
            pstCreateGroupOnDB.setString(3,"FREE");
            pstCreateGroupOnDB.setInt(4,newSubGroup.getMin());
            pstCreateGroupOnDB.setInt(5,newSubGroup.getMax());
            pstCreateGroupOnDB.setInt(6,newSubGroup.getPointPoint().getId());
            pstCreateGroupOnDB.executeUpdate();
        }catch(SQLException ex){
            throw new IllegalStateException(ex.getMessage());
        }
        //Création du groupe en local
        pere.addSousGroupe(newSubGroup);//Ajoute le sous groupe au pere
        this.groupsTable.add(Integer.valueOf(newSubGroup.getId()),newSubGroup);//Ajoute le nouveau groupe au groupsTable
    }

    /**
     * permet de créer une partition automatiquement sous un groupe donné.
     *
     * @param pere le groupe père du groupe à partitionner 
     * @param name le nom des groupe à créer (on ajoutera à la suite un numéro ou une lettre pour distinguer chaque groupe)
     * @param n le nombre de partitions
     * @throws java.lang.NullPointerException si un argument est null
     * @throws java.lang.IllegalArgumentException si le groupe pere est de type PARTITION 
     *                                            ou n négatif ou nul
     *
     * NB. doit créer une "copie" de pere 
     *     sous pere de type Partition et ajouter sous ce groupe, n groupes de type "FREE". 
     *     les valeurs min et max de ces n groupes sont 
     *       min = 0 et 
     *       max = partie entière de N/n plus 1, où N est le nombre max du groupe pere.   
     */
    public void createPartition(Groupe pere, String name, int n){
        //Vérifications
        Objects.requireNonNull(pere,"Le groupe pere ne peut pas être null");
        Objects.requireNonNull(name,"Le nouveau groupe ne peut pas avoir null comme nom");
        if(pere.getType()==TypeGroupe.PARTITION) throw new IllegalArgumentException("Impossible de partitionner une partition");
        if(n<=0) throw new IllegalArgumentException("Le nombre de sous-groupes de la partition doit être >0");

        GroupeP newPartition = new GroupeP(pere);
        Set<Etudiant> fatherStudents = pere.getEtudiants();
        for(Etudiant studentTmp : fatherStudents){//Parcourir le groupe pere pour copier chaque eleve dans la partition
            newPartition.addEtudiant(studentTmp);
        }

        ConnectionSingleton singleton;
        try{
            singleton = ConnectionSingleton.getInstance("meddahi","jaimelespizza");
        }catch(IllegalStateException ex){
            throw ex;
        }
        //Création de la partition dans la BdD avant de l'ajouter à this.groupsTable afin de ne pas se retrouver avec un groupe existant en local mais pas sur la BdD
        try{
            //Création du nouveau groupe de type partition
            PreparedStatement pstCreatePartition = singleton.cnx.PrepareStatement("INSERT INTO PJIHM__Groups VALUES (?,?,?,?,?,?)");
            pstCreatePartition.setInt(1,newPartition.getId());
            pstCreatePartition.setString(2,newPartition.getName());
            pstCreatePartition.setString(3,"PARTITION");
            pstCreatePartition.setInt(4,newPartition.getMin());
            pstCreatePartition.setInt(5,newPartition.getMax());
            pstCreatePartition.setInt(6,newPartition.getPointPoint().getId());
            pstCreatePartition.executeUpdate();

            //Ajout des étudiants à ce nouveau groupe
            PreparedStatement pstAddStudentsToPartition = singleton.cnx.PrepareStatement("INSERT INTO PJIHM__StudentsGroups VALUES (?,?)");
            pstAddStudentsToPartition.setInt(2,newPartition.getId());

            PreparedStatement pstGetAllStudentsOfFather = singleton.cnx.PrepareStatement("SELECT studentId FROM PJIHM__StudentsGroups WHERE groupId = ?");
            pstGetAllStudentsOfFather.setInt(1,pere.getId());
            ResultSet rsGetAllStudentsOfFather = pstGetAllStudentsOfFather.executeQuery();
            while(rsGetAllStudentsOfFather.next()){
                pstAddStudentsToPartition.setInt(1,rsGetAllStudentsOfFather.getInt(1));
                pstAddStudentsToPartition.executeUpdate();
            }    
        }catch(SQLException ex){
            throw new IllegalStateException(ex.getMessage());
        }

        this.groupsTable.add(Integer.valueOf(newPartition.getId(),newPartition));
        //On crée ensuite les sous groupes (local et BdD), on est donc sur qu'avant de créer ces sous-groupes, leur père (la partition) existe bien en local et sur la BdD
        int subGroupsMax = (pere.getMax()/n)+1;
        for(int i=0;i<n;i++){
            this.createGroupe(newPartition,name+"_"+i,n,subGroupsMax);
        }
    }
    /**
     * permet d'ajouter un étudiant à un groupe.
     *
     * @param g le groupe dans lequel il faut ajouter l'étudiant
     * @param e l'étudiant à ajouter
     *
     * @throws java.lang.NullPointerException si un argument est null
     * @throws java.lang.IllegalArgumentException la factory ne connaît pas g
     * @throws java.lang.IllegalStateException le père de g ne contient pas e
     */
    public void addToGroupe(Groupe g, Etudiant e){
        //On ne peut ajouter qu'un eleve qui appartient au groupe pere de celui dans lequel on veut l'ajouter
        //Ajouter l'étudiant sur la bd
        //Ajouter l'étudiant dans g 
    }
    /**
     * permet d'enlever un étudiant d'un groupe.
     *
     * @param g le groupe dans lequel il faut enlever l'étudiant
     * @param e l'étudiant à enlever
     *
     * @throws java.lang.NullPointerException si un argument est null
     * @throws java.lang.IllegalStateException g ne contient pas e
     * @throws java.lang.IllegalArgumentException la factory ne connaît pas g
     */
    public void dropFromGroupe(Groupe g, Etudiant e);
     /**
     * permet de retrouver un étudiant à partir d'un String.
     *
     * NB. dans une version simple il doit s'agir du nom exact.
     * dans une version un peu plus complexe, il s'agit des premières lettres du nom
     * dans une version avancée, on peut autoriser une expression régulière plus ou moins complexe qui est générée si la première recherche n'a pas renvoyé de candidat.
     *
     * @param String nomEtu le nom approximmatif de l'étudiant
     * @return Set<Etudiant> l'ensemble des étudiants connus de la factory ayant un nom "proche" de ce string au sens de la remarque ci-dessus.
     *
     * @throws java.lang.NullPointerException si le String est null.
     */
    public Set<Etudiant> getEtudiants(String nomEtu);
    /**
     * permet de retrouver les groupes d'un étudiant.
     *
     * @param Etu un étudiant
     * @return Etudiant l'étudiant connu de la factory ayant cet identifiant
     *
     * @throws java.lang.NullPointerException si le String est null.
     */
    public Set<Groupe> getGroupesOfEtudiant(Etudiant etu);
}
