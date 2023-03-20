/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import dto.PersonaDto;
import entity.Persona;
import java.util.List;

/**
 *
 * @author Rostro
 */
public interface PersonaService {

    public List<PersonaDto> getAll() throws Exception;

    public List<PersonaDto> getAllByField(String field, String value) throws Exception;

    public boolean createPersona(PersonaDto personaDto) throws Exception;

    public PersonaDto getById(String dni) throws Exception;
}
