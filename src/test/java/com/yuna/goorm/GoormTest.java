package com.yuna.goorm;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

public class GoormTest {
    private static final Logger logger = LoggerFactory.getLogger(GoormTest.class);

    @Test
    public void 테스트1() {
        logger.debug(" test  : {} ", Goorm.test1(20));
    }

    @Test
    public void 테스트2() {
        Goorm.test2("1+2+3");

//        logger.debug("test : {}", Goorm.test2("1+2+3"));
    }

}