package controller;

import controller.*;
import static serviceimpl.LoginServiceImpl.validateUser;
import static utils.Dni.validaDni;
import static utils.Types.STRING;
import static utils.Utils.ask;

public class LoginController {

    private final MedicoController medicoController = new MedicoController();
    private final EnfermeroController enfermeroController = new EnfermeroController();
    private final PacienteController pacienteController = new PacienteController();
    public void UserValidation() throws Exception {
        int intentos = 0;
        do {
            String user = ask("Introduce tu DNI:", STRING);
            validaDni(user);
            String password = ask("Introduce la password:", STRING);
            intentos++;
            switch (validateUser(user, password)) {
                case "doctor":
                    medicoController.medicoMenu(user);
                    break;
                case "nursey":
                    enfermeroController.enfermeroMenu(user);
                    break;
                case "patient":
                    pacienteController.pacienteMenu(user);
                    break;
                default:
                    System.out.println("Usuario no existe");
            }

        } while (intentos < 3);

        if (intentos >= 3) {
            System.out.println("Numero de Intentos excedidos");
        }
    }
}
