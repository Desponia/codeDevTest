package com.yuna.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestApplicationTests {

    private static final Logger logger = LoggerFactory.getLogger(TestApplicationTests.class);

    @Test
    public void contextLoads() {
        String binary = Integer.toBinaryString(9);
        logger.debug(binary);
//        assert.equals();
    }

}
