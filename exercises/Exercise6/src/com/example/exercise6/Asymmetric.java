package com.example.exercise6;

import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;


public class Asymmetric {
    public static void main(String[] args) throws Exception {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");

        keyPairGen.initialize(2048);

        KeyPair pair = keyPairGen.generateKeyPair();

        PublicKey publicKey = pair.getPublic();

        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        Alice alice = new Alice();
        byte[] input = alice.introduction().getBytes();
        cipher.update(input);

        byte[] cipherText = cipher.doFinal();
        System.out.println( new String(cipherText, "UTF8"));

        cipher.init(Cipher.DECRYPT_MODE, pair.getPrivate());

        //Decrypting the text
        byte[] decipheredText = cipher.doFinal(cipherText);

        Bob bob = new Bob();
        bob.print(new String(decipheredText));
    }
}
