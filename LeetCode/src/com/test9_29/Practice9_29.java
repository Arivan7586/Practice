package com.test9_29;

public class Practice9_29 {

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[] arr = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(solution1.maxArea(arr));

    }
}

//字符串中的单词数（LeetCode）
//统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
//
//        请注意，你可以假定字符串里不包括任何不可打印的字符。
class Solution {
    public int countSegments(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        int count = 0;
        boolean lastIsBlank = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                lastIsBlank = true;
            } else {
                if (lastIsBlank) {
                    count++;
                }
                lastIsBlank = false;
            }
        }
        return count;
    }
}

//盛最多水的容器
//给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
//        在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
//        找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
//
//        说明：你不能倾斜容器，且 n 的值至少为 2。
//示例:
//
//        输入: [1,8,6,2,5,4,8,3,7]
//        输出: 49

class Solution1 {
    public int maxArea(int[] height) {
        if (height == null) {
            return 0;
        }
        int maxArea = 0;
        int high = -1;
        for (int i = 0; i < height.length; i++) {
            if (height[i] <= high) {
                continue;
            }
            high = i;
            for (int j = i + 1; j < height.length; j++) {
                int max = (j - i) * Math.min(height[i],height[j]);
                maxArea = Math.max(maxArea,max);
            }
        }
        return maxArea;
    }
}