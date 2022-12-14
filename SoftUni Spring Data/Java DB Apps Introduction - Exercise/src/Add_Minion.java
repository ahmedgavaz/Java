import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Add_Minion {
    final static String searchingTown = "select * from towns" +
            " where name = ?;";
    final static String addingToTownsTable = "insert into towns(name)" +
            " values(?);";
    final static String searchingVillain = "select * from villains" +
            " where name = ?;";
    final static String addingToVillainsTable = "insert into villains(name,evilness_factor)" +
            " values(?,\"evil\");";
    final static String addingMinion = "insert into minions(name,age,town_id)" +
            " values(?,?,?);";
    final static String gettingMinionID = "select id from minions " +
            " where name=?;";
    final static String connectionMinionAndVillain = "insert into minions_villains(minion_id,villain_id)" +
            " values(?,?);";
    final static String minionRequirement = "Minion: ";
    final static String villainRequirement = "Villain: ";
    final static String successfullyAddedTown = "Town %s was added to the database.%n";
    final static String successfullyAddedVillain = "Villain %s was added to the database.%n";
    final static String successfullyAddedMinion = "Successfully added %s to be minion of %s.%n";

    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionDatabase.sqlConnection();
        Scanner scanner = new Scanner(System.in);
        System.out.print(minionRequirement);
        String[] minion = scanner.nextLine().split("\\s+");
        System.out.print(villainRequirement);
        String villain = scanner.nextLine();

        PreparedStatement cityChecking = connection.prepareStatement(searchingTown);
        cityChecking.setString(1, minion[2]);
        ResultSet cityFound = cityChecking.executeQuery();
        if (!cityFound.next()) {
            PreparedStatement addCity = connection.prepareStatement(addingToTownsTable);
            addCity.setString(1, minion[2]);
            addCity.executeUpdate();
            System.out.printf(successfullyAddedTown, minion[2]);
        }

        PreparedStatement villainChecking = connection.prepareStatement(searchingVillain);
        villainChecking.setString(1, villain);
        ResultSet villainFound = villainChecking.executeQuery();
        if (!villainFound.next()) {
            PreparedStatement addVillain = connection.prepareStatement(addingToVillainsTable);
            addVillain.setString(1, villain);
            addVillain.executeUpdate();
            System.out.printf(successfullyAddedVillain, villain);
        }

        ResultSet cityQuery = cityChecking.executeQuery();
        cityQuery.next();
        int townID = cityQuery.getInt("id");


        PreparedStatement insertingMinion = connection.prepareStatement(addingMinion);
        insertingMinion.setString(1, minion[0]);
        insertingMinion.setInt(2, Integer.parseInt(minion[1]));
        insertingMinion.setInt(3, townID);
        insertingMinion.executeUpdate();

        ResultSet villainIDQuery = villainChecking.executeQuery();
        villainIDQuery.next();
        int villainID = villainIDQuery.getInt("id");

        PreparedStatement gettingMinionIDIDIdStatement = connection.prepareStatement(gettingMinionID);
        gettingMinionIDIDIdStatement.setString(1, minion[0]);
        ResultSet MinionIDQuery = gettingMinionIDIDIdStatement.executeQuery();
        MinionIDQuery.next();
        int minionID = MinionIDQuery.getInt("id");

        PreparedStatement insertingIntoMinions_Villains = connection.prepareStatement(connectionMinionAndVillain);
        insertingIntoMinions_Villains.setInt(1, minionID);
        insertingIntoMinions_Villains.setInt(2, villainID);
        insertingIntoMinions_Villains.executeUpdate();
        System.out.printf(successfullyAddedMinion, minion[0], villain);
        connection.close();
    }
}
