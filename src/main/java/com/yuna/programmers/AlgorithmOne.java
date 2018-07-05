package com.yuna.programmers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

import java.util.*;

/**
 *
 */
public class AlgorithmOne {

    private static final Logger log = LoggerFactory.getLogger(AlgorithmOne.class);

//    https://programmers.co.kr/learn/courses/30/lessons/12903?language=java
    public static String solutionOne(String s) {
        return s.substring((s.length() - 1) / 2, s.length() / 2 + 1);
    }


//    https://programmers.co.kr/learn/courses/30/lessons/12906?language=java
    public static int[] solutionTwo(int[] arr) {

        int prevNum = arr[0];
        List resultList = new ArrayList();
        resultList.add(prevNum);

        for(int i = 1; i < arr.length ; i++ ) {
            if(arr[i] != prevNum) {
                resultList.add(arr[i]);
                prevNum = arr[i];
            }
        }
        return resultList.stream().mapToInt(i -> (int) i).toArray();

    }

//    https://programmers.co.kr/learn/courses/30/lessons/12916?language=java
    public static boolean solutionThree(String s) {
        return s.toLowerCase().chars().filter(e -> e == 'p').count() == s.toLowerCase().chars().filter(e -> e == 'y').count();
    }

//    https://programmers.co.kr/learn/courses/30/lessons/12909?language=java
    public static boolean solutionFour(String s) {

        boolean res = true;
        int temp = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                temp++;
            } else if (s.charAt(i) == ')') {
                if (temp == 0) {
                    res = false;
                    break;
                } else {
                    temp--;
                }
            }
        }
        if (temp != 0) {
            res = false;
        }
        log.debug("res : {}" ,res);
        return res;

/*
        if (s.length() == 0) {
            return false;
        } else {
            if (s.length() % 2 != 0) {
                return false;
            } else {
                if (s.startsWith(")")) {
                    return false;
                } else {
                    if (s.chars().filter(e -> e == ')').count() == s.chars().filter(e -> e == '(').count()) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
*/
    }

}
