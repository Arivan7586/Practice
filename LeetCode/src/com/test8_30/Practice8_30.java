package com.test8_30;

import java.util.*;

public class Practice8_30 {

    public static void main(String[] args) {
        int[] arr1 = new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = new int[]{2, 1, 4, 3, 9, 6};
        Solution2 solution2 = new Solution2();
        int[] res = solution2.relativeSortArray(arr1, arr2);
        int[] res1 = solution2.relativeSortArray(new int[]{28, 6, 22, 8, 44, 17},
                new int[]{22, 28, 8, 6});
        printArray(res);
        printArray(res1);

    }

    private static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

//区域和检索-数组不可变（LeetCode）
class NumArray {
    private List<Integer> list = new ArrayList<>();

    public NumArray(int[] nums) {
        if (nums != null) {
            for (int i = 0; i < nums.length; i++) {
                if (i == 0) {
                    list.add(nums[i]);
                } else {
                    list.add(list.get(i - 1) + nums[i]);
                }
            }
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) {
            return list.get(j);
        }
        return list.get(j) - list.get(i - 1);
    }
}

//判断子序列
class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.equals("")) {
            return true;
        }
        if (s.length() > t.length()) {
            return false;
        }
        int flag = 0;
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == s.charAt(flag)) {
                flag++;
            }
            if (flag >= s.length()) {
                return true;
            }
        }
        return flag >= s.length();
    }
}

//数组的相对顺序
class Solution2 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null ||
                arr1.length == 0 || arr2.length == 0) {
            return new int[]{};
        }
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }
        int[] values = new int[arr2.length];
        int n = arr1.length - arr2.length;
        List<Integer> nums = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (map.containsKey(arr1[i])) {
                int index = map.get(arr1[i]);
                values[index]++;
            } else {
                nums.add(arr1[i]);
            }
        }
        Collections.sort(nums);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            int count = values[i];
            for (int k = 0; k < count; k++) {
                list.add(arr2[i]);
            }
        }
        for (int i = 0; i < nums.size(); i++) {
            list.add(nums.get(i));
        }
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = list.get(i);
        }
        return arr1;
    }
}