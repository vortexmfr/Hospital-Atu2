package serviceimpl;

import dto.EspecialidadDto;
import entity.Especialidad;
import repository.EspecialidadRepository;

import java.util.ArrayList;
import java.util.List;
import service.EspecialidadService;

public class EspecialidadServiceImpl implements EspecialidadService{

    private EspecialidadRepository especialidadRepository = new EspecialidadRepository();

    public List<EspecialidadDto> getAll() throws Exception {
        List<EspecialidadDto> lista = new ArrayList<>();
        EspecialidadDto dto;
        List<Especialidad> especialidades = especialidadRepository.getAll();

        for (Especialidad especialidad : especialidades) {
            dto = toDto(especialidad);
            lista.add(dto);
        }

        return lista;
    }

    public EspecialidadDto getById(String id) throws Exception {
        Especialidad especialidad = especialidadRepository.getById(id);
        return toDto(especialidad);
    }

    public void create(EspecialidadDto especialidad) throws Exception {

        especialidadRepository.create(toEntity(especialidad));
    }

    public boolean delete (EspecialidadDto especialidad) throws Exception {

        return (especialidadRepository.delete(especialidad));

    }

    public void update(EspecialidadDto especialidad) throws Exception {
        especialidadRepository.update(toEntity(especialidad));
    }

    private EspecialidadDto toDto(Especialidad especialidad) {
        return new EspecialidadDto(especialidad.getId(), especialidad.getEspecialidad());
    }

    private Especialidad toEntity(EspecialidadDto especialidadDto) {
        return new Especialidad(especialidadDto.getId(),especialidadDto.getEspecialidad());
    }
}
