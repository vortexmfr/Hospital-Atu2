package services;

import dto.PersonaDto;
import entity.Persona;
import java.util.ArrayList;
import java.util.List;
import repository.PersonaRepository;
import utils.*;
import utils.RepositoryUtils;
/**
 *
 * @author Rostro
 */
public class PersonaService {

    private static PersonaRepository  personaRepository;

    public static void initService() {
        personaRepository = new PersonaRepository();
    }


    public List<PersonaDto> getAll() throws Exception {
        List<PersonaDto> lista = new ArrayList<>();
        PersonaDto dto;
        List<Persona> personas = personaRepository.getAll();

        for (Persona persona : personas) {
            dto = toDto(persona);
            lista.add(dto);
        }

        return lista;
    }

    public List<PersonaDto> getAllByField(String field, String value) throws Exception {
        List<PersonaDto> lista = new ArrayList<>();
        PersonaDto dto;
        List<Persona> personas = personaRepository.getAllByField(field, value);

        for (Persona persona : personas) {
            dto = toDto(persona);
            lista.add(dto);
        }

        return lista;
    }

    public boolean createPersona(PersonaDto personaDto) throws Exception {
        return personaRepository.create(toEntity(personaDto));
    }

    public PersonaDto getById(String dni) throws Exception {
        Persona persona = repository.PersonaRepository.getById(dni);
        return toDto(persona);
    }

    private PersonaDto toDto(Persona persona) {
        return new PersonaDto(persona.getDni(), persona.getFirstName(), persona.getLastName(), persona.getBirthdate(), persona.getPassword(), persona.getEmail(), persona.getRole());
    }

    private Persona toEntity(PersonaDto personaDto) {
        return new Persona(personaDto.getDni(), personaDto.getFirstName(), personaDto.getLastName(), personaDto.getBirthdate(), personaDto.getPassword(), personaDto.getEmail(), personaDto.getRole());
    }
}