package org.tlabs.md.ptl.ws.soap;

import org.tlabs.md.ptl.ws.dto.NewUserRegistrationRequest;
import org.tlabs.md.ptl.ws.dto.NewUserRegistrationResponse;

import javax.jws.WebService;

@WebService(
        endpointInterface = "org.tlabs.md.ptl.ws.soap.CustomerBaseWs",
        serviceName = "CustomerBaseManagerWs"
)
public class CustomerBaseWsImpl implements CustomerBaseWs {

    public CustomerBaseWsImpl() {
    }

    @Override
    public NewUserRegistrationResponse newUserRegistration(NewUserRegistrationRequest userRegistrationRequest) {
        return null;
    }
}
