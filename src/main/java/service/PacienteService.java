/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import dto.PacienteDto;
import java.util.List;

/**
 *
 * @author Rostro
 */
public interface PacienteService {

    public List<PacienteDto> getAllByField(String field, String value) throws Exception;

    public List<PacienteDto> getAll() throws Exception;

    public boolean createPaciente(PacienteDto pacienteDto) throws Exception;
}
