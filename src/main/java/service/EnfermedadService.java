package service;

import dto.EnfermedadDto;
import java.util.List;

public interface EnfermedadService {
    public EnfermedadDto getById(String id) throws Exception;
    public void create(EnfermedadDto enfermedad) throws Exception;
    public boolean delete (EnfermedadDto enfermedad) throws Exception;
    public void update(EnfermedadDto enfermedad) throws Exception;
    public List<EnfermedadDto> getAll() throws Exception;
}
