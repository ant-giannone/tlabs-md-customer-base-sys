package org.tlabs.md.ptl.ws.security;

import org.apache.wss4j.common.ext.WSPasswordCallback;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CustomUserTokenPasswordCallback implements CallbackHandler {

    private Map<String, String> keystore = new HashMap<String, String>();

    public CustomUserTokenPasswordCallback(){
        keystore.put("coder", "coder");
        keystore.put("john", "doe");
    }
    @Override
    public void handle(Callback[] callbacks) {

        Arrays.asList(callbacks).stream().forEach(callback -> {

            WSPasswordCallback wsPasswordCallback = (WSPasswordCallback) callback;

            if (keystore.containsKey(wsPasswordCallback.getIdentifier())) {

                String psw = keystore.get(wsPasswordCallback.getIdentifier());

                wsPasswordCallback.setPassword(psw);
            }
        });
    }
}
