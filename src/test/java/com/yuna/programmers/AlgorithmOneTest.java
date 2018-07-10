package com.yuna.programmers;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class AlgorithmOneTest {

    @Test
    public void 솔루션원테스트() {
        Assert.assertEquals("c", AlgorithmOne.solutionOne("abcde"));
        Assert.assertEquals("we", AlgorithmOne.solutionOne("qwer"));
    }

    @Test
    public void 솔루션투테스트() {
//        AlgorithmOne.solutionTwo(arr);
        assertEquals(Arrays.toString(new int[]{1, 3, 0, 1}), Arrays.toString(AlgorithmOne.solutionTwo(new int[]{1, 1, 3, 3, 0, 1, 1})));
        assertEquals(Arrays.toString(new int[]{4, 3}), Arrays.toString(AlgorithmOne.solutionTwo(new int[]{4, 4, 4, 3, 3})));
    }

    @Test
    public void 솔루션쓰리테스트() {
        assertEquals(true, AlgorithmOne.solutionThree("pPoooyY"));
        assertEquals(false, AlgorithmOne.solutionThree("Pyy"));

    }

    @Test
    public void 솔루션포테스트() {
        assertEquals(true, AlgorithmOne.solutionFour("(())()"));
        assertEquals(true, AlgorithmOne.solutionFour("()()"));
        assertEquals(true, AlgorithmOne.solutionFour("((((((((()))))))))()((())())"));
        assertEquals(false, AlgorithmOne.solutionFour(")()("));
        assertEquals(false, AlgorithmOne.solutionFour("(()("));
    }

    @Test
    public void 솔루션오테스트() {
//        AlgorithmOne.solutionFive("3people unFollowed me");
//        AlgorithmOne.solutionFive("for the last week");

        assertEquals("3people Unfollowed Me", AlgorithmOne.solutionFive("3people unFollowed me"));
        assertEquals("For The Last Week", AlgorithmOne.solutionFive("for the last week"));
    }

    @Test
    public void 솔루션육테스트() {
//        AlgorithmOne.solitionSix(78);
//        AlgorithmOne.solitionSix(15);
        assertEquals(83, AlgorithmOne.solitionSix(78));
        assertEquals(23, AlgorithmOne.solitionSix(15));
    }

    @Test
    public void 솔루션세븐테스트() {
        Map<Integer, Integer> testMap = new HashMap<>();
        testMap.put(1, 1);
        testMap.put(2, 2);
        testMap.put(3, 4);
        testMap.put(4, 11);
        testMap.put(5, 12);
        testMap.put(6, 14);
        testMap.put(7, 21);
        testMap.put(8, 22);
        testMap.put(9, 24);
        testMap.put(10, 41);

        for(int i : testMap.keySet()) {
            assertEquals(AlgorithmOne.solutionSeven(i), String.valueOf(testMap.get(i)));
        }
    }

}