import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class SecureSQLExample {

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

            String query = "SELECT * FROM users WHERE username = ?";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);

            stmt.executeQuery();

            System.out.println("Query executed safely");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
