package serviceimpl;

import dto.EnfermeroDto;
import dto.PacienteDto;
import entity.Enfermero;
import repository.EnfermeroRepository;

import java.util.ArrayList;
import java.util.List;

public class EnfermeroServiceImpl {
    private EnfermeroRepository enfermeroRepository = new EnfermeroRepository();
    private PacienteServiceImpl pacienteService = new PacienteServiceImpl();

    public List<EnfermeroDto> getAll() throws Exception {
        List<EnfermeroDto> lista = new ArrayList<>();
        EnfermeroDto dto;
        List<Enfermero> enfermeros = enfermeroRepository.getAll();

        for (Enfermero enfermero : enfermeros) {
            dto = toDto(enfermero);
            lista.add(dto);
        }

        return lista;
    }

    public EnfermeroDto getById(String dni) throws Exception {
        Enfermero enfermero = repository.EnfermeroRepository.getById(dni);
        return toDto(enfermero);
    }

    public void imprimirPacientes(String user) throws Exception {
        List<PacienteDto> pacientes = pacienteService.getAllByField("dni", user );

        for (PacienteDto paciente : pacientes) {
            System.out.println("DNI: " + paciente.getDni()  + "\tNombre: " + paciente.getFirstName() +
                    "\tApellido: " + paciente.getLastName()  +  "\tFecha Nacimiento: " + paciente.getBirthdate() + "\tEmail: " + paciente.getEmail() +
                    "\tUrgencia: " + paciente.getUrgencyLevel()  + "\tEnfermedad: " + paciente.getDeseaseId() +
                    "\tNHC: " + paciente.getHistoricId()  + "\tUbicación: " + paciente.getUbication());
        }
    }

    private EnfermeroDto toDto(Enfermero enfermero) {
        return new EnfermeroDto(enfermero.getDni(), enfermero.getFirstName(), enfermero.getLastName(), enfermero.getBirthdate(), enfermero.getPassword(), enfermero.getEmail(), enfermero.getRole(), enfermero.getNumColegiado(), enfermero.getEspecialidad());
    }

    private Enfermero toEntity(EnfermeroDto enfermeroDto) {
        return new Enfermero(enfermeroDto.getDni(), enfermeroDto.getFirstName(), enfermeroDto.getLastName(), enfermeroDto.getBirthdate(), enfermeroDto.getPassword(), enfermeroDto.getEmail(), enfermeroDto.getRole(), enfermeroDto.getNumColegiado(), enfermeroDto.getEspecialidad());
    }
    
}
