package dto;

import java.time.LocalDate;
import java.util.List;
import utils.UBICACION;

public class MedicoDto extends PersonaDto {
        private String colegiatenumber;
        private String speciality;

    public MedicoDto(String dni, String nombre, String apellido, LocalDate fechaNacimiento, String usuario, String password, String colegiatenumber, String speciality) {
        super(dni, nombre, apellido, fechaNacimiento, usuario, password);
        this.colegiatenumber = colegiatenumber;
        this.speciality = speciality;
    }

    public String getColegiatenumber() {
        return colegiatenumber;
    }

    public void setColegiatenumber(String colegiatenumber) {
        this.colegiatenumber = colegiatenumber;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return "MedicoDto{" +
                "colegiatenumber='" + colegiatenumber + '\'' +
                ", speciality='" + speciality + '\'' +
                '}';
    }
}

