package com.test11_6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practice11_6 {

    public static void main(String[] args) {
        int[] arr = new int[]{4,2,1,3};
        Solution solution = new Solution();
        System.out.println(solution.minimumAbsDifference(arr));
    }
}


//最小绝对差（LeetCode）

//给你个整数数组 arr，其中每个元素都 不相同。
//
//        请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> lists = new ArrayList<>();
        int min = getMinMinus(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] == min) {
                List<Integer> list = new ArrayList<>();
                list.add(arr[i]);
                list.add(arr[i+1]);
                lists.add(list);
            }
        }
        return lists;
    }

    /**
     * 获取数组元素的最小差
     * @param arr 数组
     * @return
     */
    private int getMinMinus(int[] arr) {
        int min = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            int value = arr[i + 1] - arr[i];
            min = Math.min(value,min);
        }
        return min;
    }
}