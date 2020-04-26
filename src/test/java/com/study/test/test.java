package com.study.test;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @version ：V1.0
 * @program: my-project
 * @description:
 * @author: zhj
 * @create: 2020-04-21 14:37
 */
public class test {

    public static void main(String[] args) {
        String prefix = getType(new Date());

        System.out.println(prefix);

        String orderId = prefix + String.format("%1$06d", 1);

        System.out.println(orderId);
    }

    private static String getType(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        //补两位,因为一年最多三位数
        String monthFormat = String.format("%1$02d", month + 1);
        //补两位，因为日最多两位数
        String dayFormat = String.format("%1$02d", day);
        //补两位，因为小时最多两位数
        String hourFormat = String.format("%1$02d", hour);
        return year + monthFormat + dayFormat + hourFormat;

    }

    @Test
    public void test(){

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        //2.1获取当前时间
        int hour = calendar.get(Calendar.HOUR_OF_DAY);

        String key = "UPDATE_GOOD_LIST:" + hour;

        System.out.println(hour);
        System.out.println(key);
    }


    @Test
    public void test2(){
        AtomicInteger trendType = new AtomicInteger(0);
        System.out.println(trendType);
        trendType.addAndGet(1);
        System.out.println(trendType);
        trendType.addAndGet(-1);
        System.out.println(trendType);
    }
}