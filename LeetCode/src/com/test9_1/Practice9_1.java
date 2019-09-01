package com.test9_1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Practice9_1 {

    public static void main(String[] args) {
        Solution.solution();

        Solution1 solution1 = new Solution1();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(0);
        TreeNode t3 = new TreeNode(1);
        TreeNode t4 = new TreeNode(0);
        TreeNode t5 = new TreeNode(0);
        TreeNode t6 = new TreeNode(0);
        TreeNode t7 = new TreeNode(1);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        System.out.println(solution1.pruneTree(t1));
//        printTree(t1);
    }
    private static void printTree(TreeNode node) {
        if (node == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode currentNode = stack.pop();
            System.out.print(currentNode.val + " ");
            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }
            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }
        }
        System.out.println();
    }
}

//寻找子串
//英语老师看你老是在英语课上和周围同学交头接耳，所以给你布置了一份额外的家庭作业
// 来惩罚惩罚你：你有一个字符串s，请你在s的所有子串中，找到出现次数最多的子串，
// 告诉老师它的出现次数。
//
//        输入
//        共一行，一个字符串s，仅由英文小写字母组成，1≤|s|≤10000。
//        输出
//        一个正整数，表示最大出现次数。
//        样例输入
//        aba
//        样例输出
//        2
//        提示
//        aba的所有子串为a、b、a、ab、ba、aba，其中a的出现次数最多，出现了2次。
class Solution {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.next();
            System.out.println(maxTimes(str));
        }
        in.close();
    }
    private static int maxTimes(String str) {
        if (str == null || str.equals("")) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char key = str.charAt(i);
            if (map.containsKey(key)) {
                int value = map.get(key) + 1;
                map.put(key,value);
                max = Math.max(value,max);
            } else {
                map.put(key,1);
                max = Math.max(1,max);
            }
        }
        return max;
    }
}

////二叉树剪枝
//给定二叉树根结点 root ，此外树的每个结点的值要么是 0，要么是 1。
//
//        返回移除了所有不包含 1 的子树的原二叉树。
//
//        ( 节点 X 的子树为 X 本身，以及所有 X 的后代。)
//
//        示例1:
//        输入: [1,null,0,0,1]
//        输出: [1,null,0,null,1]
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
class Solution1 {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        return root;
    }
}