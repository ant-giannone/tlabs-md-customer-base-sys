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
}
