package serviceimpl;

import dto.MedicoDto;
import dto.PacienteDto;
import entity.Medico;
import java.util.ArrayList;
import java.util.List;
import repository.MedicoRepository;

public class MedicoServiceImpl {
    private  MedicoRepository  medicoRepository;
    private PacienteServiceImpl pacienteService = new PacienteServiceImpl();

    public void initService() {
        medicoRepository = new MedicoRepository();
    }


    public List<MedicoDto> getAll() throws Exception {
        List<MedicoDto> lista = new ArrayList<>();
        MedicoDto dto;
        List<Medico> medicos = medicoRepository.getAll();

        for (Medico medico : medicos) {
            dto = toDto(medico);
            lista.add(dto);
        }

        return lista;
    }

    public MedicoDto getById(String dni) throws Exception {
        Medico medico = repository.MedicoRepository.getById(dni);
        return toDto(medico);
    }

    public void imprimirPacientes(String user) throws Exception {
        List<PacienteDto> pacientes = pacienteService.getAllByField("dni", user );

        for (PacienteDto paciente : pacientes) {
            System.out.println(paciente.toString());
        }
    }

    private MedicoDto toDto(Medico medico) {
        return new MedicoDto(medico.getDni(), medico.getFirstName(), medico.getLastName(), medico.getBirthdate(), medico.getPassword(), medico.getEmail(), medico.getRole(), medico.getNumColegiado(), medico.getEspecialidad());
    }

    private Medico toEntity(MedicoDto medicoDto) {
        return new Medico(medicoDto.getDni(), medicoDto.getFirstName(), medicoDto.getLastName(), medicoDto.getBirthdate(), medicoDto.getPassword(), medicoDto.getEmail(), medicoDto.getRole(), medicoDto.getNumColegiado(), medicoDto.getEspecialidad());
    }
}
