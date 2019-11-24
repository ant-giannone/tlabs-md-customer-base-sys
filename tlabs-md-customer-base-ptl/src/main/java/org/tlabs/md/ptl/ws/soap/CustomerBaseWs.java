package org.tlabs.md.ptl.ws.soap;

import org.apache.cxf.annotations.SchemaValidation;
import org.tlabs.md.ptl.ws.dto.NewUserRegistrationRequest;
import org.tlabs.md.ptl.ws.dto.NewUserRegistrationResponse;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SchemaValidation(type = SchemaValidation.SchemaValidationType.BOTH)
@SOAPBinding(style= SOAPBinding.Style.RPC)
public interface CustomerBaseWs {


    @WebMethod(operationName="newUserRegistration")
    @WebResult(name="userRegistrationResponse")
    public NewUserRegistrationResponse newUserRegistration(
            @WebParam(name = "userRegistrationRequest",
                    mode = WebParam.Mode.IN) NewUserRegistrationRequest userRegistrationRequest);
}
