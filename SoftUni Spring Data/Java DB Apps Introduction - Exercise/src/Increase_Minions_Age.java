import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

public class Increase_Minions_Age {
    final static String updateMinionsQuery = "update minions" +
            " set name=lower(name), age = age+1" +
            " where id =?;";
    final static String selectingAllMinions = "select * from minions;";
    final static String minionsIDAsking = "Minions IDs: ";
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionDatabase.sqlConnection();
        Scanner scanner = new Scanner(System.in);
        System.out.print(minionsIDAsking);
        int[] ids = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        PreparedStatement updating = connection.prepareStatement(updateMinionsQuery);
        for (int id:ids) {
            updating.setInt(1,id);
            updating.executeUpdate();
        }
        PreparedStatement showingMinions = connection.prepareStatement(selectingAllMinions);
        ResultSet allMinions = showingMinions.executeQuery();
        while(allMinions.next()){
            System.out.println(allMinions.getString("name")+" "+ allMinions.getInt("age"));
        }
    }
}
