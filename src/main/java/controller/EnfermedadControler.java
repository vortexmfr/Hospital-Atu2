package controller;

import dto.EnfermedadDto;
import repository.EnfermedadRepository;
import services.EnfermedadService;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class EnfermedadControler {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    private static EnfermedadService enfermedadService = new EnfermedadService();

    public static void altaEnfermedad () throws Exception {
        System.out.println("Id de la enfermedad:");
        int id =  Integer.parseInt(buffer.readLine());
        System.out.println("Introduce la Enfermedad:");
        String enf = buffer.readLine();
        System.out.println("Introduce Tiempo medio de curación:");
        int tiempo = Integer.parseInt(buffer.readLine());

        EnfermedadDto enfermedadDto = new EnfermedadDto(id,enf,tiempo);

        enfermedadService.getAll();
        //enfermedadService.create(enfermedadDto);
        System.out.println("Created: " + enfermedadDto.toString());
        enfermedadService.getAll();
        enfermedadService.getById(String.valueOf(id));
        //enfermedadService.delete(enfermedadDto);
        System.out.println("Delete: " + enfermedadDto.toString());
        enfermedadService.getAll();
        enfermedadService.update(enfermedadDto);
        System.out.println("Update: " + enfermedadDto.toString());
        enfermedadService.getAll();
    };
}
