/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dto.PersonaDto;
import entity.Persona;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rostro
 */
public class PersonaService {
                
    public static List<PersonaDto> getAll() throws Exception {
        List<PersonaDto> lista = new ArrayList<>();
        PersonaDto dto;
        List<Persona> personas = repository.PersonaRepository.getAll();
        
        for (Persona persona : personas) {
            dto = toDto(persona);
            lista.add(dto);
        }
        
        return lista;
    }
    
    
    private static PersonaDto toDto(Persona persona) {
        return new PersonaDto(persona.getDni(), persona.getFirstName(), persona.getLastName(), persona.getBirthdate(), persona.getPassword(), persona.getEmail(), persona.getRole());
    }
    
    private static Persona toEntity(PersonaDto personaDto) {
        return new Persona(personaDto.getDni(), personaDto.getFirstName(), personaDto.getLastName(), personaDto.getBirthdate(), personaDto.getPassword(), personaDto.getEmail(), personaDto.getRole());
    }
}
