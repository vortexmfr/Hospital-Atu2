package entity;

public class Enfermedad {

    private String enfermedad;
    private String especialidad;
    private int tiempo;

    public Enfermedad(String enfermedad, String especialidad, int tiempo) {
        this.enfermedad = enfermedad;
        this.especialidad = especialidad;
        this.tiempo = tiempo;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public String toString() {
        return "Enfermedad{" +
                "enfermedad='" + enfermedad + '\'' +
                ", especialidad='" + especialidad + '\'' +
                ", tiempo=" + tiempo +
                '}';
    }
}
