package entity;

import utils.UBICACION;

import java.time.LocalDate;

public class Persona {

    private String dni;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String usuario;
    private String password;
    private UBICACION estancia;

    public Persona(String dni, String nombre, String apellido, LocalDate fechaNacimiento, String usuario, String password, UBICACION estancia) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.usuario = usuario;
        this.password = password;
        this.estancia = estancia;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UBICACION getEstancia() {
        return estancia;
    }

    public void setEstancia(UBICACION estancia) {
        this.estancia = estancia;
    }
}
