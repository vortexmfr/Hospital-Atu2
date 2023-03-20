/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import dto.MedicoDto;
import java.util.List;

/**
 *
 * @author Rostro
 */
public interface MedicoService {
    
    public void initService();
    
    public List<MedicoDto> getAll() throws Exception;
    
    public MedicoDto getById(String dni) throws Exception;
    
    public void imprimirPacientes(String user) throws Exception;
}
