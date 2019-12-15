package org.tlabs.md.ws.dto;

public class PersonalContactDTO {

    private String emailAddress;

    private String mobilePhoneNumber;

    public PersonalContactDTO() {
    }

    public PersonalContactDTO(String emailAddress, String mobilePhoneNumber) {
        this.emailAddress = emailAddress;
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    @Override
    public String toString() {
        return "PersonalContactDTO{" +
                "emailAddress='" + emailAddress + '\'' +
                ", mobilePhoneNumber='" + mobilePhoneNumber + '\'' +
                '}';
    }
}
