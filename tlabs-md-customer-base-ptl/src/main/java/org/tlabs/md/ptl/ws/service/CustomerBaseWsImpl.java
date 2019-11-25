package org.tlabs.md.ptl.ws.service;

import org.tlabs.md.ptl.ws.UserRegistrationException;
import org.tlabs.md.ptl.ws.dto.*;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

@WebService(
        endpointInterface = "org.tlabs.md.ptl.ws.service.CustomerBaseWs",
        serviceName = "CustomerBaseManagerWs"
)
public class CustomerBaseWsImpl implements CustomerBaseWs {

    public CustomerBaseWsImpl() {
    }

    @Override
    @WebResult(name="userRegistrationResponse")
    public NewUserRegistrationResponse newUserRegistration(
            @WebParam(name = "userRegistrationRequest",
                    mode = WebParam.Mode.IN
            ) NewUserRegistrationRequest userRegistrationRequest) {

        /**
         * TODO:
         *  - validation by custom-component(at this time only schema validation)
         *  - business-logic for registration flow
         *      - basic logic for activation-code management
         *      - persistence
         * */

        try {

            NewUserRegistrationResponse newUserRegistrationResponse = new NewUserRegistrationResponse();

            newUserRegistrationResponse.setOperationCode("NUR-S00");
            newUserRegistrationResponse.setActivationCode(UUID.randomUUID().toString()); //It's not a good strategy
            newUserRegistrationResponse.setActivationLink(
                    new URL("http://localhost:8888/tlabs-md-cbs/CustomerBaseManagerWs") //It's not a good strategy
            );

            return newUserRegistrationResponse;
        } catch (MalformedURLException e) {

            FaultRegistrationInfo faultRegistrationInfo = new FaultRegistrationInfo();
            faultRegistrationInfo.setCode("NUR-EN00");
            faultRegistrationInfo.setMessage("Unable to determine activation link ");

            throw new UserRegistrationException(faultRegistrationInfo);
        }
    }

    @Override
    @WebResult(name="activationAccountResponse")
    public ActivationAccountResponse activationAccount(
            @WebParam(name = "activationAccountRequest",
                    mode = WebParam.Mode.IN)
                    ActivationAccountRequest activationAccountRequest) {

        /**
         * TODO:
         *  - validation by custom-component(at this time only schema validation)
         *  - business-logic for activation flow
         * */

        ActivationAccountResponse activationAccountResponse = new ActivationAccountResponse();

        activationAccountResponse.setOperationCode("NUR-S01");
        activationAccountResponse.setMessageInfo("Account activation successfully accomplished");

        return activationAccountResponse;
    }
}
