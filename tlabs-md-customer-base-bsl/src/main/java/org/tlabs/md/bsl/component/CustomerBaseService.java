package org.tlabs.md.bsl.component;

import org.tlabs.md.bsl.exception.ActivationCodeBslException;
import org.tlabs.md.bsl.exception.UserRegistrationBslException;
import org.tlabs.md.dal.entity.AccountEntity;
import org.tlabs.md.dal.entity.ContactEntity;
import org.tlabs.md.dal.entity.ProfileEntity;

import java.util.List;
import java.util.UUID;

public interface CustomerBaseService {

    public UUID registerNewUser(
            ProfileEntity profileEntity,
            AccountEntity accountEntity,
            List<ContactEntity> contacts) throws UserRegistrationBslException;

    public void verifyActivationCode(UUID accountActivationCode) throws ActivationCodeBslException;
}
