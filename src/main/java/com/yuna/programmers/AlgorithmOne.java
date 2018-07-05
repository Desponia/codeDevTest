package com.yuna.programmers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

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
        /*
        올바른 괄호란 두 개의 괄호 '(' 와 ')' 만으로 구성되어 있고, 괄호가 올바르게 짝지어진 문자열입니다.
        괄호가 올바르게 짝지어졌다는 것은 '(' 문자로 열렸으면 반드시 짝지어서 ')' 문자로 닫혀야 합니다.
                예를들어

            ()() 또는 (())() 는 올바른 괄호입니다.
            )()( 또는 (()( 는 올바르지 않은 괄호입니다.
        '(' 또는 ')' 로만 이루어진 문자열 s가 주어졌을 때, 문자열 s가 올바른 괄호이면 true를 return 하고, 올바르지 않은 괄호이면 false를 return하는 solution 함수를 완성해 주세요.

                제한사항
        문자열 s의 길이 : 100,000 이하의 자연수
        문자열 s는 '(' 또는 ')' 로만 이루어져 있습니다.




        */

        char[] omg = s.toCharArray();



        String res = "YES";
        StopWatch watch = new StopWatch();
        watch.start();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(1);
            } else if (s.charAt(i) == ')') {
                if (st.isEmpty()) {
                    res = "NO";
                    break;
                } else {
                    st.pop();
                }
            }
        }
        if (!st.isEmpty()) {
            res = "NO";
        }
        watch.stop();

        log.debug("res : {}" ,res);
        return res == "YES" ? true : false;
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
                    if (s.chars().filter(e -> e == ')').count() == s.chars().filter(e -> e == '(').count())
                        return true;
                    else return false;
                }
            }
        }
*/

    }


}
