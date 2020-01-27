package org.tlabs.md.ptl.ws.security;

import org.apache.wss4j.common.ext.WSPasswordCallback;
import org.tlabs.md.bsl.utils.MD5Helper;
import org.tlabs.md.dal.dao.AccountDAO;
import org.tlabs.md.dal.entity.AccountEntity;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CustomUserTokenPasswordCallback implements CallbackHandler {

    private AccountDAO accountDAO;

    public CustomUserTokenPasswordCallback(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public void handle(Callback[] callbacks) {

        Arrays.asList(callbacks).stream().forEach(callback -> {

            WSPasswordCallback wsPasswordCallback = (WSPasswordCallback) callback;

            AccountEntity byCredential = accountDAO.findByUsername(wsPasswordCallback.getIdentifier());
            wsPasswordCallback.setPassword(byCredential.getPassword());
        });
    }
}
