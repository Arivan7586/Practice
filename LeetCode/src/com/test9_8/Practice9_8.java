package com.test9_8;

import java.util.*;

public class Practice9_8 {

    public static void main(String[] args) {

//        TreeNode t1 = new TreeNode(1);
//        TreeNode t2 = new TreeNode(7);
//        TreeNode t3 = new TreeNode(0);
//        TreeNode t4 = new TreeNode(7);
//        TreeNode t5 = new TreeNode(-8);
//        t1.left = t2;
//        t1.right = t3;
//        t2.left = t4;
//        t2.right = t5;
//
//        Solution solution = new Solution();
//        System.out.println(solution.maxLevelSum(t1));

        Solution1 solution1 = new Solution1();
        int[] arr = solution1.distributeCandies(10,3);
        System.out.println(Arrays.toString(arr));
    }
}


//最大层内元素和
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
class Solution {
    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxValue = Integer.MIN_VALUE;
        int mindepth = Integer.MAX_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            int n = queue.size();
            int sum = 0;
            while (n-- > 0) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (sum == maxValue) {
                mindepth = Math.min(depth,mindepth);
            } else if (sum > maxValue) {
                maxValue = sum;
                mindepth = depth;
            }
            depth++;
        }
        return mindepth;
    }
}

//分糖果II
class Solution1 {
    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        int num = 1;
        int i = 0;
        while (i < res.length) {
            if (num < candies) {
                res[i++] += num;
                candies -= num;
                num++;
            } else {
                res[i++] += candies;
                break;
            }
            if (i == res.length) {
                i = 0;
            }
        }
        return res;
    }
}