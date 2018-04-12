package com.yuna.hacker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.IntStream;

import static java.lang.System.in;

public class HackerRankDayOne {
    private static final Logger logger = LoggerFactory.getLogger(HackerRankDayOne.class);

    // https://www.hackerrank.com/challenges/prime-checker/problem
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
/*

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
            }*/


            // https://www.hackerrank.com/challenges/java-lambda-expressions/problem
            // 이거 하는 중임 안됨
            MyMath ob = new MyMath();
            int T = Integer.parseInt(br.readLine());
            PerformOperation op;
            boolean ret = false;
            String ans = null;
            while (T --> 0) {
                String s = br.readLine().trim();
                StringTokenizer st = new StringTokenizer(s);
                int ch = Integer.parseInt(st.nextToken());
                int num = Integer.parseInt(st.nextToken());

                if( ch == 1 ) {
                    op = ob.isOdd();
                    ret = ob.checker(op, num);
                    ans = ret ? "ODD" : "EVEN";
                } else if(ch == 2) {
                    op = ob.isPrime();
                    ret = ob.checker(op, num);
                    ans = ret ? "PRIME" : "COMPOSITE";
                } else if (ch == 3) {
                    op = ob.isPalindrome();
                    ret = ob.checker(op, num);
                    ans = ret? "PALINDROME" : "NOT PARLINDROME";
                }
                System.out.println(ans);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        // https://www.hackerrank.com/challenges/java-comparator/problem
/*
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();
        for(int i = 0 ; i < n ; i++ ) {
            player[i] = new Player(sc.next(), sc.nextInt());
        }
        sc.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++ ) {
            System.out.print(String.format("%s %s\n", player[i].name, player[i].score));
        }
*/



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
        return null;
    }
}


// https://www.hackerrank.com/challenges/java-comparator/problem
class Player {

    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class Checker implements Comparator<Player> {
    @Override
    public int compare(Player o1, Player o2) {
        if(o2.score == o1.score) {
            return o1.name.compareTo(o2.name);
        } else  {
            return o2.score - o1.score;
        }
    }
}


// https://www.hackerrank.com/challenges/java-lambda-expressions/problem
interface PerformOperation {
    boolean check(int a);
}

class MyMath {
    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    public PerformOperation isOdd() {

        return (int a) -> a%2 != 0 ;
    }

    public PerformOperation isPrime() {
        //        return (int a) -> IntStream.range(2, (int)Math.sqrt(a + 1)).noneMatch( i -> a%1 == 0);
        //        return (int a) -> BigInteger.valueOf(a).isProbablePrime(1);

        return (int a) -> {
            if(a < 2) return false;
            for( int i = 0 ; i*i <= a; i++ )
                if (a%i == 0) return false;
                return true;
        };
    }

    public PerformOperation isPalindrome() {
        return (int a) -> Integer.toString(a).equals(new StringBuilder(Integer.toString(a)).reverse().toString());
    }
}
