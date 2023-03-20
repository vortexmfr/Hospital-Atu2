package entity;

public class Especialidad {

    private int id;
    private String especialidad;

    public Especialidad(int id, String especialidad) {
        this.id = id;
        this.especialidad = especialidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Especialidad{"
                + "id=" + id
                + ", especialidad='" + especialidad + '\''
                + '}';
    }
}
