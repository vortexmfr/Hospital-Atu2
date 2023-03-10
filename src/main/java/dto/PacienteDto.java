package dto;

import java.time.LocalDate;
import java.util.List;
import utils.UBICACION;

public class PacienteDto extends PersonaDto{
    private String NHC;
    private Integer urgencia;

    private List<String> enfermedades;

    public PacienteDto(String dni, String nombre, String apellido, LocalDate fechaNacimiento, String usuario, String password, String NHC) {
        super(dni, nombre, apellido, fechaNacimiento, usuario, password);
        this.NHC = NHC;
    }

    public String getNHC() {
        return NHC;
    }

    public void setNHC(String NHC) {
        this.NHC = NHC;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "NHC='" + NHC + '\'' +
                '}';
    }
}