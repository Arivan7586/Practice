package com.test11_5;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Practice11_5 {

    public static void main(String[] args) {


    }
}


// 公平的糖果交换（LeetCode）
//爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 块糖的大小，B[j]
//        是鲍勃拥有的第 j 块糖的大小。
//        因为他们是朋友，所以他们想交换一个糖果棒，这样交换后，他们都有相同的糖果总量。
//        （一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
//        返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，
//        ans[1] 是 Bob 必须交换的糖果棒的大小。
//        如果有多个答案，你可以返回其中任何一个。保证答案存在。

class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = getSum(A);
        int sumB = getSum(B);
        int value = (sumA - sumB) / 2;

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            set.add(A[i]);
        }

        for (int i : B) {
            if (set.contains(i + value)) {
                return new int[]{i + value,i};
            }
        }
        return null;
    }

    /**
     * 计算给定数组的元素之和
     * @param arr 给定数组
     * @return 返回求和后的结果
     */
    private int getSum(int[] arr) {
        if (arr == null) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
