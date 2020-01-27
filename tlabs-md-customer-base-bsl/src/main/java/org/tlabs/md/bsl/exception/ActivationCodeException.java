package org.tlabs.md.bsl.exception;

public class ActivationCodeException extends Exception {

    public ActivationCodeException() {
    }

    public ActivationCodeException(String message) {
        super(message);
    }

    public ActivationCodeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ActivationCodeException(Throwable cause) {
        super(cause);
    }

    public ActivationCodeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
