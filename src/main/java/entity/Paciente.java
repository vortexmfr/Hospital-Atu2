package entity;

import utils.UBICACION;

import java.util.Date;
import java.util.List;

public class Paciente extends Persona {

    String dniPersona;
    private Integer urgencyLevel;
    String deseaseId;
    private String historicId;
    private String ubication;

    public Paciente(String dniPersona, String historicId, Integer urgencyLevel, String deseaseId, String firstName, String lastName, Date birthdate, String password, String email, String role) {
        super(dniPersona, firstName, lastName, birthdate, password, email, role);
        this.historicId = historicId;
        this.urgencyLevel = urgencyLevel;
        this.deseaseId = deseaseId;
        this.dniPersona = dniPersona;
    }

    public Paciente(String dniPersona, String historicId, Integer urgencyLevel, String deseaseId) {
        this.historicId = historicId;
        this.urgencyLevel = urgencyLevel;
        this.deseaseId = deseaseId;
        this.dniPersona = dniPersona;
    }

    public Paciente() {
    }

    public String getDniPersona() {
        return dniPersona;
    }

    public void setDniPersona(String dniPersona) {
        this.dniPersona = dniPersona;
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

    @Override
    public String toString() {
        return "Paciente{" + "dniPersona=" + dniPersona + ", urgencyLevel=" + urgencyLevel + ", deseaseId=" + deseaseId + ", historicId=" + historicId + '}';
    }
    
    
}