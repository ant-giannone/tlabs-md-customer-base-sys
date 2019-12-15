package org.tlabs.md.ws.dto;

import javax.xml.bind.annotation.XmlType;

public class ActivationAccountResponse {

    private String operationCode;

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
