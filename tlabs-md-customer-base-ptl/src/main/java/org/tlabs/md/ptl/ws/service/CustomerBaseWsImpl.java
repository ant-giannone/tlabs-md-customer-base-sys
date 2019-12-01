package org.tlabs.md.ptl.ws.service;

import org.tlabs.md.ptl.ws.dto.ActivationAccountRequest;
import org.tlabs.md.ptl.ws.dto.ActivationAccountResponse;

import javax.jws.WebService;

@WebService(
        endpointInterface = "org.tlabs.md.ptl.ws.service.CustomerBaseWs",
        serviceName = "CustomerBaseGeneralSN",
        portName = "CustomerBaseGeneralPN")
public class CustomerBaseWsImpl implements CustomerBaseWs {

    public CustomerBaseWsImpl() {
    }

    @Override
    public ActivationAccountResponse activationAccount(ActivationAccountRequest activationAccountRequest) {

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
