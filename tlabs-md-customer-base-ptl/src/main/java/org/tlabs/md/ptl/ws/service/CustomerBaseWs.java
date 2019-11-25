package org.tlabs.md.ptl.ws.service;

import org.apache.cxf.annotations.SchemaValidation;
import org.tlabs.md.ptl.ws.dto.ActivationAccountRequest;
import org.tlabs.md.ptl.ws.dto.ActivationAccountResponse;
import org.tlabs.md.ptl.ws.dto.NewUserRegistrationRequest;
import org.tlabs.md.ptl.ws.dto.NewUserRegistrationResponse;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SchemaValidation(type = SchemaValidation.SchemaValidationType.BOTH)
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface CustomerBaseWs {

    @WebMethod(operationName="newUserRegistration")
    @WebResult
    public NewUserRegistrationResponse newUserRegistration(
            @WebParam NewUserRegistrationRequest userRegistrationRequest);

    @WebMethod(operationName="accountActivation")
    @WebResult
    public ActivationAccountResponse activationAccount(
            @WebParam ActivationAccountRequest activationAccountRequest);
}
