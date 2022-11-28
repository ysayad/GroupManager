package fr.iutfbleau.projetIHM2022FI2.MP;

import fr.iutfbleau.projetIHM2022FI2.API.*;
import java.sql.*;
import java.util.*;

/**
 * L'implémentation de l'interface Etudiant.java de l'API
 * @see fr.iutfbleau.projetIHM2022FI2.API.Etudiant.java
 *
 * @author Adam Meddahi, Youcef Sayad et Yanis Bouarroudj
 */
public class EtudiantP implements Etudiant {

    private int id;
    private String nom;
    private String prenom;

    /**
     * Constructeur de la classe étudiant, la factory fera tout le travail relatif à la base de données
     * @param nom - Le nom de l'étudiant
     * @param prenom - Le prénom de l'étudiant
     * @param id - L'identifiant de l'étudiant dans la base de données
     */
    public EtudiantP(String nom, String prenom, int id){
        //On crée un nouvel etudiant dans la table des étudiant
        this.nom = nom;
        this.prenom = prenom;
        this.id = id;
    }
    
    /**
     * permet de récupérer l'identifiant de l'étudiant.
     * @return l'identifiant.
     */   
    public int getId() {
        return this.id;
    }

    /**
     * permet de récupérer le nom de l'étudiant
     * @return le nom de l'étudiant.
     */
    public String getNom() {        
        return this.nom;
    }

    /**
     * permet de récupérer le prénom de l'étudiant
     * @return le prénom de l'étudiant
     */
    public String getPrenom() {
        return this.prenom;
    }
}