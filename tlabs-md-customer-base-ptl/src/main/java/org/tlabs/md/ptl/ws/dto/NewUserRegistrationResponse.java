package org.tlabs.md.ptl.ws.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.net.URL;

@XmlRootElement(name = "userRegistrationResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class NewUserRegistrationResponse {

    @XmlElement(name="operationCode", required = true)
    private String operationCode;

    @XmlElement(name="systemMessage")
    private String messageInfo;

    @XmlElement(name="accountActivationLink", required = true)
    private URL activationLink;

    @XmlElement(name="accountActivationCode", required = true)
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
