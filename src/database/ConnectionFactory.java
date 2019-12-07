package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private Connection connection;
    private static ConnectionFactory instance;
    private ConnectionFactory() throws Exception{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/telenor";
            String user = "root";
            String password = "";
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Uspesna konekcija na bazu!");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            throw new Exception("Greska prilikom uspostavljanja konekcije - nepoznat drajver!\n" + ex.getMessage());
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Greska prilikom uspostavljanja konekcije - pogresni parametri za pristup bazi!\n" + ex.getMessage());
        }
    }

    public static ConnectionFactory getInstance() throws Exception{
        if(instance==null){
            instance=new ConnectionFactory();
        }
        return instance;
    }

    public Connection getConnection(){
        return connection;
    }

}
