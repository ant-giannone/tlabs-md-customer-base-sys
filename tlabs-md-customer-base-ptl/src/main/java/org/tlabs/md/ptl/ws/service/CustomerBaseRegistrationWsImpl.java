package org.tlabs.md.ptl.ws.service;

import org.tlabs.md.bsl.exception.UserRegistrationBslException;
import org.tlabs.md.ptl.component.CustomerBaseFacadeComponent;
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

    private CustomerBaseFacadeComponent customerBaseFacadeComponent;

    public CustomerBaseRegistrationWsImpl(CustomerBaseFacadeComponent customerBaseFacadeComponent) {
        this.customerBaseFacadeComponent = customerBaseFacadeComponent;
    }

    @Override
    public NewUserRegistrationResponse newUserRegistration(NewUserRegistrationRequest userRegistrationRequest) {

        try {

            UUID uuid = customerBaseFacadeComponent.userRegister(userRegistrationRequest);

            NewUserRegistrationResponse newUserRegistrationResponse = new NewUserRegistrationResponse();

            newUserRegistrationResponse.setOperationCode("NUR-S00");
            newUserRegistrationResponse.setActivationCode(uuid.toString());
            newUserRegistrationResponse.setActivationLink(
                    new URL("http://localhost:8888/tlabs-md-cbs/CustomerBaseManagerWs") //It's not a good strategy
            );

            return newUserRegistrationResponse;
        } catch (MalformedURLException | UserRegistrationBslException e) {

            FaultRegistrationInfo faultRegistrationInfo = new FaultRegistrationInfo();
            faultRegistrationInfo.setCode("NUR-EN00");
            faultRegistrationInfo.setMessage("Unable to determine activation link ");

            throw new UserRegistrationException(faultRegistrationInfo);
        }
    }
}
