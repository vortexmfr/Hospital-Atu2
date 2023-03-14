package utils;

import java.io.IOException;

import static java.lang.Character.toUpperCase;


public class Dni {

    public static boolean validaDni(String dni) throws IOException {

        char[] arrayLetras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        String cadena = "";
        int posicion2 = 0;

        int numDni = Integer.parseInt(dni.substring(0, dni.length()-1));//todo el array menos la ultima posicion
        char[] letra = new char[]{dni.charAt(dni.length() - 1)};

        posicion2 = numDni % 23;

        if (toUpperCase(letra[0]) == arrayLetras[posicion2]) {
            System.out.println("DNI OK");
            return true;
        } else {
            System.out.println("DNI KO");
            return false;
        }
    }
}




