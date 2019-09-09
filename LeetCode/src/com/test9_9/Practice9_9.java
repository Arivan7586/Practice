package com.test9_9;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Practice9_9 {

    public static void main(String[] args) {

        String s = "1-2--3--4-5--6--7";
        Solution solution = new Solution();
        solution.recoverFromPreorder(s);
        TreeNode node = solution.recoverFromPreorder("1-401--349---90--88");
        printNode(solution.recoverFromPreorder("1-401--349---90--88"));
        printNode(solution.recoverFromPreorder("10-1--8---8----1-----2"));
    }
    private static void printNode(TreeNode node) {
        if (node == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            System.out.print(node1.val + " ");
            if (node1.left != null) {
                queue.offer(node1.left);
            }
            if (node1.right != null) {
                queue.offer(node1.right);
            }
        }
        System.out.println();
    }
}


//从先序遍历还原二叉树(LeetCode)
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
class Solution {
    public TreeNode recoverFromPreorder(String S) {
        if (S == null || S.equals("")) {
            return null;
        }
        if (!S.contains("-")) {
            return new TreeNode(Integer.parseInt(S));
        }
        //找到根节点
        String value = "";
        int l = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '-') {
                value = S.substring(0,i);
                l = i;
                break;
            }
        }
        TreeNode root = new TreeNode(Integer.parseInt(value));
        //找到右子树的开头
        int r = S.length();
        int flag = 0;
        for (int i = 1; i < S.length() - 1; i++) {
            if (S.charAt(i) == '-' && S.charAt(i - 1) != '-' &&
            S.charAt(i + 1) != '-') {
                if (flag == 1) {
                    r = i;
                    break;
                }
                flag++;
            }
        }
        //还原左右子树
        String left = solution(S.substring(l,r));
        String right = "";
        if (r < S.length()) {
            right = solution(S.substring(r));
        }
        root.left = recoverFromPreorder(left);
        root.right = recoverFromPreorder(right);
        return root;
    }
    private String solution(String str) {
        if (str == null || str.equals("")) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == '-' && str.charAt(i + 1) != '-') {
                continue;
            }
            sb.append(str.charAt(i));
        }
        sb.append(str.charAt(str.length() - 1));
        return sb.toString();
    }
}


//键值映射
class MapSum {
    Map<String,Integer> map;
    /** Initialize your data structure here. */
    public MapSum() {
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        map.put(key,val);
    }

    public int sum(String prefix) {
        int sum = 0;
        for (String key : map.keySet()) {
            if (key.startsWith(prefix)) {
                sum += map.get(key);
            }
        }
        return sum;
    }
}
