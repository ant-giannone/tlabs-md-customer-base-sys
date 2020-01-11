package org.tlabs.md.bsl.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.tlabs.md.bsl.exception.UserRegistrationBslException;
import org.tlabs.md.bsl.utils.ActivationCodeHelper;
import org.tlabs.md.bsl.utils.MD5Helper;
import org.tlabs.md.dal.dao.*;
import org.tlabs.md.dal.entity.AccountEntity;
import org.tlabs.md.dal.entity.AccountStatus;
import org.tlabs.md.dal.entity.ContactEntity;
import org.tlabs.md.dal.entity.ProfileEntity;

import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.UUID;

@Transactional
public class CustomerBaseServiceImpl implements CustomerBaseService {

    private static final Logger logger
            = LoggerFactory.getLogger(CustomerBaseServiceImpl.class);

    private ActivationCodeHelper activationCodeHelper;
    private ProfileDAO profileDAO;
    private AccountDAO accountDAO;
    private ContactDAO contactDAO;


    public CustomerBaseServiceImpl(
            ActivationCodeHelper activationCodeHelper,
            ProfileDAO profileDAO,
            AccountDAO accountDAO,
            ContactDAO contactDAO) {

        this.activationCodeHelper = activationCodeHelper;
        this.profileDAO = profileDAO;
        this.accountDAO = accountDAO;
        this.contactDAO = contactDAO;
    }

    @Override
    public UUID registerNewUser(
            final ProfileEntity profileEntity,
            final AccountEntity accountEntity,
            final List<ContactEntity> contacts) throws UserRegistrationBslException {

        try {

            accountEntity.setPassword(
                    MD5Helper.hash(accountEntity.getPassword()));

            UUID activationCode = activationCodeHelper.generateActivationCode(profileEntity, accountEntity);
            accountEntity.setActivationCode(activationCode);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            throw new UserRegistrationBslException(e);
        }

        accountEntity.setStatus(AccountStatus.UNACTIVATED);

        profileEntity.setAccount(accountEntity);

        profileDAO.create(profileEntity);

        if(contacts!=null && !contacts.isEmpty()) {

            contacts.stream().forEach(contactEntity -> {

                contactDAO.create(contactEntity);
                profileEntity.addContact(contactEntity);
            });
        }

        profileDAO.update(profileEntity);

        return accountEntity.getActivationCode();
    }
}
