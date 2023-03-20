/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import dto.EnfermedadDto;
import java.util.List;

/**
 *
 * @author Rostro
 */
public interface EnfermeroService {

    public List<EnfermedadDto> getAll() throws Exception;

    public EnfermedadDto getById(String id) throws Exception;

    public void create(EnfermedadDto enfermedad) throws Exception;

    public boolean delete(EnfermedadDto enfermedad) throws Exception;

    public void update(EnfermedadDto enfermedad) throws Exception;
}
