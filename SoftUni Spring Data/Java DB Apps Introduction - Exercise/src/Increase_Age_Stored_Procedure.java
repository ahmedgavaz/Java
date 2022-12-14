import java.sql.*;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class Increase_Age_Stored_Procedure {
    static final String getMinion = "select * from minions where id=?;";
    static final String minionIDAsking = "Minion id: ";
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionDatabase.sqlConnection();
        System.out.print(minionIDAsking);
        Scanner scanner = new Scanner(System.in);
        int id =Integer.parseInt(scanner.nextLine());

        CallableStatement procedureCall = connection.prepareCall("Call usp_get_older(?);");
        procedureCall.setInt(1,id);
        procedureCall.executeQuery();

        PreparedStatement showMinion = connection.prepareStatement(getMinion);
        showMinion.setInt(1,id);
        ResultSet minion = showMinion.executeQuery();
        minion.next();
        System.out.println(minion.getString("name")+" "+minion.getInt("age"));
    }
}
