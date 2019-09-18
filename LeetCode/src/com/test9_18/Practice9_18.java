package com.test9_18;

import java.util.Arrays;
import java.util.Scanner;

public class Practice9_18 {
    public static void main(String[] args) {

    }
}

//最长等差数列
class Solution {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            System.out.println(maxLength(arr));
        }
        in.close();
    }

    private static int maxLength(int[] arr) {
        if (arr.length < 2) {
            return 0;
        }
        int maxLength = 0;
        Arrays.sort(arr);
        if (arr[0] == arr[arr.length - 1]) {
            return arr.length;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int current = j;
                int value = 2;
                int gap = arr[j] - arr[i];
                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[k] - arr[current] == gap) {
                        value = value + 1;
                        current = k;
                    }
                    if (arr[k] - gap > arr[current]) {
                        break;
                    }
                }
                maxLength = Math.max(maxLength,value);
            }
        }
        return maxLength;
    }
}


//验证IP地址
class Solution1 {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String value = in.next();
            System.out.println(judge(value));
        }
        in.close();
    }

    private static String judge(String value) {
        if (value == null || value.equals("")) {
            return "Neither";
        }
        value = value.toUpperCase();
        //判断给定字符串是否是IPv6地址
        if (value.contains(":")) {
            String[] values = value.trim().split(":");
            if (values.length != 8) {
                return "Neither";
            }
            for (int i = 0; i < values.length; i++) {
                if (values[i].equals("") || values[i].length() > 4) {
                    return "Neither";
                }
            }
            return "IPv6";
        } else {
            String[] values = value.trim().split("\\.");
            if (values.length != 4) {
                return "Neither";
            }
            for (int i = 0; i < values.length; i++) {
                if (values[i].equals("") || Integer.valueOf(values[i]) > 255 ||
                        Integer.valueOf(values[i]) < 0 || values[i].startsWith("0")) {
                    return "Neither";
                }
            }
            return "IPv4";
        }
    }
}