/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Rostro
 */
public class InputUtils {
    
    private static final BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    
    public static String validateString(String field){
        String validField = "";
        // parametro el mensaje sout mensaje
        // 
        try { 
        switch (field) {
            case "firstName":
                System.out.println("Introduce un Nombre");
                break;
            case "lastName":
                System.out.println("Introduce un Apellido");
                break;
            case "dni":
                System.out.println("Introduce un Dni Ej: xxxxxxxx-L");
                break;
            case "role":
                System.out.println("Introduce un Rol Ej: 'admin','doctor','nursey','patient' or 1-4");
                break;
            case "password":
                System.out.println("Introduce una Contrasena Ej: 1234");
                break;
            case "email":
                System.out.println("Introduce un email. Ej: unemail@gmail.com");
                break;
            case "bithdate":
                System.out.println("Introduce fecha de nacimiento Formato: AAAA-MM-dd");
                break;
            default:
                throw new AssertionError();
        }
        validField = buffer.readLine();
         if ( StringUtils.isEmpty(validField) || ("dni".equals(field) && !validateDni(field)) )
                 throw new AssertionError();
        } catch (Exception e) {
            System.out.println("Valor introducido no valido. Vuelve aprobar");
            return validateString(field);
        }
        return null;
    }
        
    public static boolean validateDni(String dni) {
        
        return true;
    }
}
