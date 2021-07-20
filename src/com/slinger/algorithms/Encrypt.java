package com.slinger.algorithms;

/**
 ** Strategy for encryption
**/
public interface Encrypt {

    String encrypt(String toEncrypt, int key);

    /**
     * if when adding key to ascii position goes over max, this method wraps back to start
     */
    default char wrapAround(int idx, int min, int max) {
        idx = idx - max;
        return (char) (min + idx - 1);
    }

}
