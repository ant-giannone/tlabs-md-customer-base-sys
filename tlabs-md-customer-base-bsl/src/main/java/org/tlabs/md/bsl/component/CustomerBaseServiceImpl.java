package org.tlabs.md.bsl.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.tlabs.md.bsl.exception.ActivationCodeException;
import org.tlabs.md.bsl.exception.UserRegistrationBslException;
import org.tlabs.md.bsl.utils.ActivationCodeHelper;
import org.tlabs.md.bsl.utils.MD5Helper;
import org.tlabs.md.dal.dao.AccountDAO;
import org.tlabs.md.dal.dao.ContactDAO;
import org.tlabs.md.dal.dao.ProfileDAO;
import org.tlabs.md.dal.entity.AccountEntity;
import org.tlabs.md.dal.entity.AccountStatus;
import org.tlabs.md.dal.entity.ContactEntity;
import org.tlabs.md.dal.entity.ProfileEntity;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.UUID;

@Transactional
public class CustomerBaseServiceImpl implements CustomerBaseService {

    private static final Logger logger
            = LoggerFactory.getLogger(CustomerBaseServiceImpl.class);

    private Long activationCodeExpirePlus;
    private ActivationCodeHelper activationCodeHelper;
    private ProfileDAO profileDAO;
    private AccountDAO accountDAO;
    private ContactDAO contactDAO;


    public CustomerBaseServiceImpl(
            Long activationCodeExpirePlus,
            ActivationCodeHelper activationCodeHelper,
            ProfileDAO profileDAO,
            AccountDAO accountDAO,
            ContactDAO contactDAO) {

        this.activationCodeExpirePlus = activationCodeExpirePlus;
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

        logger.info("START | New User registration started");

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

        try {

            accountEntity.setPassword(
                    MD5Helper.hash(accountEntity.getPassword()));

            UUID activationCode = activationCodeHelper.generateActivationCode(profileEntity, accountEntity);

            accountEntity.setActivationCodeExpire(
                    LocalDateTime.now().plusSeconds(activationCodeExpirePlus)
                            .toInstant(ZoneOffset.UTC).getEpochSecond());
            accountEntity.setActivationCode(activationCode);

            accountDAO.update(accountEntity);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException | ActivationCodeException e) {

            logger.error("END | New User registration | Un error occurred: {}", e.getMessage());
            throw new UserRegistrationBslException(e);
        }

        UUID activationCode = accountEntity.getActivationCode();

        logger.info("END | New User registration successfully accomplished with activationCode: {}",
                activationCode.toString());

        return activationCode;
    }
}
