package services;

import dto.EnfermeroDto;
import dto.MedicoDto;
import dto.PacienteDto;
import entity.Enfermero;
import entity.Medico;
import entity.Paciente;
import java.util.ArrayList;
import java.util.List;

import repository.EnfermeroRepository;
import repository.MedicoRepository;
import repository.PacienteRepository;

public class EnfermeroService {

    public static List<EnfermeroDto> getAll() {
        List<EnfermeroDto> lista = new ArrayList<EnfermeroDto>();
        EnfermeroDto edto = new EnfermeroDto();
        for (Enfermero en : EnfermeroRepository.getAll()) {
            en = new EnfermeroDto();
        }
        return lista;
    }
}