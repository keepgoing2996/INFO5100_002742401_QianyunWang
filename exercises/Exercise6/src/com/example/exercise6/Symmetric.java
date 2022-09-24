package com.example.exercise6;

import javax.crypto.Cipher;
import javax.crypto.spec.*;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import java.security.Key;
import java.security.SecureRandom;

public class Symmetric {
    public static void main(String[] args) throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");

        //Creating a SecureRandom object
        SecureRandom secRandom = new SecureRandom();

        //Initializing the KeyGenerator
        keyGen.init(256);

        //Creating/Generating a key
        Key key = keyGen.generateKey();

        System.out.println(key);
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(cipher.ENCRYPT_MODE, key);

        Alice alice = new Alice();
        String msg = alice.introduction();
        byte[] cipherText = cipher.doFinal(msg.getBytes());

        System.out.println( new String(cipherText, "UTF8"));

        GCMParameterSpec spec = new GCMParameterSpec(128,cipher.getIV());

        cipher.init(Cipher.DECRYPT_MODE, key, spec);

        //Decrypting the text
        byte[] decipheredText = cipher.doFinal(cipherText);

        Bob bob = new Bob();
        bob.print(new String(decipheredText));
    }
}
