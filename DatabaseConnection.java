
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    public static Connection getConnection() {

        try {

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studentdb",
                "root",
                "divya"
            );

            System.out.println("Database Connected!");
            return con;

        } catch (Exception e) {

            System.out.println("Connection Error: " + e.getMessage());
            return null;
        }
    }
}