import java.sql.*;
import dto.PersonaDto;
import entity.Persona;
import java.util.List;
import repository.PersonaRepository;
import services.PersonaService;
import utils.ServiceUtils;
public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, Exception{
        ServiceUtils.initService();
        
       // new PersonaRepository().create(new Persona("dniP2", "dniP", "dniP", new java.util.Date(4, 4, 2021), "dniP", "dniP", "dniP"));
      // new PersonaRepository().update(new Persona("dniP10", "hola", "hola", new java.util.Date(4, 4, 2021), "hola", "dniP", "patient"));
        List<PersonaDto> personas = new PersonaService().getAll();
       
        for (PersonaDto persona : personas) {
            System.out.println( persona.toString());
        }
        System.out.println("By ID: -------------------");
        
       System.out.println(new PersonaService().getById("1223564-W").toString());
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