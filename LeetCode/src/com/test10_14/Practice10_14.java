package com.test10_14;

import java.util.Scanner;

public class Practice10_14 {

    public static void main(String[] args) {
//        Solution solution = new Solution();

        boolean res = Solution1.CheckBlackList("2.33.128.9","2.33.128.0/24");
        System.out.println(res);
    }
}

//动态规划路径
class Solution {
    private static int sum = 0;
    public static int DynamicPathPlanning(int[][] matrixGrid) {
        if (matrixGrid == null || matrixGrid.length == 0) {
            return 0;
        }
        int x = matrixGrid.length - 1;
        int y = matrixGrid[0].length - 1;
        run(matrixGrid,0,0,x,y);
        return sum;
    }
    private static void run(int[][] arr, int i, int j, int x, int y) {
        if (i == x && j == y) {
            sum++;
        }
        if (i < x && arr[i+1][j] == 0) {
            run(arr,i + 1, j, x, y);
        }
        if (j < y && arr[i][j+1] == 0) {
            run(arr,i, j + 1, x, y);
        }
    }
}

//IP黑名单
class Solution1 {
    public static boolean CheckBlackList(String userIP, String blackIP) {
        if (userIP == null || userIP.equals("") ||
        blackIP == null || blackIP.equals("")) {
            return false;
        }
        //判断给定ip黑名单是否为单个IP
        if (!blackIP.contains("/")) {
            return userIP.equals(blackIP);
        }
        String[] strings = blackIP.split("/");
        //将给定ip地址转换为二进制字符串
        String realIP = getBinary(strings[0]);
        int count = Integer.parseInt(strings[1]);

        StringBuilder child = new StringBuilder();
        int index = 0;
        for (int i = 0; i < realIP.length() && index < count; i++) {
            if (realIP.charAt(i) != '.') {
                index++;
            }
            child.append(realIP.charAt(i));
        }
        //构建最小的子网
        StringBuilder minChild = new StringBuilder(child.toString().replaceAll("\\.",""));
        while (minChild.length() < 32) {
            minChild.append("0");
        }
        String child1 = binToDecimal(minChild.toString());

        //构建最大的子网
        StringBuilder maxChild = new StringBuilder(child.toString().replaceAll("\\.",""));
        while (maxChild.length() < 32) {
            maxChild.append("1");
        }
        String child2 = binToDecimal(maxChild.toString());

        String[] arr1 = child1.trim().split("\\.");
        String[] arr2 = child1.trim().split("\\.");
        String[] target = userIP.trim().split("\\.");
        for (int i = 0; i < target.length; i++) {
            if (Integer.valueOf(target[i]) < Integer.valueOf(arr1[i])
            || Integer.valueOf(target[i]) > Integer.valueOf(arr2[i])) {
                return false;
            }
        }
        return true;
    }
    private static String getBinary(String ip) {
        String[] arr = ip.trim().split("\\.");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("0")) {
                sb.append("00000000");
            } else {
                sb.append(work(arr[i]));
            }
            if (i != arr.length - 1) {
                sb.append(".");
            }
        }
        return sb.toString();
    }
    private static String work(String string) {
        StringBuilder res = new StringBuilder();
        int value = Integer.parseInt(string);
        while (value > 0) {
            res.append(value % 2);
            value >>= 1;
        }
        while (res.length() < 8) {
            res.append("0");
        }
        return res.reverse().toString();
    }
    private static String binToDecimal(String string) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 32; i += 8) {
            String value = string.substring(i,i + 8);
            sb.append(Integer.valueOf(value,2).toString());
            if (i == 0 || i == 8 || i == 16) {
                sb.append(".");
            }
        }
        return sb.toString();
    }
}