package com.example.exercise6;
import javax.crypto.Cipher;
import java.security.*;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
public class Sign {
    public static void main(String[] args)  throws Exception{
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");

        keyPairGen.initialize(2048);

        KeyPair pair = keyPairGen.generateKeyPair();

        PrivateKey privKey = pair.getPrivate();

        Signature sign = Signature.getInstance("SHA256withRSA"); 

        Alice alice = new Alice();
        sign.initSign(privKey);
        byte[] bytes = alice.introduction().getBytes();

        sign.update(bytes);

        byte[] signature = sign.sign();

        sign.initVerify(pair.getPublic());
        sign.update(bytes);

        boolean bool = sign.verify(signature);

        Bob bob = new Bob();
        if(bool) {
            bob.print(new String("Alice Signature verified"));
        } else {
            bob.print("Alice Signature failed");
        }

    }
}
