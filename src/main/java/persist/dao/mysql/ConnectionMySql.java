package persist.dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMySql {

    /**
     *
     */
    public static Connection connection;

    public ConnectionMySql(){
        getConnection();
    }

    public Connection getConnection() {
        if(connection==null){
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                System.out.println("Where is your MySQL JDBC Driver?");
                e.printStackTrace();
            }

            System.out.println("MySQL JDBC Driver Registered!");
            connection = null;

            try {
                connection = DriverManager.
                        getConnection("jdbc:mysql://" + "ec2-15-237-51-108.eu-west-3.compute.amazonaws.com" + ":" + "3306" + "/" + "splitpay_db", "useremote", "Polytech2021,");
            } catch (SQLException e) {
                System.out.println("Connection Failed!:\n" + e.getMessage());
            }

            if (connection != null) {
                System.out.println("SUCCESS!!!! You made it, take control your database now!");
            } else {
                System.out.println("FAILURE! Failed to make connection!");
            }
        }
        return connection;
    }

}
