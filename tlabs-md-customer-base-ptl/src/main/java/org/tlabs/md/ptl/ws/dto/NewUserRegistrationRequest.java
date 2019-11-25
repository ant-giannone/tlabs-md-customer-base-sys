package org.tlabs.md.ptl.ws.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "userRegistrationRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class NewUserRegistrationRequest {

    @XmlElement(name="personalData", required = true, type = PersonalDataDTO.class)
    private PersonalDataDTO personalData;

    @XmlElement(name="personalContact", required = true, type = PersonalContactDTO.class)
    private PersonalContactDTO personalContact;

    @XmlElement(name="personalCredential", required = true, type = PersonalCredentialDTO.class)
    private PersonalCredentialDTO personalCredential;

    public NewUserRegistrationRequest() {
    }

    public NewUserRegistrationRequest(
            PersonalDataDTO personalData,
            PersonalContactDTO personalContact,
            PersonalCredentialDTO personalCredential) {

        this.personalData = personalData;
        this.personalContact = personalContact;
        this.personalCredential = personalCredential;
    }

    public PersonalDataDTO getPersonalData() {
        return personalData;
    }

    public void setPersonalData(PersonalDataDTO personalData) {
        this.personalData = personalData;
    }

    public PersonalContactDTO getPersonalContact() {
        return personalContact;
    }

    public void setPersonalContact(PersonalContactDTO personalContact) {
        this.personalContact = personalContact;
    }

    public PersonalCredentialDTO getPersonalCredential() {
        return personalCredential;
    }

    public void setPersonalCredential(PersonalCredentialDTO personalCredential) {
        this.personalCredential = personalCredential;
    }

    @Override
    public String toString() {
        return "NewUserRegistrationRequest{" +
                "personalData=" + personalData +
                ", personalContact=" + personalContact +
                '}';
    }
}
