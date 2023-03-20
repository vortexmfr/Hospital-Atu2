package controller;

import dto.PacienteDto;
import entity.Paciente;

import java.util.List;
import service.MedicoService;
import serviceimpl.MedicoServiceImpl;

import static utils.Utils.askInt;

public class MedicoController {

    private static final MedicoServiceImpl medicoService = new MedicoServiceImpl();

    public static void medicoMenu(String user) throws Exception {

        System.out.println("Medico Menu");
        int option = 0;
        do {
            System.out.println("0 -Salir del Menu...");
            System.out.println("1 -Operar");
            System.out.println("2 -Tratar un paciente ");
            System.out.println("3 -Recetar");
            System.out.println("4 -Dar de alta");
            System.out.println("5 -consultar pacientes");
            System.out.println("6 -asignar enfermer@s");
            System.out.println("7 -Registrar enfermedad");

            option = askInt("");

            switch (option) {
                case 0:
                    System.out.println("Saliendo del programa....");
                    break;
                case 1:
                    System.out.println("1");
                    break;
                case 2:
                    System.out.println("2");
                    break;
                case 3:
                    System.out.println("3");
                    break;
                case 4:
                    System.out.println("4");
                    break;
                case 5:
                    System.out.println("Listado de Pacientes");
                    medicoService.imprimirPacientes(user);
                    break;
                case 6:
                    System.out.println("6");
                    break;
                case 7:
                    System.out.println("Alta Enfermedad");
                    EnfermedadController.altaEnfermedad();
                    break;
                default:
                    System.out.println("Opción no valida");
                    break;
            }
        } while (option != 0);
    }

}
