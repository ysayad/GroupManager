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

    // On utilise une table de hachage pour retrouver facilement un groupe (à partir de son id).
    // Si il y a beaucoup de groupes c'est plus rapide que de parcourir toute une liste.
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
                this.promo.add(student);
            }
            
            this.groupsTable = new HashMap<Integer,Groupe>();
            this.groupsTable.add(Integer.valueOf(this.promo.getId()),this.promo);
        }catch(SQLException ex){
            singleton.cnx.close();
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
                this.promo.add(student);
            }
            
            this.groupsTable = new HashMap<Integer,Groupe>();
            this.groupsTable.add(Integer.valueOf(this.promo.getId()),this.promo);
        }catch(SQLException ex){
            singleton.cnx.close();
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
     * @throws java.lang.IllegalStateException si le groupe contient des groupes
     * @throws java.lang.IllegalArgumentException si le groupe n'est pas connu de l'usine abstraite ou bien si le groupe est celui de toute la promotion (renvoyé par getPromotion)
     */
    public void deleteGroupe(Groupe g){
        //Verifier que le groupe g n'est pas null
        //Verifier que le groupe ne contienne pas de sous groupes
        //Verifier que le groupe à supprimer n'est ni la promo ni un groupe inconnu
        //Supprimer le groupe de la bdd
            //1. Chercher le groupe avec l'id correspondant et le dl
            //2. Supprimer tous les tuples de PJIHM__StudentsGroups contenant l'id du groupe dans son champ groupId
        //Supprimer le groupe en local (le supprimer de this.groupsTable)
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
    public void createGroupe(Groupe pere, String name, int min, int max);
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
    public void createPartition(Groupe pere, String name, int n);
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
    public void addToGroupe(Groupe g, Etudiant e);
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

    public String typeToString(TypeGroupe type){
        switch(type){
            case TypeGroupe.ROOT:
                return "ROOT";
                break;
            case TypeGroupe.PARTITION:
                return "PARTITION"
                break;
            default:
                return "FREE";
        }
    }
}
