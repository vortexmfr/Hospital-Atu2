package controller;

import dto.PacienteDto;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import services.PersonaService;
import sun.security.pkcs11.P11TlsKeyMaterialGenerator;

public class PacienteController {
    
    private static PersonaService  personaService;
    
    private void pedirPacienteMenu() throws IOException, ParseException {
        
         BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
         PacienteDto paciente = new PacienteDto();
        System.out.println("################################");
        System.out.println("Introduce los datos del Paciente");
        System.out.println("################################");
        
        try {
        System.out.println("Dni del Paciente Ej. ########-N");
        paciente.setDni(buffer.readLine());
        System.out.println("Nombre del Paciente Ej. Juan");
        paciente.setFirstName(buffer.readLine());
        System.out.println("Apellido del Paciente Ej. Romero");
        paciente.setLastName(buffer.readLine());
        System.out.println("Fecha de nacimiento del Paciente Ej. yyyy-MM-dd");
        paciente.setBirthdate(new SimpleDateFormat("yyyy-MM-dd").parse(buffer.readLine()));
        System.out.println("Contrasenya Ej. 12341234");
        paciente.setPassword(buffer.readLine());
        System.out.println("Email del Paciente Ej. ruan@romero.es");
        paciente.setEmail(buffer.readLine());
        System.out.println("Nivel de Urgencia del Paciente Ej. 2");
        paciente.setUrgencyLevel(Integer.parseInt(buffer.readLine()));
        
        } catch(IOException | NumberFormatException | ParseException e) {
            System.out.println("Datos no validos. Vuelva a probar");
            pedirPacienteMenu();
        }
        create(paciente);
    }
    
    
    public void pacienteMenu() throws IOException, ParseException {

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Paciente Menu");
        int option = 0;
        do {
            System.out.println("0 -Salir del Menu...");
            System.out.println("1 -Acceder a su historial medico");


            option = Integer.parseInt(buffer.readLine());

            switch (option) {
                case 0:
                    System.out.println("Saliendo del programa....");
                    break;
                case 1:
                    pedirPacienteMenu();
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (option != 0);
    }
    
    private String create(PacienteDto pacienteDto){
        return "";
    }
    
     public static void initController() {
        personaService = new PersonaService();
    }
}
