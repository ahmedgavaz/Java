import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Print_All_Minion_Names {
    final static String gettingNames = "select name from minions;";
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionDatabase.sqlConnection();
        PreparedStatement getNames = connection.prepareStatement(gettingNames);
        ResultSet allNames = getNames.executeQuery();
        List<String> names = new ArrayList<>();
        while (allNames.next()){
            names.add(allNames.getString("name"));
        }
        for (int i = 0; i < names.size()/2; i++) {
            System.out.println(names.get(i));
            System.out.println(names.get(names.size()-i-1));
        }
    }
}
