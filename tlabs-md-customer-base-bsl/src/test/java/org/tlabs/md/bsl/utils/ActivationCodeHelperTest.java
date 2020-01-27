package org.tlabs.md.bsl.utils;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.tlabs.md.bsl.exception.ActivationCodeException;
import org.tlabs.md.dal.entity.AccountEntity;
import org.tlabs.md.dal.entity.ProfileEntity;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

import static org.junit.Assert.*;

public class ActivationCodeHelperTest {

    private ActivationCodeHelper activationCodeHelper;
    private ProfileEntity profileEntity;
    private AccountEntity accountEntity;

    @Before
    public void setUp() throws Exception {
        activationCodeHelper = new ActivationCodeHelper(UUID.fromString("d4aed47b-52d6-4f36-ac02-d931705e6fb4"));
        profileEntity = new ProfileEntity();
        accountEntity = new AccountEntity();

        accountEntity.setId(31L);
        profileEntity.setId(35L);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void generateActivationCode() throws UnsupportedEncodingException, ActivationCodeException {
        UUID generateActivationCode = activationCodeHelper.generateActivationCode(profileEntity, accountEntity);
        Assert.assertNotNull(generateActivationCode);
    }

    @Test
    public void verifyActivationCode() throws UnsupportedEncodingException, ActivationCodeException {
        UUID generateActivationCode = activationCodeHelper.generateActivationCode(profileEntity, accountEntity);
        Assert.assertNotNull(generateActivationCode);

        boolean verified = activationCodeHelper.verifyActivationCode(generateActivationCode, profileEntity, accountEntity);

        Assert.assertTrue(verified);
    }
}