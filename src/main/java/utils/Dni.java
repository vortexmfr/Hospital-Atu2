package utils;

import java.io.IOException;

import static java.lang.Character.toUpperCase;


public class Dni {

    public static boolean validaDni(String dniimp) throws IOException {

        char[] arrayLetras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        String cadena = "";
        int posicion2 = 0;
        int numDni;
        char[] letra;

        String dni = dniimp.replaceAll("[^A-Za-z0-9]", "");  //Evitar caracteres blancos en el Dni

        try {

            numDni = Integer.parseInt(dni.substring(0, dni.length() - 1));//todo el array menos la ultima posición
            letra = new char[]{dni.charAt(dni.length() - 1)};  //La última posición, la letra

            posicion2 = numDni % 23;

            if (toUpperCase(letra[0]) == arrayLetras[posicion2]) {
                System.out.println("DNI OK");
                return true;
            } else {
                System.out.println("DNI KO");
                return true;   //   <<<<<<<<===================   Este debe ser false en produccion
            }

        } catch (Exception e) {
            //throw new RuntimeException();
        }
        return false;
    }
}





