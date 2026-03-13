import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class SqlInjectionExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter username:");
        String username = scanner.nextLine();

        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb",
                "root",
                "password"
            );

            Statement stmt = conn.createStatement();

            // Vulnerable query
            String query = "SELECT * FROM users WHERE username = '" + username + "'";

            stmt.executeQuery(query);

            System.out.println("Query executed");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}