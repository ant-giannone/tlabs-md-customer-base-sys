package org.tlabs.md.ptl.ws.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(
        name = "personalContact",
        namespace = "md-poc.tlabs.org"
)
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonalContactDTO {

    @XmlElement(name="emailAddress", required = true)
    private String emailAddress;

    @XmlElement(name="mobilePhoneNumber")
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
