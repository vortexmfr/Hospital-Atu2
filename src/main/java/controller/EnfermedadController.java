package controller;

import dto.EnfermedadDto;
import serviceimpl.EnfermedadService;

import static utils.Types.INT;
import static utils.Types.STRING;
import static utils.Utils.ask;


public class EnfermedadController {
    //Inicializo Service
    private static EnfermedadService enfermedadService = new EnfermedadService();

    public static void altaEnfermedad () throws Exception {

        enfermedadService.getAll();
        System.out.println("=============================================");
        int id = ask("Id de la enfermedad:", INT);
        String enf = ask("Introduce la Enfermedad:", STRING);
        int tiempo = ask("Introduce Tiempo medio de curación:", INT);

        EnfermedadDto enfermedadDto = new EnfermedadDto(id,enf,tiempo);

        enfermedadService.create(enfermedadDto);

    };

    public static void bajaEnfermedad () throws Exception {

        enfermedadService.getAll();

        int id = ask("Id de la enfermedad:", INT);
        String enf = ask("Introduce la Enfermedad:", STRING);
        int tiempo = ask("Introduce Tiempo medio de curación:", INT);

        EnfermedadDto enfermedadDto = new EnfermedadDto(id,enf,tiempo);

        enfermedadService.delete(enfermedadDto);
        enfermedadService.getAll();
    };


}