package org.tlabs.md.ws.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tlabs.md.ws.exception.UserRegistrationException;
import org.tlabs.md.ws.dto.FaultRegistrationInfo;
import org.tlabs.md.ws.dto.NewUserRegistrationRequest;
import org.tlabs.md.ws.dto.NewUserRegistrationResponse;

import javax.jws.WebService;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

@WebService(
        endpointInterface = "org.tlabs.md.ws.service.CustomerBaseRegistrationWs",
        serviceName = "CustomerBaseRegistrationSN",
        portName = "CustomerBaseRegistrationPN")
public class CustomerBaseRegistrationWsImpl implements CustomerBaseRegistrationWs {

    private static final Logger logger = LoggerFactory.getLogger(CustomerBaseRegistrationWsImpl.class);

    public CustomerBaseRegistrationWsImpl() {
    }

    @Override
    public NewUserRegistrationResponse newUserRegistration(NewUserRegistrationRequest userRegistrationRequest) {

        logger.info("START | NewUserRegistration WS");

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

            logger.info("END | NewUserRegistration WS | Response[{}]", newUserRegistrationResponse.toString());

            return newUserRegistrationResponse;
        } catch (MalformedURLException e) {

            FaultRegistrationInfo faultRegistrationInfo = new FaultRegistrationInfo();
            faultRegistrationInfo.setCode("NUR-EN00");
            faultRegistrationInfo.setMessage("Unable to determine activation link ");

            throw new UserRegistrationException(faultRegistrationInfo);
        }
    }
}
