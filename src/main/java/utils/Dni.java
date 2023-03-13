package utils;

/*
        Calcula la letra de un DNI, pediremos el DNI por teclado y nos devolverá el DNI completo.
        Para calcular la letra, cogeremos el resto de dividir nuestro dni entre 23, enum el resultado debe estar entre 0 y 22.
        Haz un método donde según el resultado de la anterior formula busque en un array de caracteres la posición que corresponda
         a la letra. Esta es la tabla de caracteres:

        POSICION	LETRA
        0 	T
        1 	R
        2 	W
        3 	A
        4 	G
        5 	M
        6 	Y
        7 	F
        8 	P
        9 	D
        10 	X
        11 	B
        12 	N
        13 	J
        14 	Z
        15 	S
        16 	Q
        17 	V
        18 	H
        19 	L
        20 	C
        21 	K
        22 	E

        Por ejemplo, si introduzco 70588387, el resultado sera de 7 que corresponde a ‘F’.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dni {

    public static void main(String[] args) throws IOException {

        char[] arrayLetras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        String cadena = "";
        int posicion2 = 0;

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Introduce el numero de DNI: ");
        String lectura = buffer.readLine();
        int numDni = Integer.parseInt(lectura);

        posicion2 = numDni % 23;
        System.out.println("El Dni validado es: " + numDni + "-" + arrayLetras[posicion2]);


    }

}
