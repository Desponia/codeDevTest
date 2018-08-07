package com.yuna.inaction;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

public class ChapterSixTest {

    private static final Logger logger = LoggerFactory.getLogger(ChapterSixTest.class);

    @Test
    public void 테스트일() {
        assertEquals("pork", ChapterSix.test1());
    }

    @Test
    public void 테스트2() {
        assertEquals(4300, ChapterSix.test2());
    }

    @Test
    public void 테스트삼() {
        ChapterSix.test3();
    }

    @Test
    public void 리듀싱테스트() {
        ChapterSix.reducingTest();
    }

    @Test
    public void 그루핑테스트() {
        ChapterSix.groupingTest();
    }

}