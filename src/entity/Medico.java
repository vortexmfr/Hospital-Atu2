package entity;

import utils.UBICACION;

import java.time.LocalDate;

public class Medico extends Persona {

    private String numColegiado;
    private String especialidad;

    public Medico(String dni, String nombre, String apellido, LocalDate fechaNacimiento, String usuario, String password, UBICACION estancia, String numColegiado, String especialidad) {
        super(dni, nombre, apellido, fechaNacimiento, usuario, password, estancia);
        this.numColegiado = numColegiado;
        this.especialidad = especialidad;
    }

    public String getNumColegiado() {
        return numColegiado;
    }

    public void setNumColegiado(String numColegiado) {
        this.numColegiado = numColegiado;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "numColegiado='" + numColegiado + '\'' +
                ", especialidad='" + especialidad + '\'' +
                '}';
    }
}
