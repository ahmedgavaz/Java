import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Get_Minion_Names {
    final static String queryForMinions = "select name,age from minions as m" +
            " join minions_villains as mv on mv.minion_id=m.id" +
            " where mv.villain_id=?;";
    final static String queryForVillain = "select name from villains as v" +
            " where v.id=?;";
    final static String noVillainFormatting = "No villain with ID %d exists in the database.";
    final static String villainIdAsking = "Villain id: ";
    final static String outputFormat = "%d. %s %s%n";

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Connection connection = ConnectionDatabase.sqlConnection();
        PreparedStatement villainStatement = connection.prepareStatement(queryForVillain);
        System.out.print(villainIdAsking);
        int id = Integer.parseInt(scanner.nextLine());
        villainStatement.setInt(1, id);
        ResultSet villainResultSet = villainStatement.executeQuery();
        if (!villainResultSet.next()) {
            System.out.printf(noVillainFormatting, id);
        } else {
            PreparedStatement minionsStatement = connection.prepareStatement(queryForMinions);
            minionsStatement.setInt(1, id);
            ResultSet minionsResultSet = minionsStatement.executeQuery();
            String villainName = villainResultSet.getString("name");
            System.out.println("Villain: " + villainName);
            for (int i = 1; minionsResultSet.next(); i++) {
                System.out.printf(outputFormat, i, minionsResultSet.getString("name"), minionsResultSet.getInt("age"));
            }
        }
        connection.close();
    }
}
