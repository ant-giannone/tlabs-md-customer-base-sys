package org.tlabs.md.ws.service;

import org.tlabs.md.ws.dto.ActivationAccountRequest;
import org.tlabs.md.ws.dto.ActivationAccountResponse;
import org.tlabs.md.ws.dto.IdentificationProcedureRequest;
import org.tlabs.md.ws.dto.IdentificationProcedureResponse;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name="CustomerBaseGeneralN")
public interface CustomerBaseWs {

    @WebMethod(operationName="accountActivationOpN")
    public ActivationAccountResponse activationAccountAction(
            @WebParam(name = "activationAccountRequest",
                    mode = WebParam.Mode.IN) ActivationAccountRequest activationAccountRequest);

    @WebMethod(operationName="identificationProcedureOpN")
    public IdentificationProcedureResponse identificationProcedureAction(
            @WebParam(name = "identificationProcedureRequest",
                    mode = WebParam.Mode.IN) IdentificationProcedureRequest identificationProcedureRequest);
}
