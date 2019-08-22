package com.test8_22;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

public class Practice8_22 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] arr = solution.constructRectangle(1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}

//构造矩形
class Solution {
    public int[] constructRectangle(int area) {
        if (area <= 0) {
            return null;
        }
        int[] arr = new int[2];
        int width = (int)Math.sqrt(area);
        while (area % width != 0) {
            width--;
        }
        arr[0] = area / width;
        arr[1] = width;
        return arr;
    }
}

//二叉树中第二小的节点
class Solution1 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    private TreeSet<Integer> set = new TreeSet<>();
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        if (root.left == null || root.right == null) {
            return -1;
        }
        add(root);
        if (set.size() < 2) {
            return -1;
        }
        int i = 0;
        for (int j : set) {
            if (i == 1) {
                i = j;
                break;
            }
            i++;
        }
        return i;
    }
    private void add(TreeNode node) {
        if (node == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            set.add(temp.val);
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
    }
}