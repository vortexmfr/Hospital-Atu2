package services;

import dto.PacienteDto;
import entity.Paciente;
import java.util.ArrayList;
import java.util.List;
import repository.PacienteRepository;

public class PacienteService {

    public static List<PacienteDto> getAll() {
        List<PacienteDto> lista = new ArrayList<PacienteDto>();
        PacienteDto dto = new PacienteDto();
        for (Paciente pa : PacienteRepository.getAll()) {
            dto = new PacienteDto();
        }
        return lista;
    }
}
