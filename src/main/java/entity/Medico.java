package entity;

import java.util.Date;

public class Medico extends Persona {

    private String numColegiado;
    private String especialidad;

    public Medico(String dni, String firstName, String lastName, Date birthdate, String password, String email, String role, String numColegiado, String especialidad) {
        super(dni, firstName, lastName, birthdate, password, email, role);
        this.numColegiado = numColegiado;
        this.especialidad = especialidad;
    }

    /*
    public Medico(String numColegiado, String especialidad) {
        this.numColegiado = numColegiado;
        this.especialidad = especialidad;
    }
     */
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
        return "Medico{" + super.toString()
                + "numColegiado='" + numColegiado + '\''
                + ", especialidad='" + especialidad + '\''
                + '}';
    }
}
