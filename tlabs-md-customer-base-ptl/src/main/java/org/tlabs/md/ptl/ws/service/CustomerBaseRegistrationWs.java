package org.tlabs.md.ptl.ws.service;

import org.apache.cxf.annotations.SchemaValidation;
import org.tlabs.md.ptl.ws.dto.NewUserRegistrationRequest;
import org.tlabs.md.ptl.ws.dto.NewUserRegistrationResponse;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@SchemaValidation(type = SchemaValidation.SchemaValidationType.BOTH)
@SOAPBinding(style = SOAPBinding.Style.RPC)
@WebService(name="CustomerBaseRegistrationN")
public interface CustomerBaseRegistrationWs {

    @WebMethod(operationName="newRegistration")
    @WebResult(name = "newUserRegistrationResponse")
    @RequestWrapper(className="org.tlabs.md.ptl.ws.dto.NewUserRegistrationRequest")
    @ResponseWrapper(className="org.tlabs.md.ptl.ws.dto.NewUserRegistrationResponse")
    public NewUserRegistrationResponse newUserRegistration(
            @WebParam(name="userRegistrationRequest",
                    mode= WebParam.Mode.IN) NewUserRegistrationRequest userRegistrationRequest);
}
