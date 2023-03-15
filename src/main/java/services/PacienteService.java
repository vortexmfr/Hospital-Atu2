package services;

import dto.PacienteDto;
import dto.PersonaDto;
import entity.Paciente;
import repository.PacienteRepository;

public class PacienteService {
    
    private static PacienteRepository  pacienteRepository;
    private static PersonaService  personaService = new PersonaService();

    public static void initService() {
        pacienteRepository = new PacienteRepository();
    }

    public boolean createPaciente(PacienteDto pacienteDto) throws Exception {
        
        if (personaService.createPersona(new PersonaDto(pacienteDto.getDni(), pacienteDto.getFirstName(), pacienteDto.getLastName(), pacienteDto.getBirthdate(), pacienteDto.getPassword(), pacienteDto.getEmail(), pacienteDto.getRole()))) {
            return pacienteRepository.create(toEntity(pacienteDto));
        }
        
        return false;
    }
    
    private PacienteDto toDto(Paciente paciente) {
        return new PacienteDto(paciente.getDniPersona(), paciente.getHistoricId(), paciente.getUrgencyLevel(), paciente.getDeseaseId());
    }

    private Paciente toEntity(PacienteDto pacienteDto) {
        return new Paciente(pacienteDto.getDniPersona(), pacienteDto.getHistoricId(), pacienteDto.getUrgencyLevel(), pacienteDto.getDeseaseId());
    }
}
