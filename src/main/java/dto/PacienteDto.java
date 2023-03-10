package dto;

import java.util.Date;

public class PacienteDto extends PersonaDto {

    private String historicId;
    private Integer urgencyLevel;
    private String deseaseId;

    public PacienteDto() {
        super();
    }

    public PacienteDto(String historicId, Integer urgencyLevel, String deseaseId, String dni, String firstName, String lastName, Date birthdate, String password, String email, String role) {
        super(dni, firstName, lastName, birthdate, password, email, role);
        this.historicId = historicId;
        this.urgencyLevel = urgencyLevel;
        this.deseaseId = deseaseId;
    }

    public String getHistoricId() {
        return historicId;
    }

    public void setHistoricId(String historicId) {
        this.historicId = historicId;
    }

    public Integer getUrgencyLevel() {
        return urgencyLevel;
    }

    public void setUrgencyLevel(Integer urgencyLevel) {
        this.urgencyLevel = urgencyLevel;
    }

    public String getDeseaseId() {
        return deseaseId;
    }

    public void setDeseaseId(String deseaseId) {
        this.deseaseId = deseaseId;
    }

}
