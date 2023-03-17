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

    public static void pacienteMenu(String user) throws IOException {

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

    public void createPacienteMenu() throws IOException, ParseException, Exception {

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        PacienteDto paciente = new PacienteDto();

        System.out.println(Constants.SEPARADOR);
        System.out.println(Constants.CABECERA_CREAR_PACIENTE);
        System.out.println(Constants.SEPARADOR);

        try {
            String dni = Utils.askString(Constants.PACIENTE_DNI);
            paciente.setDni(dni);
            paciente.setDniPersona(dni);
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
        if (create(paciente)){
            System.out.println(Constants.OK_CREAR);
        } else {
            System.out.println(Constants.KO_CREAR);
        }

    }

    private boolean create(PacienteDto pacienteDto) throws Exception{
        return pacienteService.createPaciente(pacienteDto);
    }

    public static void initController() {
        pacienteService = new PacienteService();
    }
}