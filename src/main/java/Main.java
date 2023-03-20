import controller.LoginController;
import controller.PacienteController;
import dto.PacienteDto;
import java.sql.*;
import dto.PersonaDto;
import entity.Paciente;
import entity.Persona;
import java.util.List;
import repository.PacienteRepository;
import repository.PersonaRepository;
import repository.MedicoRepository;
import serviceimpl.PacienteServiceImpl;
import serviceimpl.PersonaServiceImpl;
import utils.Constants;
import utils.ControllerUtils;
import utils.ServiceUtils;

import java.sql.SQLException;

import entity.Medico;

import java.util.List;

import repository.MedicoRepository;

public class Main {
    
    /*public static void main(String[] args) throws SQLException, ClassNotFoundException, Exception{
        System.out.println("asd");
        /*
        ControllerUtils.initControllers();
        ServiceUtils.initService();
        
       //new PacienteController().pacienteMenu();
       
        List<PersonaDto> personas = new PersonaServiceImpl().getAll();
        //List<PacienteDto> pacientes = new PacienteServiceImpl().getAll();
       
        for (PersonaDto persona : personas) {
            System.out.println( persona.toString());
        }
        System.out.println(Constants.SEPARADOR);
        System.out.println(Constants.SEPARADOR);
        /*
        for (PacienteDto paciente : pacientes) {
            
            System.out.println( paciente.toString());
        }
        /*
        new PacienteController().createPacienteMenu();
       
      /* personas = new PersonaService().getAll();
       
        for (PersonaDto persona : personas) {
            System.out.println( persona.toString());
        }
        System.out.println(Constants.SEPARADOR);
      //  List<Paciente> pacientes = new PacienteRepository().getAll();
        
        
        
        /*
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

    
    public static void main(String[] args) throws SQLException, ClassNotFoundException, Exception{

//        List<Medico> medicos = MedicoRepository.getAll();
//
//        for (Medico medico : medicos) {
//            System.out.println(medico.toString());
//        }

        //System.out.println(MedicoRepository.getById("1223565-W"));

        //Llamamos al controler  (menus, etc)  -> servicio (Logica) -> repository
        LoginController.UserValidation();

    }
    }
//}