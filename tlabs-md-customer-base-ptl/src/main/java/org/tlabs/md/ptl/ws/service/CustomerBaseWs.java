package org.tlabs.md.ptl.ws.service;

import org.apache.cxf.annotations.SchemaValidation;
import org.tlabs.md.ptl.ws.dto.ActivationAccountRequest;
import org.tlabs.md.ptl.ws.dto.ActivationAccountResponse;
import org.tlabs.md.ptl.ws.dto.IdentificationProcedureRequest;
import org.tlabs.md.ptl.ws.dto.IdentificationProcedureResponse;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@SchemaValidation(type = SchemaValidation.SchemaValidationType.BOTH)
@SOAPBinding(style = SOAPBinding.Style.RPC)
@WebService(name="CustomerBaseGeneralN")
public interface CustomerBaseWs {

    @WebMethod(operationName="accountActivation")
    @WebResult(name = "activationAccountResponse")
    @RequestWrapper(className="org.tlabs.md.ptl.ws.dto.ActivationAccountRequest")
    @ResponseWrapper(className="org.tlabs.md.ptl.ws.dto.ActivationAccountResponse")
    public ActivationAccountResponse activationAccount(
            @WebParam(name="activationAccountRequest",
                    mode= WebParam.Mode.IN) ActivationAccountRequest activationAccountRequest);

    @WebMethod(operationName="identificationProcedure")
    @WebResult(name = "identificationProcedureResponse")
    @RequestWrapper(className="org.tlabs.md.ptl.ws.dto.IdentificationProcedureRequest")
    @ResponseWrapper(className="org.tlabs.md.ptl.ws.dto.IdentificationProcedureResponse")
    public IdentificationProcedureResponse identificationProcedure(
            @WebParam(name="identificationProcedureRequest",
                    mode= WebParam.Mode.IN) IdentificationProcedureRequest identificationProcedureRequest);
}
