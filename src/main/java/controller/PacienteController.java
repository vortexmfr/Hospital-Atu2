package controller;

import dto.PacienteDto;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import services.PacienteService;
import services.PersonaService;
import utils.Constants;
import utils.Utils;

public class PacienteController {
    
    private static PacienteService  pacienteService;
    
    public static void pacienteMenu() throws IOException {

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Paciente Menu");
        int option = 0;
        do {
            System.out.println(Constants.SALIR_MENU);
            System.out.println("1 -Acceder a su historial medico");


            option = Utils.askInt("");

            switch (option) {
                case 0:
                    System.out.println("Saliendo del programa....");
                    break;
                case 1:
                    System.out.println("1");
                    break;
                default:
                    System.out.println(Constants.OPCION_NO_VALIDA);
                    break;
            }
        } while (option != 0);
    }
    

    private void createPacienteMenu() throws IOException, ParseException {
        
         BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
         PacienteDto paciente = new PacienteDto();
        System.out.println(Constants.SEPARADOR);
        System.out.println(Constants.CABECERA_CREAR_PACIENTE);
        System.out.println(Constants.SEPARADOR);
        
        try {
        System.out.println(Utils.askString(Constants.PACIENTE_DNI));
        paciente.setFirstName(Utils.askString(Constants.PACIENTE_NOMBRE));
        paciente.setLastName(Utils.askString(Constants.PACIENTE_APELLIDO));
        paciente.setBirthdate(new SimpleDateFormat("yyyy-MM-dd").parse(Utils.askString(Constants.PACIENTE_FECHA)));
        paciente.setPassword(Utils.askString(Constants.PACIENTE_PASW));
        paciente.setEmail(Utils.askString(Constants.PACIENTE_EMAIL));
        paciente.setUrgencyLevel(Utils.askInt(Constants.PACIENTE_URGENCIA));
        
        } catch(NumberFormatException | ParseException e) {
            System.out.println("Datos no validos. Vuelva a probar");
            createPacienteMenu();
        }
        create(paciente);
    }
    
    private String create(PacienteDto pacienteDto){
        return "";
    }
    
     public static void initController() {
        pacienteService = new PacienteService();
    }
}
