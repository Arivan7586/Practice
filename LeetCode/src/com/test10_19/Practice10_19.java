package com.test10_19;

import java.util.ArrayList;

public class Practice10_19 {

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();

        System.out.println(solution1.hasPath("ABCESFCSADEE".toCharArray(),
                3, 4, "ABCB".toCharArray()));
    }
}


//二叉树的下一个节点（剑指offer）

//给定一个二叉树和其中的一个节点，请找出中序遍历顺序的下一个节点并返回结果。
//注意，书中的节点不仅包括左右子节点，同时包括指向父节点的指针。
class TreeLinkNode {
    int val;
    TreeLinkNode left;
    TreeLinkNode right;
    TreeLinkNode next;

    public TreeLinkNode(int val) {
        this.val = val;
    }
}

class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }
        while (pNode.next != null) {
            if (pNode.next.left == pNode) {
                return pNode.next;
            }
            pNode = pNode.next;
        }
        return null;
    }
}

//矩阵中的路径（剑指offer）

//请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径，
//路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向上、向下、向左向右移动
//一个格子，如果一条路景经过了矩阵中的某个格子，则该路径不能再进入该格子。
class Solution1 {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || str == null) {
            return false;
        }
        char[][] arr = new char[rows][cols];
        int index = 0;
        //初始化矩阵
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] = matrix[index++];
            }
        }
        char start = str[0];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (arr[i][j] == start) {
                    ArrayList<String> list = new ArrayList<>();
                    if (success(arr, i, j, str, 1, list)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 记录所走过的路径
     *
     * @param arr   二维矩阵
     * @param i     横坐标
     * @param j     纵坐标
     * @param str   目标路径
     * @param index 在目标路径中的位置
     * @param list  走过的位置
     * @return 到达终点返回true，否则返回false
     */
    private boolean success(char[][] arr, int i, int j, char[] str,
                            int index, ArrayList<String> list) {
        if (i < 0 || i >= arr.length || j < 0 || j >= arr[0].length ||
                list.contains(i + "," + j)) {
            return false;
        }
        if (index == str.length && str[index - 1] == arr[i][j]) {
            return true;
        }
        if (str[index - 1] != arr[i][j]) {
            return false;
        }
        list.add(i + "," + j);
        return success(arr, i - 1, j, str, index + 1, list) ||
                success(arr, i + 1, j, str, index + 1, list) ||
                success(arr, i, j - 1, str, index + 1, list) ||
                success(arr, i, j + 1, str, index + 1, list);
    }
}