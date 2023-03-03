package dto;

import utils.UBICACION;

import java.time.LocalDate;

public class EnfermeroDto extends PersonaDto {

    private String collegiatenumber;
    private String speciality;


    public EnfermeroDto(String dni, String nombre, String apellido, LocalDate fechaNacimiento, String usuario, String password) {
        super(dni, nombre, apellido, fechaNacimiento, usuario, password);
        this.collegiatenumber = collegiatenumber;
        this.speciality = speciality;
    }

    public String getCollegiatenumber() {
        return collegiatenumber;
    }

    public void setCollegiatenumber(String collegiatenumber) {
        this.collegiatenumber = collegiatenumber;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return "EnfermeroDto{" +
                "collegiatenumber='" + collegiatenumber + '\'' +
                ", speciality='" + speciality + '\'' +
                '}';
    }
}
