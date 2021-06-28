package Util;

import GA.model.CrossoverFactory;

import javax.crypto.Cipher;
import java.security.*;
import java.util.concurrent.ExecutionException;

public class KeyFactory {

    private static final String RSA = "RSA";

    public static KeyPair getRSAKeys() {
        try{
            SecureRandom secureRandom = new SecureRandom();
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(RSA);
            keyPairGenerator.initialize(1024, secureRandom);

            return keyPairGenerator.generateKeyPair();
        } catch (Exception e){
            return null;
        }
    }

    public static byte[] do_RSAEncryption(String plainText, PublicKey publicKey) {
        try{
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            return cipher.doFinal(plainText.getBytes());
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static String do_RSADecryption(byte[] cipherText, PrivateKey publicKey) {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, publicKey);
            byte[] result = cipher.doFinal(cipherText);
            return new String(result);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
