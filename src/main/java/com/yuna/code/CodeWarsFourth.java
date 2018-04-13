package com.yuna.code;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CodeWarsFourth {

    private static final Logger logger = LoggerFactory.getLogger(CodeWarsFourth.class);
    /**
     * 셔틀은 9시부터 n회 t분 간격  최대 m명
     * 9시에 도착한 버스에 자리가 있다면 9시에 도착한 사람도 탈 수 있음
     *
     *
     * 0 n <= 10
     * 0 < t <= 60
     * 0 < m <= 45
     *  -- > 젤 막차 시간을 알아야 함
     *
     * 00:01 ~ 23:59
     */

    public static void main(String[] args) {
        logger.debug("time : {}", lastTimeCanGoHome(11, 35));
    }

    public static String shuttleBus(int n, int t, int m, String[] timetable) {

        String answer = "";
        return answer;

    }

    private static String lastTimeCanGoHome(int n, int t) {
        double temp = Math.round((double)(n*t)/60 * 100d) / 100d;
        return 9 + (int)temp + ":" + (int)(temp * 100 - ((int)temp) * 100);
    }

}
