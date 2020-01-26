package org.tlabs.md.ptl.ws.service;

import org.tlabs.md.bsl.exception.ActivationCodeBslException;
import org.tlabs.md.ptl.component.CustomerBaseFacadeComponent;
import org.tlabs.md.ptl.ws.UserRegistrationException;
import org.tlabs.md.ptl.ws.dto.*;

import javax.jws.WebService;

@WebService(
        endpointInterface = "org.tlabs.md.ptl.ws.service.CustomerBaseWs",
        serviceName = "CustomerBaseGeneralSN",
        portName = "CustomerBaseGeneralPN")
public class CustomerBaseWsImpl implements CustomerBaseWs {

    private CustomerBaseFacadeComponent customerBaseFacadeComponent;


    public CustomerBaseWsImpl(CustomerBaseFacadeComponent customerBaseFacadeComponent) {
        this.customerBaseFacadeComponent = customerBaseFacadeComponent;
    }

    @Override
    public ActivationAccountResponse activationAccount(ActivationAccountRequest activationAccountRequest) {


        try {

            customerBaseFacadeComponent.accountActivationCodeVerification(activationAccountRequest);

            ActivationAccountResponse response = new ActivationAccountResponse();
            response.setOperationCode("NUR-S01");
            response.setMessageInfo("Account activation successfully accomplished");

            return response;
        } catch (ActivationCodeBslException e) {

            /**
             * For simplicity of use at the moment we do not consider expire scenarios of the activation code.
             * We assume that the generated code is always valid and that the account status must be UNACTIVATED
             * */
            FaultRegistrationInfo faultRegistrationInfo = new FaultRegistrationInfo();
            faultRegistrationInfo.setCode("NUR-EN01");
            faultRegistrationInfo.setMessage(
                    "Unable to activate account: the activation-code is not valid or is not usable for this account");

            throw new UserRegistrationException(faultRegistrationInfo);
        }
    }

    @Override
    public IdentificationProcedureResponse identificationProcedure(
            IdentificationProcedureRequest identificationProcedureRequest) {

        /**
         * TODO:
         *  - validation by custom-component(at this time only schema validation)
         *  - business-logic for identification flow
         * */

        IdentificationProcedureResponse response = new IdentificationProcedureResponse();

        response.setMessageInfo("Your identification procedure request started");
        response.setRequestStatus("PENDING");
        response.setResultCode("IPR-S01");

        return response;
    }
}
