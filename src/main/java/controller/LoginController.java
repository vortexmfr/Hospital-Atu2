package controller;

import static controller.EnfermeroController.enfermeroMenu;
import static controller.MedicoController.medicoMenu;
import static controller.PacienteController.pacienteMenu;
import static services.LoginService.validateUser;
import static utils.Types.STRING;
import static utils.Utils.ask;

public class LoginController {
    public static void UserValidation() throws Exception {
        int intentos = 0;
        do {
            String user = ask("Introduce tu DNI", STRING);
            String password = ask("Introduce la password:", STRING);
            intentos++;
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

        } while (intentos < 3) ;

        if (intentos >= 3) { System.out.println("Numero de Intentos excedidos");}
    }
}