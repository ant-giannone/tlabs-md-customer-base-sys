package org.tlabs.md.ptl.ws;

import org.tlabs.md.ptl.ws.dto.FaultRegistrationInfo;

import javax.xml.ws.WebFault;

@WebFault
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
