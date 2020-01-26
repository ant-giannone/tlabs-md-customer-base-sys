package org.tlabs.md.ptl.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tlabs.md.bsl.component.CustomerBaseService;
import org.tlabs.md.bsl.exception.ActivationCodeBslException;
import org.tlabs.md.bsl.exception.UserRegistrationBslException;
import org.tlabs.md.dal.entity.AccountEntity;
import org.tlabs.md.dal.entity.ContactEntity;
import org.tlabs.md.dal.entity.ProfileEntity;
import org.tlabs.md.ptl.converter.SimpleStrategyConverter;
import org.tlabs.md.ptl.ws.dto.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class CustomerBaseFacadeComponentImpl implements CustomerBaseFacadeComponent {

    private static final Logger logger
            = LoggerFactory.getLogger(CustomerBaseFacadeComponentImpl.class);

    private CustomerBaseService customerBaseService;
    SimpleStrategyConverter<PersonalContactDTO, ContactEntity> contactEntityStrategyConverter;
    SimpleStrategyConverter<PersonalCredentialDTO, AccountEntity> credentialEntityStrategyConverter;
    SimpleStrategyConverter<PersonalDataDTO, ProfileEntity> profileEntityStrategyConverter;


    public CustomerBaseFacadeComponentImpl(
            CustomerBaseService customerBaseService,
            SimpleStrategyConverter<PersonalContactDTO, ContactEntity> contactEntityStrategyConverter,
            SimpleStrategyConverter<PersonalCredentialDTO, AccountEntity> credentialEntityStrategyConverter,
            SimpleStrategyConverter<PersonalDataDTO, ProfileEntity> profileEntityStrategyConverter) {

        this.customerBaseService = customerBaseService;

        this.contactEntityStrategyConverter = contactEntityStrategyConverter;
        this.credentialEntityStrategyConverter = credentialEntityStrategyConverter;
        this.profileEntityStrategyConverter = profileEntityStrategyConverter;
    }

    @Override
    public UUID userRegister(NewUserRegistrationRequest userRegistrationRequest) throws UserRegistrationBslException {

        PersonalDataDTO personalData = userRegistrationRequest.getPersonalData();
        ProfileEntity profileEntity = new ProfileEntity();
        profileEntityStrategyConverter.execute(personalData, profileEntity);

        PersonalContactDTO personalContact = userRegistrationRequest.getPersonalContact();
        List<ContactEntity> contacts = new ArrayList<>();
        contactEntityStrategyConverter.execute(personalContact, contacts);

        PersonalCredentialDTO personalCredential = userRegistrationRequest.getPersonalCredential();
        AccountEntity accountEntity = new AccountEntity();
        credentialEntityStrategyConverter.execute(personalCredential, accountEntity);

        return customerBaseService.registerNewUser(profileEntity, accountEntity, contacts);
    }

    @Override
    public void accountActivationCodeVerification(
            ActivationAccountRequest activationAccountRequest) throws ActivationCodeBslException {

        String activationCode = activationAccountRequest.getActivationCode();
        customerBaseService.verifyActivationCode(UUID.fromString(activationCode));
    }
}
