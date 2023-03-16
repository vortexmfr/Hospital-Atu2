/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import controller.PacienteController;
import dto.PersonaDto;

/**
 *
 * @author Rostro
 */
public class ControllerUtils {

    public static void initControllers() {
        PacienteController.initController();

    }

    public static PersonaDto perdirPersona() {

        return new PersonaDto();
    }

}
