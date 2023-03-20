package service;

import dto.EnfermedadDto;

public interface EnfermedadService {
    public EnfermedadDto getById(String id) throws Exception;
    public void create(EnfermedadDto enfermedad) throws Exception;
    public boolean delete (EnfermedadDto enfermedad) throws Exception;
    public void update(EnfermedadDto enfermedad) throws Exception;
}
