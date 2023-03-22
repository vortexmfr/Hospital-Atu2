package dto;

import java.util.Date;

public class PacienteDto extends PersonaDto {

    private String dniPersona;
    private int urgencyLevel;
    private String deseaseId;
    private int historicId;
    private String ubication;

    public PacienteDto() {
        super();
    }

    public PacienteDto(int historicId, Integer urgencyLevel, String deseaseId, String dni, String firstName, String lastName, Date birthdate, String password, String email, String role) {
        super(dni, firstName, lastName, birthdate, password, email, role);
        this.historicId = historicId;
        this.urgencyLevel = urgencyLevel;
        this.deseaseId = deseaseId;
    }

    public PacienteDto(String dniPersona, int historicId, int urgencyLevel, String deseaseId) {
        this.historicId = historicId;
        this.urgencyLevel = urgencyLevel;
        this.deseaseId = deseaseId;
        this.dniPersona = dniPersona;
    }

    @Override
    public String toString() {
        return super.toString() + ",\t urgencyLevel=" + urgencyLevel + ",\t deseaseId=" + deseaseId + ",\t historicId=" + historicId + "}";
    }

    public String getDniPersona() {
        return dniPersona;
    }

    public void setDniPersona(String dniPersona) {
        this.dniPersona = dniPersona;
    }

    public int getUrgencyLevel() {
        return urgencyLevel;
    }

    public void setUrgencyLevel(int urgencyLevel) {
        this.urgencyLevel = urgencyLevel;
    }

    public String getDeseaseId() {
        return deseaseId;
    }

    public void setDeseaseId(String deseaseId) {
        this.deseaseId = deseaseId;
    }

    public int getHistoricId() {
        return historicId;
    }

    public void setHistoricId(int historicId) {
        this.historicId = historicId;
    }

    public String getUbication() {
        return ubication;
    }

    public void setUbication(String ubication) {
        this.ubication = ubication;
    }

}
