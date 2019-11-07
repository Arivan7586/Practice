package com.test11_7;

import java.util.ArrayList;
import java.util.List;

public class Practice11_7 {

    public static void main(String[] args) {

        int[][] queens = {{0,1},{1,0},{4,0},{0,4},{3,3},{2,4}};
        int[] king = {0,0};

        int[][] queens1 = {{5,6},{7,7},{2,1},{0,7},{1,6},{5,1},
        {3,7},{0,3},{4,0},{1,2},{6,3},{5,0},{0,4},{2,2},{1,1},{6,4},
        {5,4},{0,0},{2,6},{4,5},{5,2},{1,4},{7,5},{2,3},{0,5},{4,2},
        {1,0},{2,7},{0,1},{4,6},{6,1},{0,6},{4,3},{1,7}};
        int[] king1 = {3,4};
        
        Solution solution = new Solution();
        System.out.println(solution.queensAttacktheKing(queens,king));
        System.out.println(solution.queensAttacktheKing(queens1,king1));
    }
}


//可以攻击国王的皇后（LeetCode）
//在一个 8x8 的棋盘上，放置着若干「黑皇后」和一个「白国王」。
//
//        「黑皇后」在棋盘上的位置分布用整数坐标数组 queens 表示，「白国王」的坐标用数组
//        king 表示。
//
//        「黑皇后」的行棋规定是：横、直、斜都可以走，步数不受限制，但是，不能越子行棋。
//
//        请你返回可以直接攻击到「白国王」的所有「黑皇后」的坐标（任意顺序）。

class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> lists = new ArrayList<>();
        //先将所有皇后的坐标保存到List中
        List<String> list = new ArrayList<>();
        for (int i = 0; i < queens.length; i++) {
            list.add("[" + queens[i][0] + "," + queens[i][1] + "]");
        }

        int x = king[0];
        int y = king[1];
        for (int i = 1; x - i >= 0; i++) {
            String value = "[" + (x - i) + "," + y + "]";
            if (list.contains(value)) {
                List<Integer> list1 = new ArrayList<>();
                list1.add(x - i);
                list1.add(y);
                lists.add(list1);
                break;
            }
        }

        for (int i = 1; x + i < 8; i++) {
            String value = "[" + (x + i) + "," + y + "]";
            if (list.contains(value)) {
                List<Integer> list1 = new ArrayList<>();
                list1.add(x + i);
                list1.add(y);
                lists.add(list1);
                break;
            }
        }

        for (int i = 1; y - i >= 0; i++) {
            String value = "[" + x + "," + (y - i) + "]";
            if (list.contains(value)) {
                List<Integer> list1 = new ArrayList<>();
                list1.add(x);
                list1.add(y - i);
                lists.add(list1);
                break;
            }
        }

        for (int i = 1; y + i < 8; i++) {
            String value = "[" + x + "," + (y + i) + "]";
            if (list.contains(value)) {
                List<Integer> list1 = new ArrayList<>();
                list1.add(x);
                list1.add(y + i);
                lists.add(list1);
                break;
            }
        }

        for (int i = 1; x - i >= 0 && y - i >= 0; i++) {
            String value = "[" + (x - i) + "," + (y - i) + "]";
            if (list.contains(value)) {
                List<Integer> list1 = new ArrayList<>();
                list1.add(x - i);
                list1.add(y - i);
                lists.add(list1);
                break;
            }
        }

        for (int i = 1; x + i < 8 && y + i < 8; i++) {
            String value = "[" + (x + i) + "," + (y + i) + "]";
            if (list.contains(value)) {
                List<Integer> list1 = new ArrayList<>();
                list1.add(x + i);
                list1.add(y + i);
                lists.add(list1);
                break;
            }
        }

        for (int i = 1; x + i < 8 && y - i >= 0; i++) {
            String value = "[" + (x + i) + "," + (y - i) + "]";
            if (list.contains(value)) {
                List<Integer> list1 = new ArrayList<>();
                list1.add(x + i);
                list1.add(y - i);
                lists.add(list1);
                break;
            }
        }

        for (int i = 1; x - i >= 0 && y + i < 8; i++) {
            String value = "[" + (x - i) + "," + (y + i) + "]";
            if (list.contains(value)) {
                List<Integer> list1 = new ArrayList<>();
                list1.add(x - i);
                list1.add(y + i);
                lists.add(list1);
                break;
            }
        }
        return lists;
    }
}