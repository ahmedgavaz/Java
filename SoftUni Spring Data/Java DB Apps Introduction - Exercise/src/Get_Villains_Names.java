import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Get_Villains_Names {
    final static String query = "select name,count(distinct mv.minion_id) as c from villains as v" +
            " join minions_villains as mv on mv.villain_id=v.id" +
            " group by mv.villain_id" +
            " having c>15" +
            " order by c desc;";
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionDatabase.sqlConnection();
        PreparedStatement statement= connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getString("name") +" " + resultSet.getInt("c"));
        }
    }
}
