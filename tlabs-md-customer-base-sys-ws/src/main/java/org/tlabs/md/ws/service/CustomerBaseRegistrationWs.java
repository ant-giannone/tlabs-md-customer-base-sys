package org.tlabs.md.ws.service;

import org.tlabs.md.ws.dto.NewUserRegistrationRequest;
import org.tlabs.md.ws.dto.NewUserRegistrationResponse;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name="CustomerBaseRegistrationN")
public interface CustomerBaseRegistrationWs {

    @WebMethod(operationName="newRegistrationOpN")
    public NewUserRegistrationResponse newUserRegistration(
            @WebParam(name = "userRegistrationRequest",
                    mode = WebParam.Mode.IN) NewUserRegistrationRequest userRegistrationRequest);
}
