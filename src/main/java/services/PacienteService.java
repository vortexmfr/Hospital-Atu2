package services;

import dto.PacienteDto;
import dto.PersonaDto;
import entity.Paciente;
import entity.Persona;
import java.util.ArrayList;
import java.util.List;
import repository.PacienteRepository;
//import org.apache.commons.lang3.CollectionUtils;

public class PacienteService {

    private static PacienteRepository pacienteRepository;
    private static PersonaService personaService = new PersonaService();

    public static void initService() {
        pacienteRepository = new PacienteRepository();
    }

    public boolean createPaciente(PacienteDto pacienteDto) throws Exception {

        if (personaService.createPersona(new PersonaDto(pacienteDto.getDni(), pacienteDto.getFirstName(), pacienteDto.getLastName(), pacienteDto.getBirthdate(), pacienteDto.getPassword(), pacienteDto.getEmail(), "patient"))) {
            return pacienteRepository.create(toEntity(pacienteDto));
        }
        return false;
    }
    
    
    public List<PacienteDto> getAll() throws Exception {
        List<PacienteDto> lista = new ArrayList<>();
        PacienteDto dto;
        List<Paciente> pacientes = pacienteRepository.getAll();

        for (Paciente paciente : pacientes) {
            dto = toDto(paciente);
            lista.add(dto);
        }

        return lista;
    }

    public List<PacienteDto> getAllByField(String field, String value) throws Exception {
      //  List<PacienteDto> personas = personaService.getAllByField(field, value);
        
        List<PacienteDto> pacientes = getAll();
//        if (CollectionUtils.is) {    
//        }
        // Persona
        for (PacienteDto paciente : pacientes) {
           PersonaDto persona = personaService.getById(paciente.getDni());
            
            paciente.setFirstName(persona.getFirstName());
            paciente.setLastName(persona.getLastName());
            paciente.setDni(persona.getDni());
            paciente.setPassword(persona.getPassword());
            paciente.setEmail(persona.getEmail());
            paciente.setRole(persona.getRole());
            
            pacientes.add(paciente);
        }
        return pacientes;
    }

    private PacienteDto toDto(Paciente paciente) {
        return new PacienteDto(paciente.getDniPersona(), paciente.getHistoricId(), paciente.getUrgencyLevel(), paciente.getDeseaseId());
    }

    private Paciente toEntity(PacienteDto pacienteDto) {
        return new Paciente(pacienteDto.getDniPersona(), pacienteDto.getHistoricId(), pacienteDto.getUrgencyLevel(), pacienteDto.getDeseaseId());
    }
}
