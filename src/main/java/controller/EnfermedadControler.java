package controller;

import dto.EnfermedadDto;
import services.EnfermedadService;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class EnfermedadControler {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

    public static void altaEnfermedad () throws Exception {
        System.out.println("Id de la enfermedad:");
        int id =  Integer.parseInt(buffer.readLine());
        System.out.println("Introduce la Enfermedad:");
        String enf = buffer.readLine();
        System.out.println("Introduce Tiempo medio de curación:");
        int tiempo = Integer.parseInt(buffer.readLine());

        EnfermedadDto enfermedadDto = new EnfermedadDto(id,enf,tiempo);

        EnfermedadService.create(enfermedadDto);

    };
}
