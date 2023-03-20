package service;

import dto.EnfermedadDto;
import dto.EspecialidadDto;
import dto.PacienteDto;

import java.util.List;

public interface EspecialidadServices {
    public List<EspecialidadDto> getAll() throws Exception;
    public EspecialidadDto getById(String id) throws Exception;
    public void create(EspecialidadDto especialidad) throws Exception;
    public boolean delete (EspecialidadDto especialidad) throws Exception;
    public void update(EspecialidadDto especialidad) throws Exception;

}
