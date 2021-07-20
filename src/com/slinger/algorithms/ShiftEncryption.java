package com.slinger.algorithms;

/**
 * Concrete Strategy
 */
public class ShiftEncryption implements Encrypt {

    /**
     * Simple encryption method that works with key from a-z and A-Z
     * the key shifts the letter to the right or wraps around to 'a' if past 'z'
     */
    @Override
    public String encrypt(String toEncrypt, int key) {
        StringBuilder encrypted = new StringBuilder();

        final int LOWER_CASE_MIN = 97; //ascii val for a
        final int LOWER_CASE_MAX = 122; //ascii val for z

        final int UPPER_CASE_MIN = 65;  //ascii val for A
        final int UPPER_CASE_MAX = 90; //ascii val for Z

        for (char c : toEncrypt.toCharArray()) {
            int shiftedIdx = c + key;
            char letter;

            if (Character.isLowerCase(c)) { //encryption for lowercase letters
                //check if we need to wrap around to 'a' if past 'z'
                if (shiftedIdx > LOWER_CASE_MAX) {
                    letter = wrapAround(shiftedIdx, LOWER_CASE_MIN, LOWER_CASE_MAX);
                } else {
                    letter = (char) (shiftedIdx);
                }
                encrypted.append(letter);

            }  else if (Character.isUpperCase(c)) { //encryption for uppercase letters
                //check if we need to wrap around to 'A' if past 'Z'
                if (shiftedIdx > UPPER_CASE_MAX) {
                    letter = wrapAround(shiftedIdx, UPPER_CASE_MIN, UPPER_CASE_MAX);
                } else {
                    letter = (char) (shiftedIdx);
                }

                encrypted.append(letter);

            } else { //just append the blank space/special characters
                encrypted.append(c);
            }
        }

        return encrypted.toString();
    }
}
