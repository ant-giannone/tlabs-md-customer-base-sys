package org.tlabs.md.ptl.component;

import org.tlabs.md.bsl.exception.ActivationCodeBslException;
import org.tlabs.md.bsl.exception.UserRegistrationBslException;
import org.tlabs.md.ptl.ws.dto.ActivationAccountRequest;
import org.tlabs.md.ptl.ws.dto.NewUserRegistrationRequest;

import java.util.UUID;

public interface CustomerBaseFacadeComponent {

    public UUID userRegister(NewUserRegistrationRequest userRegistrationRequest) throws UserRegistrationBslException;
    public void accountActivationCodeVerification(ActivationAccountRequest activationAccountRequest) throws ActivationCodeBslException;
}
