

import java.sql.*;
import static repository.LoginRepository.validateUser;
import dto.PersonaDto;
import java.util.List;
import services.PersonaService;
public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, Exception{

        validateUser("1223563-W", "abc123");

        //Llamamos al controler  (menus, etc)  -> servicio (Logica) -> repository
        //UserValidation ();

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