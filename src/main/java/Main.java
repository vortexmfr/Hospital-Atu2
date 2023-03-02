import com.sun.org.apache.xml.internal.security.algorithms.implementations.SignatureDSA;
import java.sql.*;
import static config.DatabaseConfig.getConnection;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Hello World!");
        String sql = "SELECT * FROM persona";
        // Consulta base de datos
        try (Statement statement = getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String name = resultSet.getString("firstname");
                System.out.println(name);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}