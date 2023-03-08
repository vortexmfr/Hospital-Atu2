package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LoginController {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    public static void UserValidation () throws IOException {
        System.out.println("Introduce tu DNI");
        String user = buffer.readLine();
        System.out.println("Introduce la password:");
        String password = buffer.readLine();

    };

}
