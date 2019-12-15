package org.tlabs.md.ws.exception;

import org.tlabs.md.ws.dto.FaultRegistrationInfo;

public class UserRegistrationException extends RuntimeException {
    private FaultRegistrationInfo faultRegistrationInfo;

    public UserRegistrationException(FaultRegistrationInfo faultRegistrationInfo) {
        super();
        this.faultRegistrationInfo = faultRegistrationInfo;
    }

    public FaultRegistrationInfo getFaultRegistrationInfo() {
        return faultRegistrationInfo;
    }
}
