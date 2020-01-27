package org.tlabs.md.bsl.utils;

import org.tlabs.md.bsl.exception.ActivationCodeException;
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
            throws UnsupportedEncodingException, ActivationCodeException {

        if(profileEntity==null || profileEntity.getId()==null || profileEntity.getId()<=0 ||
                accountEntity==null || accountEntity.getId()==null || accountEntity.getId()<=0) {

            throw new ActivationCodeException("Unable to generate activation code: accountId and profileID must not be null");
        }

        String content = String.format("%sA-%sP", accountEntity.getId(), profileEntity.getId());
        String source = String.format("%s%s", uuidNameSpace.toString(), content);

        byte[] bytes = source.getBytes("UTF-8");

        return UUID.nameUUIDFromBytes(bytes);
    }
}
