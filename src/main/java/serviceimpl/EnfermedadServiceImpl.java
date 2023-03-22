package serviceimpl;

import dto.EnfermedadDto;
import entity.Enfermedad;
import repository.EnfermedadRepository;

import java.util.ArrayList;
import java.util.List;
import service.EnfermedadService;

public class EnfermedadServiceImpl implements EnfermedadService{

    //Inicializo Repository
    private EnfermedadRepository enfermedadRepository = new EnfermedadRepository();

    @Override
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

    public EnfermedadDto getById(String id) throws Exception {
        Enfermedad enfermedad = enfermedadRepository.getById(id);
        return toDto(enfermedad);
    }

    public void create(EnfermedadDto enfermedad) throws Exception {

        enfermedadRepository.create(toEntity(enfermedad));
    }

    public boolean delete (EnfermedadDto enfermedad) throws Exception {

        return (enfermedadRepository.delete(enfermedad));

    }

    public void update(EnfermedadDto enfermedad) throws Exception {
        enfermedadRepository.update(toEntity(enfermedad));
    }

    private EnfermedadDto toDto(Enfermedad enfermedad) {
        return new EnfermedadDto(enfermedad.getId(), enfermedad.getEnfermedad(), enfermedad.getTiempo());
    }

    private Enfermedad toEntity(EnfermedadDto enfermedadDto) {
        return new Enfermedad(enfermedadDto.getId(),enfermedadDto.getEnfermedad(),enfermedadDto.getTiempo());
    }
}
