package com.yuna.code;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class CodeWarsThird {

    private static final Logger logger = LoggerFactory.getLogger(CodeWarsThird.class);

    public static void main(String[] args) {
        logger.debug("execute Time: {}", calculateCache(new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}, 3));
        logger.debug("execute Time: {}", calculateCache(new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}, 3));
        logger.debug("execute Time: {}", calculateCache(new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}, 2));
        logger.debug("execute Time: {}", calculateCache(new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}, 5));
        logger.debug("execute Time: {}", calculateCache(new String[]{"Jeju", "Pangyo", "NewYork", "newyork"}, 2));
        logger.debug("execute Time: {}", calculateCache(new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}, 0));
    }

    public static int calculateCache(String[] cities, int cacheSize) {
        List<String> cache = new LinkedList<>();
        int time = 0;

        for(String city : cities) {
            city = city.toUpperCase();
            //cache hit
            if(cache.contains(city)) {
                cache.remove(city);
                cache.add(city);
                time++;
            // cache miss
            } else {
                if(cacheSize == 0) {

                } else if (cache.size() < cacheSize ) {
                    cache.add(city);
                } else {
                    cache.remove(0);
                    cache.add(city);
                }
                time += 5;
            }
        }
        return time;
    }

}
