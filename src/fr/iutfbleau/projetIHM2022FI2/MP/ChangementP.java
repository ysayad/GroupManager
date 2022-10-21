package fr.iutfbleau.projetIHM2022FI2.MP;
import fr.iutfbleau.projetIHM2022FI2.API.*;
import java.util.*;

/**
 * Une demande de changement de groupe
 * concerne un étudiant, qui est dans un groupe A et veut aller dans un groupe B.
 * 
 */

public class ChangementP implements Changement {

    public int getId() {
        return 0;
    }

    public Groupe getA() {
        return null;
    }

    public Groupe getB() {
        return null;
    }

    public Etudiant getEtu() {
        return null;
    }
    
}
