package fr.iutfbleau.projetIHM2022FI2.MP;
import java.sql.*;
import org.mariadb.jdbc.*;

public class BDDConnect {
    
    private static BDDConnect instance = null;
    private Connection cnx;
    
    private BDDConnect(String login, String password){
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            this.cnx = DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/" + login, login, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public BDDConnect Instance(String login, String password){
        if (instance == null) {
            instance = new BDDConnect(login, password);
        }
        return instance;
    }

    public Connection getCnx(){
        return this.cnx;
    }

    public boolean closeCnx(){
        try {
            this.cnx.close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}
