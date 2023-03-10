package controller;

import dto.MedicoDto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static controller.EnfermeroController.enfermeroMenu;
import static controller.MedicoController.medicoMenu;
import static controller.PacienteController.pacienteMenu;
import static services.LoginService.validateUser;

public class LoginController {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    public static void UserValidation () throws Exception {
        System.out.println("Introduce tu DNI");
        String user = buffer.readLine();
        System.out.println("Introduce la password:");
        String password = buffer.readLine();

        switch (validateUser(user, password)) {
            case "doctor":
                medicoMenu();
                break;
            case "nursey":
                enfermeroMenu();
                break;
            case "patient":
                pacienteMenu();
                break;
            default:
                System.out.println("Usuario no existe");
        }
    };
}
