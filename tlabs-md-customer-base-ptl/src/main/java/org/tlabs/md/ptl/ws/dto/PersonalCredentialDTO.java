package org.tlabs.md.ptl.ws.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(
        name = "personalCredential",
        namespace = "md-poc.tlabs.org"
)
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonalCredentialDTO {

    @XmlElement(name="username", required = true)
    private String username;

    @XmlElement(name="password", required = true)
    private String password;

    public PersonalCredentialDTO() {
    }

    public PersonalCredentialDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
