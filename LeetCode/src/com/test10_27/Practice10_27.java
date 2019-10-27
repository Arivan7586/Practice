package com.test10_27;

import java.util.Arrays;

public class Practice10_27 {

    public static void main(String[] args) {

//        Solution solution = new Solution();
//        System.out.println(solution.dayOfYear("1900-03-25"));


        Solution1 solution1 = new Solution1();
        System.out.println(solution1.countPrimes(10));
        System.out.println(solution1.countPrimes(499979));
    }
}


//一年中的第几天（LeetCode）

//    给你一个按 YYYY-MM-DD 格式表示日期的字符串 date，请你计算并返回该日期是当年的第几天。
//
//        通常情况下，我们认为 1 月 1 日是每年的第 1 天，1 月 2 日是每年的第 2 天，
//        依此类推。每个月的天数与现行公元纪年法（格里高利历）一致。

class Solution {
    public int dayOfYear(String date) {
        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
        String[] dates = date.trim().split("-");
        if (isLeapYear(dates[0])) { //如果当前年份位闰年，则二月有29天
            days[1] = 29;
        }
        int sum = 0;
        int month = Integer.valueOf(dates[1]);
        for (int i = 1; i < month; i++) {
            sum += days[i-1];
        }
        return sum + Integer.valueOf(dates[2]);
    }

    /**
     * 判断给定年份是否为闰年
     * @param year 给定年份
     * @return 是闰年，返回true，否则返回false
     */
    private boolean isLeapYear(String year) {
        int value = Integer.valueOf(year);
        return (value % 4 == 0 && value % 100 != 0) || value % 400 == 0;
    }
}

//计数质数(LeetCode)

//统计所有小于非负整数 n 的质数的数量。
class Solution1 {
    public int countPrimes(int n) {
        boolean[] arr = new boolean[n];
        Arrays.fill(arr,true);
        for (int i = 2; i * i < n; i++) {
            if (arr[i]) {
                for (int j = i * i; j < n; j += i) {
                    arr[j] = false;
                }
            }
        }

        int sum = 0;
        for (int i = 2; i < arr.length; i++) {
            if (arr[i]) {
                sum++;
            }
        }
        return sum;
    }
}