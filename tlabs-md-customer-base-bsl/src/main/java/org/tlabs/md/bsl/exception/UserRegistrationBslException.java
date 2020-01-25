package org.tlabs.md.bsl.exception;

public class UserRegistrationBslException extends Exception {

    public UserRegistrationBslException() {
    }

    public UserRegistrationBslException(String message) {
        super(message);
    }

    public UserRegistrationBslException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserRegistrationBslException(Throwable cause) {
        super(cause);
    }

    public UserRegistrationBslException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
