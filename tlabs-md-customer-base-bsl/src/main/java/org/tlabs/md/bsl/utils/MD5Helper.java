package org.tlabs.md.bsl.utils;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Helper {

    public static String hash(final String source) throws NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(source.getBytes());
        byte[] digest = md.digest();

        return DatatypeConverter.printHexBinary(digest).toUpperCase();
    }
}
