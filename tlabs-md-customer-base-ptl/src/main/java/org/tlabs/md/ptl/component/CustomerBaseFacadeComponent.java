package org.tlabs.md.ptl.component;

import org.tlabs.md.bsl.exception.UserRegistrationBslException;
import org.tlabs.md.ptl.ws.dto.NewUserRegistrationRequest;

import java.util.UUID;

public interface CustomerBaseFacadeComponent {

    public UUID userRegister(NewUserRegistrationRequest userRegistrationRequest) throws UserRegistrationBslException;
}
