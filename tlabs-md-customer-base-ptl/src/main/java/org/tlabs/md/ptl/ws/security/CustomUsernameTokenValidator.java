package org.tlabs.md.ptl.ws.security;

import org.apache.wss4j.common.ext.WSSecurityException;
import org.apache.wss4j.dom.handler.RequestData;
import org.apache.wss4j.dom.message.token.UsernameToken;
import org.apache.wss4j.dom.validate.UsernameTokenValidator;
import org.apache.wss4j.dom.validate.Validator;
import org.tlabs.md.bsl.utils.MD5Helper;

import java.security.NoSuchAlgorithmException;

public class CustomUsernameTokenValidator extends UsernameTokenValidator implements Validator {

    @Override
    protected void verifyPlaintextPassword(UsernameToken usernameToken, RequestData data) throws WSSecurityException {

        try {

            String hash = MD5Helper.hash(usernameToken.getPassword());
            usernameToken.setPassword(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        super.verifyPlaintextPassword(usernameToken, data);
    }
}
