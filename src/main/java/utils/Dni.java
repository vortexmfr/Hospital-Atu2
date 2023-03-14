package utils;

import java.io.IOException;


public class Dni {

    public static boolean validaDni(String dni) throws IOException {

        char[] arrayLetras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        String cadena = "";
        int posicion2 = 0;

        String[] parts = dni.split("-");
        int numDni = Integer.parseInt(parts[0]);
        char[] letra = parts[1].toUpperCase().toCharArray();

        posicion2 = numDni % 23;

        if (letra[0] == arrayLetras[posicion2]) {
            System.out.println("DNI OK");
            return true;
        } else {
            System.out.println("DNI KO");
            return false;
        }
    }
}

