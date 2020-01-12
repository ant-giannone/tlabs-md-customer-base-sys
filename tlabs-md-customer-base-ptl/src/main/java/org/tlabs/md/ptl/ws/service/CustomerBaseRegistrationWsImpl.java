package org.tlabs.md.ptl.ws.service;

import org.tlabs.md.ptl.component.DummyPtlComponent;
import org.tlabs.md.ptl.ws.UserRegistrationException;
import org.tlabs.md.ptl.ws.dto.FaultRegistrationInfo;
import org.tlabs.md.ptl.ws.dto.NewUserRegistrationRequest;
import org.tlabs.md.ptl.ws.dto.NewUserRegistrationResponse;

import javax.jws.WebService;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

@WebService(
        endpointInterface = "org.tlabs.md.ptl.ws.service.CustomerBaseRegistrationWs",
        serviceName = "CustomerBaseRegistrationSN",
        portName = "CustomerBaseRegistrationPN")
public class CustomerBaseRegistrationWsImpl implements CustomerBaseRegistrationWs {

    private DummyPtlComponent dummyPtlComponent;

    public CustomerBaseRegistrationWsImpl() {
    }

    public CustomerBaseRegistrationWsImpl(DummyPtlComponent dummyPtlComponent) {
        this.dummyPtlComponent = dummyPtlComponent;
    }

    @Override
    public NewUserRegistrationResponse newUserRegistration(NewUserRegistrationRequest userRegistrationRequest) {

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

            dummyPtlComponent.newUserRegistration(userRegistrationRequest);

            return newUserRegistrationResponse;
        } catch (MalformedURLException e) {

            FaultRegistrationInfo faultRegistrationInfo = new FaultRegistrationInfo();
            faultRegistrationInfo.setCode("NUR-EN00");
            faultRegistrationInfo.setMessage("Unable to determine activation link ");

            throw new UserRegistrationException(faultRegistrationInfo);
        }
    }
}
