package com.slinger.algorithms;

/**
 * Concrete Strategy
 */
public class UnicodeEncryption implements Encrypt {

    /**
     * A slightly better encryption method than shift encryption
     * Encrypts all chars in string including uppercase and special chars using unicode
     */
    @Override
    public String encrypt(String toEncrypt, int key) {
        StringBuilder encrypted = new StringBuilder();

        final int MIN = 0; //starting ascii
        final int MAX = 127; //ending ascii

        for (char c : toEncrypt.toCharArray()) {
            int shiftedIx = c + key;
            char letter;

            //check if we need to wrap around back to 0
            if (shiftedIx > MAX) {
                letter = wrapAround(shiftedIx, MIN, MAX);
            } else {
                letter = (char) shiftedIx;
            }

            encrypted.append(letter);
        }

        return encrypted.toString();
    }
}
