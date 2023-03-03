package entity;

import utils.UBICACION;

import java.util.Date;
import java.util.List;

public class Paciente extends Persona {

    private String NHC;
    private Integer urgencia;

    private List<String> enfermedades;

    public Paciente(String dni, String nombre, String apellido, Date fechaNacimiento, String usuario, String password, UBICACION estancia, String NHC) {
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
