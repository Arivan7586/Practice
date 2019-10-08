package com.test10_8;

public class Practice10_8 {

    public static void main(String[] args) {


    }
}

//范围求和II（LeetCode）

//给定一个初始元素全部为 0，大小为 m*n 的矩阵 M 以及在 M 上的一系列更新操作。
//
//        操作用二维数组表示，其中的每个操作用一个含有两个正整数 a 和 b 的数组表示，
//        含义是将所有符合 0 <= i < a 以及 0 <= j < b 的元素 M[i][j] 的值都增加1。
//
//        在执行给定的一系列操作后，你需要返回矩阵中含有最大整数的元素个数

class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        if (ops == null) {
            return 0;
        }
        if (ops.length == 0) {
            return m * n;
        }
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        for (int i = 0; i < ops.length; i++) {
            minX = Math.min(ops[i][0], minX);
            minY = Math.min(ops[i][1], minY);
        }
        return minX * minY;
    }
}

//计数二进制子串

//给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，
//        并且这些子字符串中的所有0和所有1都是组合在一起的。
//
//        重复出现的子串要计算它们出现的次数。
class Solution1 {
    public int countBinarySubstrings(String s) {
        char[] chars = s.toCharArray();
        int count = 1, pre = 0;
        int res = 0;
        for (int i = 1; i < chars.length; i++)
            if (chars[i - 1] == chars[i]) count++;
            else {
                res += Math.min(pre, count);
                pre = count;
                count = 1;
            }
        res += Math.min(pre, count);
        return res;
    }
}