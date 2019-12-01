package org.tlabs.md.ptl.ws.service;

import org.tlabs.md.ptl.ws.dto.ActivationAccountRequest;
import org.tlabs.md.ptl.ws.dto.ActivationAccountResponse;
import org.tlabs.md.ptl.ws.dto.IdentificationProcedureRequest;
import org.tlabs.md.ptl.ws.dto.IdentificationProcedureResponse;

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

        ActivationAccountResponse response = new ActivationAccountResponse();

        response.setOperationCode("NUR-S01");
        response.setMessageInfo("Account activation successfully accomplished");

        return response;
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
