import com.sun.org.apache.xml.internal.security.algorithms.implementations.SignatureDSA;
import java.sql.*;
import static config.DatabaseConfig.getConnection;
import dto.PersonaDto;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import services.PersonaService;
public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, Exception{
        
        List<PersonaDto> personas = PersonaService.getAll();
        
        for (PersonaDto persona : personas) {
            System.out.println( persona.toString());
        }
        /*
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
        } */
    }
}