package fr.iutfbleau.projetIHM2022FI2.MP;
import fr.iutfbleau.projetIHM2022FI2.API.*;
import java.util.*;

/**
 * Une demande de changement de groupe
 * concerne un étudiant, qui est dans un groupe A et veut aller dans un groupe B.
 * 
 */

public class ChangementP implements Changement {

    private int id;
    private Groupe a,b;
    private Etudiant e;

    public ChangementP(Groupe a, Etudiant e, Groupe b){
        Objects.requireNonNull(a,"On ne peut pas créer un changement avec un groupe à quitter null");
        Objects.requireNonNull(b,"On ne peut pas créer un changement avec un groupe à rejoindre null");
        Objects.requireNonNull(e,"On ne peut pas créer un changement concernant un étudiant null");

        this.id=this.createId();
        this.a=a;
        this.b=b;
        this.e=e;
    }
    
    /**
     * permet de récupérer l'identifiant du changement (référence interne sans intérêt irl).
     * @return l'identifiant.
     */
    public int getId(){
        return this.id;
    }

    /**
     * permet de récupérer le groupe de depart
     * @return ce groupe.
     */
    public Groupe getA(){
        return this.a;
    }

    /**
     * permet de récupérer le groupe d'arrivée
     * @return ce groupe.
     */
    public Groupe getB(){
        return this.b;
    }

    /**
     * permet de récupérer l'étudiant demandant le changement
     * @return cet étudiant
     */
    public Etudiant getEtu(){
        return this.e;
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
