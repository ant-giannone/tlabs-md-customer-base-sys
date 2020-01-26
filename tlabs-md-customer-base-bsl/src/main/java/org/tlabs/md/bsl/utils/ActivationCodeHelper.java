package org.tlabs.md.bsl.utils;

import org.tlabs.md.dal.entity.AccountEntity;
import org.tlabs.md.dal.entity.ProfileEntity;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

public class ActivationCodeHelper {

    private UUID uuidNameSpace;

    public ActivationCodeHelper(UUID uuidNameSpace) {
        this.uuidNameSpace = uuidNameSpace;
    }

    public UUID generateActivationCode(ProfileEntity profileEntity, AccountEntity accountEntity)
            throws UnsupportedEncodingException {

        String content = String.format("%s-%s", accountEntity.getId(), profileEntity.getId());
        String source = String.format("%s%s", uuidNameSpace.toString(), content);

        byte[] bytes = source.getBytes("UTF-8");

        return UUID.nameUUIDFromBytes(bytes);
    }

    public boolean verifyActivationCode(
            UUID activationCode, ProfileEntity profileEntity, AccountEntity accountEntity)
            throws UnsupportedEncodingException {

        UUID generatedActivationCode = generateActivationCode(profileEntity, accountEntity);

        /**
         * The control over the activation code is quite weak.
         * But at the moment the focus is not on the types of authentication that we could have implemented.
         *
         * The type of UUID that we use allows us to spend a few words on the use of UUID v3
         * */
        return generatedActivationCode.toString().equals(activationCode.toString());
    }
}
