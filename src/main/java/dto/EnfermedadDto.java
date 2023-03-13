package dto;

public class EnfermedadDto {
    private int id;
    private String enfermedad;
    private int tiempo;

    public EnfermedadDto(int id, String enfermedad, int tiempo) {
        this.id = id;
        this.enfermedad = enfermedad;
        this.tiempo = tiempo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public String toString() {
        return "EnfermedadDto{" +
                "id=" + id +
                ", enfermedad='" + enfermedad + '\'' +
                ", tiempo=" + tiempo +
                '}';
    }
}
