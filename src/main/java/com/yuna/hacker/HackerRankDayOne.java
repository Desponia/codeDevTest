package com.yuna.hacker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.HashSet;

import static java.lang.System.in;

import java.util.Set;

public class HackerRankDayOne {
    private static final Logger logger = LoggerFactory.getLogger(HackerRankDayOne.class);

    // https://www.hackerrank.com/challenges/prime-checker/problem
    public static void main(String[] args) {
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            int n1 = Integer.parseInt(br.readLine());
            int n2 = Integer.parseInt(br.readLine());
            int n3 = Integer.parseInt(br.readLine());
            int n4 = Integer.parseInt(br.readLine());
            int n5 = Integer.parseInt(br.readLine());
            Prime ob = new Prime();
            ob.checkPrime(n1);
            ob.checkPrime(n1, n2);
            ob.checkPrime(n1, n2, n3);
            ob.checkPrime(n1, n2, n3, n4, n5);
            Method[] methods = Prime.class.getDeclaredMethods();
            Set<String> set = new HashSet<>();
            boolean overload = false;
            for (int i = 0; i < methods.length; i++) {
                if (set.contains(methods[i].getName())) {
                    overload = true;
                    break;
                }
                set.add(methods[i].getName());

            }
            if (overload) {
                throw new Exception("Overloading not allowed");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}

class Prime {
    void checkPrime(int... args) {
        for (int num : args) {
            // 소수 prime number
            if(BigInteger.valueOf(num).isProbablePrime(1)) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
    }
}

interface Food {
    public String getType();
}

class Pizza implements Food {

    @Override
    public String getType() {
        return "Someone ordered a Fast Food!";
    }
}

class Cake implements Food {

    @Override
    public String getType() {
        return "Someone ordered a Dessert!";
    }
}

class FoodFactory {
    public Food getFood(String order) {
        Food food = null;
        try {
            food = (Food) Class.forName("com.yuna.hacker."+order.substring(0, 1).toUpperCase() + order.substring(1).toLowerCase()).newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }


        return food;
    }
}