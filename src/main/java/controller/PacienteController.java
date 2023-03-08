package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PacienteController {

    public static void pacienteMenu() throws IOException {

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
                    System.out.println("1");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (option != 0);
    }
    }
