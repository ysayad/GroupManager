package fr.iutfbleau.projetIHM2022FI2.MP;
import fr.iutfbleau.projetIHM2022FI2.API.*;
import java.sql.*;
import java.util.*;

/**
 * Un étudiant
 */

public class EtudiantP implements Etudiant {

    int id;
    Connection cnx = DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/sayad", "sayad", "sayadpro");
    PreparedStatement pst;

    public EtudiantP(String nom, String prenom) throws SQLException {
        try {
            pst = cnx.prepareStatement("INSERT INTO `Etudiants`(`Nom`, `Prenom`) VALUES (" + nom + "," + prenom + ")");
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public int getId() {
        try {
            pst = cnx.prepareStatement("SELECT `id`, `Nom`, `Prenom` FROM `Etudiants` WHERE 1");
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return 0;
    }

    public String getNom() {
        try {
            pst = cnx.prepareStatement("SELECT `id`, `Nom`, `Prenom` FROM `Etudiants` WHERE 1");
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return null;
    }

    public String getPrenom() {
        try {
            pst = cnx.prepareStatement("SELECT `id`, `Nom`, `Prenom` FROM `Etudiants` WHERE 1");
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return null;
    }
    
}
