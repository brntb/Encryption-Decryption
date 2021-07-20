package com.slinger.algorithms;

/**
 * Context class
 */
public class AlgorithmContext {

    private Decrypt decryption;
    private Encrypt encryption;

    public void setDecryption(Decrypt decryption) {
        this.decryption = decryption;
    }

    public void setEncryption(Encrypt encryption) {
        this.encryption = encryption;
    }

    public String decrypt(String toDecrypt, int key) {
        return this.decryption.decrypt(toDecrypt, key);
    }

    public String encrypt(String toEncrypt, int key) {
        return this.encryption.encrypt(toEncrypt, key);
    }

}
