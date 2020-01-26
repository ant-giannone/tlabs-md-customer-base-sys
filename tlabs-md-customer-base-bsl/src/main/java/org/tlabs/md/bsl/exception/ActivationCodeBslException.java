package org.tlabs.md.bsl.exception;

public class ActivationCodeBslException extends Exception {

    public ActivationCodeBslException() {
    }

    public ActivationCodeBslException(String message) {
        super(message);
    }

    public ActivationCodeBslException(String message, Throwable cause) {
        super(message, cause);
    }

    public ActivationCodeBslException(Throwable cause) {
        super(cause);
    }

    public ActivationCodeBslException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
