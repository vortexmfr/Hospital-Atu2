

import java.sql.*;

import static controller.LoginController.UserValidation;
import static services.LoginService.validateUser;

import dto.MedicoDto;
import dto.PersonaDto;
import java.util.List;

import entity.Medico;
import repository.MedicoRepository;
import services.PersonaService;
public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, Exception{

        List<Medico> medicos = MedicoRepository.getAll();

        for (Medico medico : medicos) {
            System.out.println(medico.toString());
        }

        System.out.println(MedicoRepository.getById("1223565-W"));

        //Llamamos al controler  (menus, etc)  -> servicio (Logica) -> repository
        UserValidation ();

        /*
        List<PersonaDto> personas = PersonaService.getAll();
        
        for (PersonaDto persona : personas) {
            System.out.println( persona.toString());
        }

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