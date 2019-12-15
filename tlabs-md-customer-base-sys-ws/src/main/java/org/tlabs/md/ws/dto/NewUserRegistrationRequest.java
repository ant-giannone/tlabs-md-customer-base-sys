package org.tlabs.md.ws.dto;

public class NewUserRegistrationRequest {

    private PersonalDataDTO personalData;

    private PersonalContactDTO personalContact;

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
