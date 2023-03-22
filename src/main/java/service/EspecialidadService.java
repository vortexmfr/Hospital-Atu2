package service;

import java.util.List;
import dto.EspecialidadDto;

public interface EspecialidadService {
    public List<EspecialidadDto> getAll() throws Exception;
    public EspecialidadDto getById(String id) throws Exception;
    public void create(EspecialidadDto especialidad) throws Exception;
    public boolean delete (EspecialidadDto especialidad) throws Exception;
    public void update(EspecialidadDto especialidad) throws Exception;
}
