import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

enum ConnectionDatabase {
    ;
    final static String USER_KEY="user";
    final static String USER_PASSWORD="password";
    final static String USERNAME_REQUIREMENT="Enter username default (root): ";
    final static String PASSWORD_REQUIREMENT="Enter password default (empty): ";
    final static String CONNECTION_PATH ="jdbc:mysql://localhost:3306/minions_db";
    static Connection sqlConnection() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Properties props = new Properties();
        System.out.print(USERNAME_REQUIREMENT);
        String user = scanner.nextLine();
        user = user.equals("") ? "root" : user;
        System.out.print(PASSWORD_REQUIREMENT);
        String password = scanner.nextLine().trim();
        props.setProperty(USER_KEY,user);
        props.setProperty(USER_PASSWORD,password);
        return DriverManager.getConnection(CONNECTION_PATH, props);
    }
}
