package com.rma.travelwithme.configurations;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.spec.KeySpec;
import java.util.Base64;

@Service
public class PasswordAES {
    private static final String SECRET_KEY = "hiahfasfLADLSDSLAFHSDLFHDSHAFLA";
    private static final String SALT = "ASDLHADAL?:O!!!!";
    private static final byte[] IV = new byte[16]; // Initializing IV with 16 bytes (all zeros)

    public static String encrypt(String strToEncrypt) {
        return Base64.getEncoder().encodeToString(strToEncrypt.getBytes());
    }

    public static String decrypt(String strToDecrypt) {
        return new String(Base64.getDecoder().decode(strToDecrypt));
    }
}
