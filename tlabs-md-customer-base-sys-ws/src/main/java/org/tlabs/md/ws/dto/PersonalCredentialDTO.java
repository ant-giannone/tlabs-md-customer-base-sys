package org.tlabs.md.ws.dto;

public class PersonalCredentialDTO {

    private String username;

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
