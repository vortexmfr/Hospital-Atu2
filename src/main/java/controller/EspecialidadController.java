package controller;

import dto.EspecialidadDto;
import serviceimpl.EspecialidadService;

import static utils.Types.INT;
import static utils.Types.STRING;
import static utils.Utils.ask;

public class EspecialidadController {

    //Inicializo Service
    private static EspecialidadService especialidadService = new EspecialidadService();

    public static void altaEspecialidad() throws Exception {
        int id = ask("Id de la especialidad:", INT);
        String esp = ask("Introduce la Especialidad:", STRING);

        EspecialidadDto especialidadDto = new EspecialidadDto(id, esp);

        especialidadService.getAll();
        especialidadService.create(especialidadDto);
        //especialidadService.getById(String.valueOf(id));
        //especialidadService.update(especialidadDto);
        especialidadService.getAll();
    }

    ;

    public static void bajaEspecialidad() throws Exception {

        especialidadService.getAll();

        int id = ask("Id de la especialidad:", INT);
        String esp = ask("Introduce la Especialidad:", STRING);

        EspecialidadDto especialidadDto = new EspecialidadDto(id, esp);

        especialidadService.delete(especialidadDto);

        //especialidadService.getById(String.valueOf(id));
        //especialidadService.update(especialidadDto);
        especialidadService.getAll();
    }
;

}
