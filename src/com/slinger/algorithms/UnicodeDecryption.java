package com.slinger.algorithms;

/**
 * Concrete Strategy
 */
public class UnicodeDecryption implements Decrypt {

    /**
     * A decryption that works with unicode
     * it shifts the encrypted letters back to original place using key
     */
    @Override
    public String decrypt(String toDecrypt, int key) {
        StringBuilder decrypted = new StringBuilder();

        final int MIN = 0;
        final int MAX = 127;

        for (char c : toDecrypt.toCharArray()) {
            int shiftedIdx = c - key;
            char letter;

            //check if shiftedIdx when below 0
            //if it did, wrap around back to MAX
            if (shiftedIdx < MIN) {
                shiftedIdx = MAX + shiftedIdx;
                letter = (char) (shiftedIdx + 1);
            } else {
                letter = (char) shiftedIdx;
            }

            decrypted.append(letter);
        }

        return decrypted.toString();
    }
}
