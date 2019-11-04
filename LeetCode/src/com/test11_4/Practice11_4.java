package com.test11_4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Practice11_4 {

    public static void main(String[] args) {

        int[] arr = new int[]{6,2,3,4};
        int[] arr1 = new int[]{1,6,3,4,3,5};
        Solution solution = new Solution();
        System.out.println(solution.transformArray(arr));
        System.out.println(solution.transformArray(arr1));

    }
}

//数组变换(LeetCode)
class Solution {
    public List<Integer> transformArray(int[] arr) {
        if (arr.length <= 2) {
            return getList(arr);
        }
        boolean flag = false;
        while (true) {
            for (int i = 1; i < arr.length - 1; i++) {
                if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                    arr[i] -= 1;
                    flag = true;
                } else if (arr[i] < arr[i - 1] && arr[i] < arr[i + 1]) {
                    arr[i] += 1;
                    flag = true;
                }
            }
            if (flag) {
                flag = false;
            } else {
                break;
            }
        }
        return getList(arr);
    }

    /**
     * 将给定数组转换为List
     * @param arr 给定数组
     * @return 返回转换后的List
     */
    private List<Integer> getList(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        return list;
    }
}