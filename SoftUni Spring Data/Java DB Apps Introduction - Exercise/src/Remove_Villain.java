import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Remove_Villain {
    final static String getVillainName = "select name from villains" +
            " where id=?;";
    final static String getCountOfMinions = "select count(minion_id) as c from minions_villains" +
            " where villain_id=?;";
    final static String deleteVillainFromMinions_Villain = "delete from minions_villains" +
            " where villain_id=?;";
    final static String deleteVillain = "delete from villains" +
            " where id=?;";
    final static String villainIdAsking = "Villain id: ";
    final static String noVillainFound = "No such villain was found";
    final static String deletedVillainMessage = "%s was deleted%n";
    final static String affectedMinionsMessage = "%d minions released";

    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionDatabase.sqlConnection();
        Scanner scanner = new Scanner(System.in);
        System.out.print(villainIdAsking);
        int villainID = Integer.parseInt(scanner.nextLine());

        PreparedStatement searchingVillainName = connection.prepareStatement(getVillainName);
        searchingVillainName.setInt(1, villainID);
        ResultSet isVillainFound = searchingVillainName.executeQuery();
        if (!isVillainFound.next()) {
            System.out.println(noVillainFound);
        } else {
            String villainName = isVillainFound.getString("name");
            PreparedStatement countOfMinions = connection.prepareStatement(getCountOfMinions);
            countOfMinions.setInt(1, villainID);

            ResultSet count = countOfMinions.executeQuery();
            count.next();
            int numberOfMinions = count.getInt("c");
            connection.setAutoCommit(false);
            try {
                PreparedStatement deletingFromMinions_Villains = connection.prepareStatement(deleteVillainFromMinions_Villain);
                deletingFromMinions_Villains.setInt(1, villainID);
                deletingFromMinions_Villains.executeUpdate();

                PreparedStatement deletingVillainFromHisTable = connection.prepareStatement(deleteVillain);
                deletingVillainFromHisTable.setInt(1, villainID);
                deletingVillainFromHisTable.executeUpdate();

                connection.commit();
                System.out.printf(deletedVillainMessage, villainName);
                System.out.printf(affectedMinionsMessage, numberOfMinions);
            } catch (SQLException e) {
                e.printStackTrace();
                connection.rollback();
            }finally {
                connection.close();
            }
        }
    }
}
