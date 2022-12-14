import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Change_Town_Names_Casing {
    final static String updatingTable = "update towns" +
            " set name = upper(name) " +
            " where country = ? ;";
    final static String affectedTowns = "select t.name from towns as t" +
            " where country= ?";
    final static String countryRequirement = "Country: ";
    final static String noTownsAffected = "No town names were affected.";
    final static String numberOfAffectedTowns = "%d town names were affected.%n";

    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionDatabase.sqlConnection();
        Scanner scanner = new Scanner(System.in);
        System.out.print(countryRequirement);
        String country = scanner.nextLine();

        PreparedStatement update = connection.prepareStatement(updatingTable);
        update.setString(1, country);
        final int countOfAffectedTowns = update.executeUpdate();

        if (countOfAffectedTowns == 0) {
            System.out.println(noTownsAffected);
        } else {
            System.out.printf(numberOfAffectedTowns, countOfAffectedTowns);
            PreparedStatement affectedTownsChecking = connection.prepareStatement(affectedTowns);
            affectedTownsChecking.setString(1, country);
            ResultSet affectedCount = affectedTownsChecking.executeQuery();

            List<String> names = new ArrayList<>();
            while (affectedCount.next()) {
                names.add(affectedCount.getString("t.name"));
            }
            String str = String.join(", ", names);
            System.out.print("[");
            System.out.print(str);
            System.out.print("]");
        }
    }
}
