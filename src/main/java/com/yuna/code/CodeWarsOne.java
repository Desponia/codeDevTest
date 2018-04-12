package com.yuna.code;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class CodeWarsOne {

    private static final Logger logger = LoggerFactory.getLogger(CodeWarsOne.class);

    public static void main(String[] args) {
        logger.debug(intToString(9, 5));
        int temp = 9 | 30;
        logger.debug("temp : {}, result : {}", temp, intToString(temp, 5));
        logger.debug(Arrays.toString(binaryTest(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17,28})));
        logger.debug(Arrays.toString(binaryTest(6, new int[]{46, 33, 33 ,22, 31, 50}, new int[]{27 ,56, 19, 14, 14, 10})));
    }

    public static String[] binaryTest(int n, int[] arr1, int[] arr2) {
        String[] result = new String[n];
        for(int i = 0 ; i < n ; i++ ) {
            result[i] = intToString(arr1[i] | arr2[i], n).replace("1", "#").replace("0", " ");
        }
        return result;
    }

    private static String intToString(int number, int groupSize) {
        StringBuilder result = new StringBuilder();
        for(int i = groupSize - 1 ; i >= 0 ; i--) {
            int mask = 1 << i;
            result.append((number & mask) != 0 ? "1" : "0");
        }
        return result.toString();
    }

}
