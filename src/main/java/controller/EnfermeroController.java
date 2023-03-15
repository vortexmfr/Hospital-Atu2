package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static utils.Utils.askInt;

public class EnfermeroController {
    public static void enfermeroMenu(String user) throws Exception {

        System.out.println("Enfermero Menu");
        int option = 0;
        do {
            System.out.println("0 -Salir del Menu...");
            System.out.println("1 -Dar de alta un paciente");
            System.out.println("2 -Modificar historial paciente");
            System.out.println("3 -Tratar paciente");
            System.out.println("4 -Recetar a un paciente");
            System.out.println("5 -Asignar un medico por especialidad");
            System.out.println("6 -consultar pacientes");
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
                    System.out.println("5");
                    break;
                case 6:
                    System.out.println("6");
                    break;
                case 7:
                    System.out.println("7");
                    //EnfermedadControler.altaEnfermedad();
                    EspecialidadController.altaEspecialidad();
                    break;
                default:
                    System.out.println("Opción no valida");
                    break;
            }
        } while (option != 0);
    }
}

