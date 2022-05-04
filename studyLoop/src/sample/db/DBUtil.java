package sample.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBUtil {

    // JDBC URL, username and password of MySQL server
    private final String url = "jdbc:mysql://localhost:3306/study_loop?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&characterEncoding=UTF-8";
    private final String user = "sam";
    private final String password = "sam";

    // JDBC variables for opening and managing connection
    private Connection con;
    private Statement stmt;
    private ResultSet rs;

    public Connection getConnection() {
        try {
            // opening database connection to MySQL server

            con = DriverManager.getConnection(url, user, password);


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error connection creation");
        }
        return con;
    }

}
