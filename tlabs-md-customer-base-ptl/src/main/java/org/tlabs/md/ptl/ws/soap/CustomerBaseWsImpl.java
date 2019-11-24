package org.tlabs.md.ptl.ws.soap;

import org.tlabs.md.ptl.ws.UserRegistrationException;
import org.tlabs.md.ptl.ws.dto.FaultRegistrationInfo;
import org.tlabs.md.ptl.ws.dto.NewUserRegistrationRequest;
import org.tlabs.md.ptl.ws.dto.NewUserRegistrationResponse;

import javax.jws.WebService;
import java.net.MalformedURLException;
import java.net.URL;

@WebService(
        endpointInterface = "org.tlabs.md.ptl.ws.soap.CustomerBaseWs",
        serviceName = "CustomerBaseManagerWs"
)
public class CustomerBaseWsImpl implements CustomerBaseWs {

    public CustomerBaseWsImpl() {
    }

    @Override
    public NewUserRegistrationResponse newUserRegistration(NewUserRegistrationRequest userRegistrationRequest) {

        try {

            NewUserRegistrationResponse newUserRegistrationResponse = new NewUserRegistrationResponse();

            newUserRegistrationResponse.setOperationCode("NUR-S00");
            newUserRegistrationResponse.setActivationLink(
                    new URL("http://localhost:8888/tlabs-md-cbs/CustomerBaseManagerWs")
            );

            return newUserRegistrationResponse;
        } catch (MalformedURLException e) {

            FaultRegistrationInfo faultRegistrationInfo = new FaultRegistrationInfo();
            faultRegistrationInfo.setCode("NUR-EN00");
            faultRegistrationInfo.setMessage("Unable to determine activation link ");

            throw new UserRegistrationException(faultRegistrationInfo);
        }
    }
}
