package com.test8_29;

import javax.xml.transform.SourceLocator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Practice8_29 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.reverseStr("abcdefg",2));
    }
}

//反转字符串II
class Solution {
    public String reverseStr(String s, int k) {
        if (s == null || s.equals("")) {
            return s;
        }
        int flag = 1;
        int i = 0;
        StringBuilder res = new StringBuilder();
        while (i < s.length()) {
            int n = 0;
            if (i + k <= s.length()) {
                n = i + k;
            } else {
                n = s.length();
            }
            StringBuilder value = new StringBuilder(s.substring(i,n));
            if (flag++ % 2 == 1) {
                value.reverse();
            }
            res.append(value);
            i += k;
        }
        return res.toString();
    }
}

//二叉树的后续遍历（非递归）
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
class Solution1 {
    private List<Integer> list = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
//        traversal(root);
        Collections.reverse(list);
        return list;
    }
    private void traversal(TreeNode node) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        traversal(node.right);
        traversal(node.left);
    }
}


//使用最小的花费爬楼梯
class Solution2 {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (i <= 1) {
                dp[i] = cost[i];
            } else {
                dp[i] = Math.min(dp[i-1], dp[i-2]) + cost[i];
            }
        }
        return Math.min(dp[n-1],dp[n-2]);
    }
}
