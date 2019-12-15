package org.tlabs.md.ws.dto;

import java.net.URL;

public class NewUserRegistrationResponse {

    private String operationCode;

    private String messageInfo;

    private URL activationLink;

    private String activationCode;

    public NewUserRegistrationResponse() {
    }

    public NewUserRegistrationResponse(
            String operationCode,
            String messageInfo,
            URL activationLink) {

        this.operationCode = operationCode;
        this.messageInfo = messageInfo;
        this.activationLink = activationLink;
    }

    public String getOperationCode() {
        return operationCode;
    }

    public void setOperationCode(String operationCode) {
        this.operationCode = operationCode;
    }

    public String getMessageInfo() {
        return messageInfo;
    }

    public void setMessageInfo(String messageInfo) {
        this.messageInfo = messageInfo;
    }

    public URL getActivationLink() {
        return activationLink;
    }

    public void setActivationLink(URL activationLink) {
        this.activationLink = activationLink;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    @Override
    public String toString() {
        return "NewUserRegistrationResponse{" +
                "operationCode='" + operationCode + '\'' +
                ", messageInfo='" + messageInfo + '\'' +
                '}';
    }
}
