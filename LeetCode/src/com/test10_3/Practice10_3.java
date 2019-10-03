package com.test10_3;

import java.util.ArrayList;
import java.util.List;

public class Practice10_3 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.movingCount(5, 10, 10));

    }
}

//机器人的运动范围（剑指offer）
//地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
//        每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标
//        和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格
//        （35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），
//        因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
class Solution {
    private List<String> list = new ArrayList<>();
    public int movingCount(int threshold, int rows, int cols) {
        if (rows == 0 || cols == 0) {
            return 0;
        }
        run(0,0,threshold,rows,cols);
        return list.size();
    }
    private void run(int i, int j, int k, int rows, int cols) {
        if (i < 0 || j < 0 || i >= rows || j >= cols) {
            return;
        }
        if (getSum(i) + getSum(j) <= k) {
            if (list.contains(i + "," + j)) {
                return;
            }
            list.add(i + "," + j);
            run(i - 1,j,k,rows,cols);
            run(i + 1,j,k,rows,cols);
            run(i,j - 1,k,rows,cols);
            run(i,j + 1,k,rows,cols);
        }
    }
    private int getSum(int value) {
        if (value == 0) {
            return 0;
        }
        int sum = 0;
        while (value > 0) {
            sum += value % 10;
            value /= 10;
        }
        return sum;
    }
}



class Solution1 {
    public int movingCount(int threshold, int rows, int cols) {
        int flag[][] = new int[rows][cols]; //记录是否已经走过
        return helper(0, 0, rows, cols, flag, threshold);
    }

    private int helper(int i, int j, int rows, int cols, int[][] flag, int threshold) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || numSum(i) + numSum(j) > threshold || flag[i][j] == 1) return 0;
        flag[i][j] = 1;
        return helper(i - 1, j, rows, cols, flag, threshold)
                + helper(i + 1, j, rows, cols, flag, threshold)
                + helper(i, j - 1, rows, cols, flag, threshold)
                + helper(i, j + 1, rows, cols, flag, threshold)
                + 1;
    }

    private int numSum(int i) {
        int sum = 0;
        do {
            sum += i % 10;
        } while ((i = i / 10) > 0);
        return sum;
    }
}