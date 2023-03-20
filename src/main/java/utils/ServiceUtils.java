/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import serviceimpl.PacienteServiceImpl;
import serviceimpl.PersonaServiceImpl;

/**
 *
 * @author Rostro
 */
public class ServiceUtils {
    
    public static void initService(){
        PersonaServiceImpl.initService();
        PacienteServiceImpl.initService();
        
    }
}
