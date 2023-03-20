package services;

import dto.PacienteDto;
import dto.PersonaDto;
import entity.Paciente;

import java.util.ArrayList;
import java.util.List;
import repository.PacienteRepository;

public class PacienteService {

    private static PacienteRepository pacienteRepository = new PacienteRepository();

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


    public static List<PacienteDto> getAll() throws Exception {
        List<PacienteDto> lista = new ArrayList<>();
        PacienteDto dto;
        List<Paciente> pacientes = pacienteRepository.getAll();

        for (Paciente paciente : pacientes) {
            dto = toDto(paciente);
            lista.add(dto);
        }

        return lista;
    }

    public static List<PacienteDto> getAllByField(String field, String value) throws Exception {
        //  List<PacienteDto> personas = personaService.getAllByField(field, value);

        List<PacienteDto> pacientes = PacienteService.getAll();
        int ps = pacientes.size();
        // Persona
       for (int i = 0; i < ps; i++) {

            PersonaDto persona = personaService.getById(pacientes.get(i).getDniPersona());

            pacientes.get(i).setFirstName(persona.getFirstName());
            pacientes.get(i).setLastName(persona.getLastName());
            pacientes.get(i).setDni(persona.getDni());
            pacientes.get(i).setPassword(persona.getPassword());
            pacientes.get(i).setEmail(persona.getEmail());
            pacientes.get(i).setRole(persona.getRole());

            pacientes.add(pacientes.get(i));
       }
       return pacientes;
    }

    private static PacienteDto toDto(Paciente paciente) {
        return new PacienteDto(paciente.getDniPersona(), paciente.getHistoricId(), paciente.getUrgencyLevel(), paciente.getDeseaseId());
    }

    private Paciente toEntity(PacienteDto pacienteDto) {
        return new Paciente(pacienteDto.getDniPersona(), pacienteDto.getHistoricId(), pacienteDto.getUrgencyLevel(), pacienteDto.getDeseaseId());
    }
}