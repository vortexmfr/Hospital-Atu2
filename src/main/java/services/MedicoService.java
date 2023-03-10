package services;

import dto.MedicoDto;
import entity.Medico;
import repository.MedicoRepository;

import java.util.ArrayList;
import java.util.List;

public class MedicoService {

    private static MedicoRepository  medicoRepository;

    public static void initService() {
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

    private MedicoDto toDto(Medico medico) {
        return new MedicoDto(medico.getDni(), medico.getFirstName(), medico.getLastName(), medico.getBirthdate(), medico.getPassword(), medico.getEmail(), medico.getRole(), medico.getNumColegiado(), medico.getEspecialidad());
    }

    private Medico toEntity(MedicoDto medicoDto) {
        return new Medico(medicoDto.getDni(), MedicoDto.getFirstName(), medicoDto.getLastName(), medicoDto.getBirthdate(), medicoDto.getPassword(), medicoDto.getEmail(), medicoDto.getRole(), medicoDto.getNumColegiado(), medicoDto.getEspecialidad());
    }
}
