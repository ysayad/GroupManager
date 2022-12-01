package fr.iutfbleau.projetIHM2022FI2.MP;

import fr.iutfbleau.projetIHM2022FI2.API.*;
import java.util.*;
import org.mariadb.jdbc.*;

/**
 * L'implémentation de l'interface Groupe.java de l'API,
 * représente un groupe en local, la gestion de la persistance des données(BdD) est gérée par la factory
 * @see fr.iutfbleau.projetIHM2022FI2.API.Groupe.java
 *
 * @author Adam Meddahi, Youcef Sayad et Yanis Bouarroudj
 */
public class GroupeP implements Groupe {
    
    private int id;
    private String nom;
    private TypeGroupe type;
    private int min;
    private int max;
    private Groupe father;
    private Set<Etudiant> students;
    private Set<Groupe> subGroups;

    /**
     * Constructeur de la classe GroupeP, crée un nouveau groupe vide de type ROOT sans étudiants, sans sous-Groupe
     * @param name - Le nom du groupe
     * @param min - Le nombre minimum d'étudiants souhaités dans le groupe
     * @param max - Le nombre maximum d'étudiants souhaités dans le groupe 
     */
     public GroupeP(String name, int min, int max){ //1
        this.id = 1;
        this.nom = name;
        this.type = TypeGroupe.ROOT;
        this.min = min;
        this.max = max;
        this.father = this;
        this.students = new LinkedHashSet<Etudiant>();
        this.subGroups = new LinkedHashSet<Groupe>();
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
        this.type = TypeGroupe.FREE;
        this.min = min;
        this.max = max;
        this.father = pere;
        this.subGroups = new LinkedHashSet<Groupe>();
        this.students = new LinkedHashSet<Etudiant>();
    }

    /**
    * Surcharge du constructeur de la classe GroupeP, crée un nouveau groupe de type PARTITION dupliquant
    * le groupe passé en paramètre
    * @param pere - Le groupe pere du groupe à créer
    */
    public GroupeP(Groupe pere){ 
        this.id = this.createId();
        this.name = pere.getName()+"_PARTITION_"+this.id;
        this.type = TypeGroupe.PARTITION;
        this.min = pere.getMin();
        this.max = pere.getMax();
        this.father = pere;
        this.subGroups = new Set<Groupe>();
        this.students = pere.getEtudiants();
    }

    /**
     * Ajoute un étudiant. Se comporte comme add de l'interface Set.
     * @param e - L'objet Etudiant à ajouter au groupe
     * @return true iff e est ajouté
     */
    public boolean addEtudiant(Etudiant e) {
        if(this.students.contains(e)) return false; // On ne peut pas ajouter un étudiant qui appartient déja au groupe
        if(this.students.getSize()==this.max) return false; // On ne peut pas avoir plus d'étudiants que la limite supérieure du groupe
        return this.students.add(e);
    }

   /**
    * Enlève un étudiant. Se comporte comme remove de l'interface Set.
    * @param e - L'objet Etudiant à retirer du groupe
    * @return true iff e est enlevé
    */
    public boolean removeEtudiant(Etudiant e) {
        if(!this.students.contains(e)) return false; // On ne peut pas retirer un étudiant qui n(appartient pas au groupe
        if(this.students.getSize()==this.min) return false; // On ne peut pas avoir moins d'étudiants que la limite inférieure du groupe
        return this.students.remove(e);
    }

   /**
    * Ajoute un sous-groupe. Se comporte comme add de l'interface Set.
    * vérifie que le groupe passé en argument a bien renseigné this comme son père.
    * @param g - L'objet Groupe à ajouter en tant que sous-groupe de this
    * @return true iff g est ajouté
    */
    public boolean addSousGroupe(Groupe g){
        if(this.subGroups.contains(g)) return false; // On ne peut pas ajouter un groupe déja sous-groupe de this
        if( !this.equals(g.getPointPoint()) ) return false;
        return this.subGroups.add(g);
    }

    /**
     * Enlève un groupe. Se comporte comme remove de l'interface Set.
     * @param g - Le sous-groupe à retirer
     * @return true iff e est enlevé
     */
    public boolean removeSousGroupe(Groupe g) {
        if(!this.subGroups.contains(g)) return false; // On ne peut pas enlever un groupe qui n'est pas un sous-groupe de this
        return this.subGroups.remove(g);
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
     * permet de récupérer le nombre minimum d'étudiants souhaités dans le groupe.
     * @return le minimum souhaité
     */
    public int getMin(){
        return this.min;
    }

    /**
     * permet de récupérer le nombre maximum d'étudiants souhaités dans un groupe.
     * @return le maximum souhaité
     */
    public int getMax(){
        return this.max;
    }

    /**
     * permet de récupérer le nombre d'étudiants dans ce groupe.
     * @return le nombre de places prises (pas forcément limité entre Min et Max, mais c'est le but)
     */
    public int getSize(){
        return this.students.size();
    }
    
    /**
     * permet de récupérer la nature du groupe
     * @return le type du groupe
     */
    public TypeGroupe getType(){
        return this.type;
    }

    /**
     * permet de récupérer le groupe père
     * un groupe racine devrait retourner lui-même
     *
     * @return le père
     */
    public Groupe getPointPoint(){
        return this.father;
    }

    /**
     * Potentiellement "vide"
     * Attention nous renvoyons l'ensemble sans le copier
     *
     * @return l'ensemble des sous-groupes.
     */
    public Set<Groupe> getSousGroupes(){
        return this.subGroups;
    }

    /**
     * Potentiellement "vide"
     * Attention nous renvoyons l'ensemble sans le copier
     *
     * @return l'ensemble des étudiants.
     */
    public Set<Etudiant> getEtudiants(){
        return this.students;
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
