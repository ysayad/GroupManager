
/**
 * Singleton pour la connection à la base de données,
 * l'utilisation de ce Design Pattern nous assure de ne créer qu'une seule instance de connexion à la base de données
 */
public class ConnectionSingleton {

    private static ConnectionSingleton instance;
    public Connection cnx;

    /**
     * Le constructeur de notre Singleton
     */
    private ConnectionSingleton() throws IllegalStateException{
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            this.cnx = DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/meddahi","meddahi", "jaimelespizza");
        }catch(SQLException ex){
                throw new IllegalStateException("Erreur lors de la connexion à la base de données : "+ex.getMessage());
        }catch(ClassNotFoundException ex){
                throw new IllegalStateException("Le pilote pour se connecter à la base de données n'est pas disponible : "+ex.getMessage());
        }
    }
    
   /**
    Permet de récuperer l'instance de notre singleton 
    */
    public static ConnectionSingleton getInstance() throws IllegalStateException{
        if(this.instance == null){ //Premiere fois qu'on utilise le singleton
            try{
                this.instance = new ConnectionSingleton();
            }catch(IllegalStateException ex){
                throw ex;
            }
        }
        return this.instance;
    }
}

