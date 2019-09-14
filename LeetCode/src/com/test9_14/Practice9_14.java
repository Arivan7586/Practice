package com.test9_14;

public class Practice9_14 {

    public static void main(String[] args) {
        char[][] arr = {{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}};
        Solution solution = new Solution();
        System.out.println(solution.countBattleships(arr));

        int valye = Solution1.sumOfZero(Integer.MAX_VALUE);
        System.out.println(valye);
    }
}

//甲板上的战舰

//给定一个二维的甲板， 请计算其中有多少艘战舰。 战舰用 'X'表示，空位用 '.'表示。 
//        你需要遵守以下规则：
//
//        给你一个有效的甲板，仅由战舰或者空位组成。
//        战舰只能水平或者垂直放置。换句话说,战舰只能由 1xN (1 行, N 列)组成，
//        或者 Nx1 (N 行, 1 列)组成，其中N可以是任意大小。
//        两艘战舰之间至少有一个水平或垂直的空位分隔 - 即没有相邻的战舰
class Solution {
    public int countBattleships(char[][] board) {
        if (board == null || board.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'X') {
                    boolean flag = true;
                    if (i > 0 && board[i-1][j] == 'X') {
                        flag = false;
                    }
                    if (j > 0 && board[i][j-1] == 'X') {
                        flag = false;
                    }
                    if (flag) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}

//阶乘后的零

//    给定一个整数 n，返回 n! 结果尾数中零的数量。
//
//        示例 1:
//
//        输入: 3
//        输出: 0
//        解释: 3! = 6, 尾数中没有零。
//        示例 2:
//
//        输入: 5
//        输出: 1
//        解释: 5! = 120, 尾数中有 1 个零
class Solution1 {
    public static int sumOfZero(long n) {
        int count = 0;
        while (n >= 5) {
            if (n % 5 == 0) {
                count += n / 5;
                n /= 5;
            } else {
                n--;
            }
        }
        return count;
    }
}