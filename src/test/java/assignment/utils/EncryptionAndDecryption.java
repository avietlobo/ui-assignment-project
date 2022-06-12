package assignment.utils;

import java.util.Base64;

public class EncryptionAndDecryption {

    public static String decrypt(String encryptedText){
        byte[] decodeBytes = Base64.getDecoder().decode(encryptedText.getBytes());
        return new String(decodeBytes);
    }
}
