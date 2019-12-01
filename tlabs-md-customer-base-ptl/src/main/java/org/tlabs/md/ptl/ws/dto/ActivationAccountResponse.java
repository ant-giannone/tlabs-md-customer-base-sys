package org.tlabs.md.ptl.ws.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "activationAccountResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class ActivationAccountResponse {

    @XmlElement(name="operationCode", required = true)
    private String operationCode;

    @XmlElement(name="systemMessage")
    private String messageInfo;

    public ActivationAccountResponse() {
    }

    public ActivationAccountResponse(String operationCode, String messageInfo) {
        this.operationCode = operationCode;
        this.messageInfo = messageInfo;
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
}
