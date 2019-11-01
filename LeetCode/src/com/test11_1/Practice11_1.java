package com.test11_1;

import java.util.*;

public class Practice11_1 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] arr = {1,2,2,3,1};
        System.out.println(solution.findShortestSubArray(arr));


        Map<Integer,Integer> map = new HashMap<>();
        for (int i : arr) {
            if (map.containsKey(i)) {
                map.put(i,map.get(i) + 1);
            } else {
                map.put(i,1);
            }
        }
        System.out.println(map);

    }
}

//数组的度（LeetCode）
//给定一个非空且只包含非负数的整数数组 nums, 
//        数组的度的定义是指数组里任一元素出现频数的 最大值。
//
//        你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
//
//        示例 1:
//
//        输入: [1, 2, 2, 3, 1]
//        输出: 2
//        解释:
//        输入数组的度是2，因为元素1和2的出现频数最大，均为2.
//        连续子数组里面拥有相同度的有如下所示:
//        [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
//        最短连续子数组[2, 2]的长度为2，所以返回2.

class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i,map.get(i) + 1);
            } else {
                map.put(i,1);
            }
        }

        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        //给数字按照出现次数进行降序排序
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        //获取出现次数最多的数字
        int maxTime = list.get(0).getValue();
        int minLength = Integer.MAX_VALUE;
        for (Map.Entry<Integer,Integer> entry : list) {
            if (entry.getValue() < maxTime) {
                break;
            }
            int length = getLength(nums,entry.getKey());
            minLength = Math.min(minLength,length);
        }
        return minLength;
    }

    private int getLength(int[] arr, int value) {
        int start = -1;
        int end = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                if (start == -1) {
                    start = i;
                }
                end = i;
            }
        }
        return end - start + 1;
    }
}