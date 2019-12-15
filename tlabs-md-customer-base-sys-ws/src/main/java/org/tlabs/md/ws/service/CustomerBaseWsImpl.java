package org.tlabs.md.ws.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tlabs.md.ws.component.DummyComponent;
import org.tlabs.md.ws.dto.ActivationAccountRequest;
import org.tlabs.md.ws.dto.ActivationAccountResponse;
import org.tlabs.md.ws.dto.IdentificationProcedureRequest;
import org.tlabs.md.ws.dto.IdentificationProcedureResponse;

import javax.jws.WebService;

@WebService(
        endpointInterface = "org.tlabs.md.ws.service.CustomerBaseWs",
        serviceName = "CustomerBaseGeneralSN",
        portName = "CustomerBaseGeneralPN")
public class CustomerBaseWsImpl implements CustomerBaseWs {

    private static final Logger logger = LoggerFactory.getLogger(CustomerBaseWsImpl.class);

    private DummyComponent dummyComponent;

    public CustomerBaseWsImpl() {
    }

    public CustomerBaseWsImpl(DummyComponent dummyComponent) {
        this.dummyComponent=dummyComponent;
    }

    @Override
    public ActivationAccountResponse activationAccountAction(ActivationAccountRequest activationAccountRequest) {

        logger.info("START | Activation Account WS");

        dummyComponent.welcome();

        /**
         * TODO:
         *  - validation by custom-component(at this time only schema validation)
         *  - business-logic for activation flow
         * */

        ActivationAccountResponse response = new ActivationAccountResponse();

        response.setOperationCode("NUR-S01");
        response.setMessageInfo("Account activation successfully accomplished");

        logger.info("END | Activation Account WS");

        return response;
    }

    @Override
    public IdentificationProcedureResponse identificationProcedureAction(
            IdentificationProcedureRequest identificationProcedureRequest) {

        logger.info("START | Identification Procedure WS");

        /**
         * TODO:
         *  - validation by custom-component(at this time only schema validation)
         *  - business-logic for identification flow
         * */

        IdentificationProcedureResponse response = new IdentificationProcedureResponse();

        response.setMessageInfo("Your identification procedure request started");
        response.setRequestStatus("PENDING");
        response.setResultCode("IPR-S01");

        logger.info("END | Identification Procedure WS");

        return response;
    }
}
