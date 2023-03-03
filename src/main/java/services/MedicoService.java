package services;

import dto.MedicoDto;
import dto.PacienteDto;
import entity.Medico;
import entity.Paciente;
import java.util.ArrayList;
import java.util.List;

import repository.MedicoRepository;
import repository.PacienteRepository;

public class MedicoService {

    public static List<MedicoDto> getAll() {
        List<MedicoDto> lista = new ArrayList<MedicoDto>();
        MedicoDto mdto = new MedicoDto();
        for (Medico me : MedicoRepository.getAll()) {
            me = new MedicoDto();
        }
        return lista;
    }
}