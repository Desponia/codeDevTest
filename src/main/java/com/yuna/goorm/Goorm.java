package com.yuna.goorm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class Goorm {
    private static final Logger logger = LoggerFactory.getLogger(Goorm.class);

    public static String test1(int n) {
        return String.join(" ", IntStream.rangeClosed(1, n).filter(i -> n % i == 0).boxed().map( i -> i.toString()).collect(toList()));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            logger.debug(test1(sc.nextInt()));
        }
    }

    public static void test2(String equation) {

//        String[] temp = equation.split("\\+");
        int result = Arrays.asList(equation.split("\\+")).stream().mapToInt(i -> Integer.parseInt(i)).sum();
        logger.debug("result : {}", result);
    }
}

