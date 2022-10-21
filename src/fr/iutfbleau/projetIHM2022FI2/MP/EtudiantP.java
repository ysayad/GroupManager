package fr.iutfbleau.projetIHM2022FI2.MP;
import fr.iutfbleau.projetIHM2022FI2.API.*;
import java.sql.*;
import java.util.*;

/**
 * Un étudiant
 */

public class EtudiantP implements Etudiant {

    private int id;
    private String nom, prenom;

    public EtudiantP(String nom, String prenom){
        this.nom = nom;
        this.prenom = prenom;
    }

    public int getId() {
        return this.id;
    }

    public String getNom() {
        return this.nom;
    }

    public String getPrenom() {
        return this.prenom;
    }
    
}
