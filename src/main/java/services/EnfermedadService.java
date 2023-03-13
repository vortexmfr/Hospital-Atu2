package services;

import dto.EnfermedadDto;
import entity.Enfermedad;
import repository.EnfermedadRepository;

import java.util.ArrayList;
import java.util.List;

public class EnfermedadService {

    private static EnfermedadRepository enfermedadRepository;

    public static void initService() {
        enfermedadRepository = new EnfermedadRepository();
    }


    public List<EnfermedadDto> getAll() throws Exception {
        List<EnfermedadDto> lista = new ArrayList<>();
        EnfermedadDto dto;
        List<Enfermedad> enfermedades = enfermedadRepository.getAll();

        for (Enfermedad enfermedad : enfermedades) {
            dto = toDto(enfermedad);
            lista.add(dto);
        }

        return lista;
    }

    public EnfermedadDto getById(int id) throws Exception {
        Enfermedad enfermedad = repository.EnfermedadRepository.getById(id);
        return toDto(enfermedad);
    }

    public static void create(EnfermedadDto enfermedad) throws Exception {

        enfermedadRepository.create(enfermedad);

    }

    public boolean delete (Enfermedad enfermedad) throws Exception {

        return (enfermedadRepository.delete(enfermedad));

    }

    private EnfermedadDto toDto(Enfermedad enfermedad) {
        return new EnfermedadDto(enfermedad.getId(), enfermedad.getEnfermedad(), enfermedad.getTiempo());
    }

    private Enfermedad toEntity(EnfermedadDto enfermedadDto) {
        return new Enfermedad(enfermedadDto.getId(),enfermedadDto.getEnfermedad(),enfermedadDto.getTiempo());
    }
}
