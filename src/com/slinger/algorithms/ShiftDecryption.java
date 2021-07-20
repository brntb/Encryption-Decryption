package com.slinger.algorithms;

/**
 * Concrete Strategy
 */
public class ShiftDecryption implements Decrypt {

    @Override
    public String decrypt(String toDecrypt, int key) {
        StringBuilder decrypted = new StringBuilder();

        final int LOWER_CASE_MIN = 97; //ascii val for a
        final int LOWER_CASE_MAX = 122; //ascii val for z

        final int UPPER_CASE_MIN = 65;  //ascii val for A
        final int UPPER_CASE_MAX = 90; //ascii val for Z

        for (char c : toDecrypt.toCharArray()) {
            int shiftedIdx = c - key;
            char letter;

            if (Character.isLowerCase(c)) { //decryption for lower case letters
                if (shiftedIdx < LOWER_CASE_MIN) {
                    shiftedIdx = LOWER_CASE_MAX + (shiftedIdx - LOWER_CASE_MIN);
                    letter = (char) (shiftedIdx + 1);
                } else {
                    letter = (char) shiftedIdx;
                }

                decrypted.append(letter);

            } else if (Character.isUpperCase(c)) { //decryption for upper case letters
                if (shiftedIdx < UPPER_CASE_MIN) {
                    shiftedIdx = UPPER_CASE_MAX + (shiftedIdx - UPPER_CASE_MIN);
                    letter = (char) (shiftedIdx + 1);
                } else {
                    letter = (char) shiftedIdx;
                }

                decrypted.append(letter);

            } else {
                decrypted.append(c);
            }
        }

        return decrypted.toString();
    }
}
