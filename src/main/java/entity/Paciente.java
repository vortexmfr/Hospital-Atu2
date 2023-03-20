package entity;

import utils.UBICACION;

import java.util.Date;
import java.util.List;

public class Paciente extends Persona {

    String dniPersona;
    private int urgencyLevel;
    String deseaseId;
    private int historicId;
    private String ubication;

    public Paciente(String dniPersona, int historicId, int urgencyLevel, String deseaseId, String firstName, String lastName, Date birthdate, String password, String email, String role) {
        super(dniPersona, firstName, lastName, birthdate, password, email, role);
        this.historicId = historicId;
        this.urgencyLevel = urgencyLevel;
        this.deseaseId = deseaseId;
        this.dniPersona = dniPersona;
    }

    public Paciente(String dniPersona, int historicId, int urgencyLevel, String deseaseId) {
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
    
    public int getHistoricId() {
        return historicId;
    }

    public void setHistoricId(int historicId) {
        this.historicId = historicId;
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

    @Override
    public String toString() {
        return "Paciente{" + "dniPersona=" + dniPersona + ", urgencyLevel=" + urgencyLevel + ", deseaseId=" + deseaseId + ", historicId=" + historicId + '}';
    }
}