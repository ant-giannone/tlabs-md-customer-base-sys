package org.tlabs.md.ws.dto;

public class IdentificationProcedureRequest {

    private String mainMedicalQualification;
    private String personalIdentificationCode;
    private String fiscalCode;

    public String getMainMedicalQualification() {
        return mainMedicalQualification;
    }

    public void setMainMedicalQualification(String mainMedicalQualification) {
        this.mainMedicalQualification = mainMedicalQualification;
    }

    public String getPersonalIdentificationCode() {
        return personalIdentificationCode;
    }

    public void setPersonalIdentificationCode(String personalIdentificationCode) {
        this.personalIdentificationCode = personalIdentificationCode;
    }

    public String getFiscalCode() {
        return fiscalCode;
    }

    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }
}
