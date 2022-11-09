package fr.iutfbleau.projetIHM2022FI2.MP;

import fr.iutfbleau.projetIHM2022FI2.API.*;
import java.util.*;

/**
 * L'implémentation de l'interface Groupe.java de l'API
 * @see fr.iutfbleau.projetIHM2022FI2.API.Groupe.java
 *
 * @author Adam Meddahi
 * @author Youcef Sayad
 * @author Yanis Bouarroudj
 */
public class GroupeP implements Groupe {

    private Set<EtudiantP> setEtudiant;
    Groupe groupePere;
    String nom;
    Type
    
    /**
     * Cons 
     */
     public GroupeP(){
        this.setEtudiant = new HashSet<EtudiantP>();
     }

    public boolean addEtudiant(Etudiant e) {
        if()
        return false;
    }

    public boolean removeEtudiant(Etudiant e) {
        return false;
    }

    public boolean addSousGroupe(Groupe g) {
        return false;
    }

    public boolean removeSousGroupe(Groupe g) {
        return false;
    }

    public int getId() {
        return 0;
    }

    public String getName() {
        return null;
    }

    public int getMin() {
        return 0;
    }

    public int getMax() {
        return 0;
    }

    public int getSize() {
        return 0;
    }

    public TypeGroupe getType() {
        return null;
    }

    public Groupe getPointPoint() {
        return null;
    }

    public Set<Groupe> getSousGroupes() {
        return null;
    }

    public Set<Etudiant> getEtudiants() {
        return null;
    }
    
}
