package com.yuna.programmers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

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

//    https://programmers.co.kr/learn/courses/30/lessons/12951?language=java
    public static String solutionFive(String s) {

        String[] str = s.split(" ");
//        char tempC = 65;
        // 대문자 65 ~ 90   ///   소문자       97 ~ 122
//        log.debug(String.valueOf(tempC));
        /*
        List tempList = Arrays.asList(str);
        List result = (List) tempList.stream().map(e -> upperCase(e.toString())).collect(Collectors.toList());

        log.debug("result : {}", Arrays.toString(result.toArray()));
        log.debug("---- > {}", String.join(" ", result));
        return String.join(" ", result);
        */

        boolean flag = true;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++ ) {
            char c = s.charAt(i);
            if(i == 0 || flag) {
                sb.append(Character.toUpperCase(c));
                flag = false;
            } else {
                sb.append(Character.toLowerCase(c));
            }
            if(c == ' ') {
                flag = true;
            }
        }
        return sb.toString();
    }

//    https://programmers.co.kr/learn/courses/30/lessons/12911?language=java
    public static int solitionSix(int n) {
        String binary = Integer.toBinaryString(n);
        int cnt1 = binary.replace("0", "").length();
        int result = 0;
        log.debug("n : {}, binary : {}, cnt1:{}", n, binary, cnt1);

        while (true) {
            n++;
            String binary2 = Integer.toBinaryString(n);
            int temp = binary2.replace("0", "").length();
//            log.debug("binary2 : {}, temp : {}", binary2, temp);
            if( temp == cnt1) {
                result = n;
                break;
            }
        }
        log.debug("result : {}", result);

        return result;

        /*int postPattern = n & -n;
        log.debug("postPattern : {}", postPattern);
        int smallPattern = ((n ^ (n + postPattern)) / postPattern) >> 2;
        log.debug("smallPattern : {}", smallPattern);

        return n + postPattern | smallPattern;
        */
    }

//    https://programmers.co.kr/learn/courses/30/lessons/12899?language=java
    public static String solutionSeven(int n) {
        String answer = "";
        while(n > 0) {
            int remain = n % 3;
            n = (int) Math.floor(n / 3);
            if(remain == 0) {
                n--;
            }
            answer += String.valueOf(remain);
        }
        List<String> reverseAnser = Arrays.asList(answer.replace("0", "4").split(""));
        Collections.reverse(reverseAnser);
        answer = String.join("", reverseAnser);
        log.debug("answer :: {}", answer);
        return answer;
    }


}
