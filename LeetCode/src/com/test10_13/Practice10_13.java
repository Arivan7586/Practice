package com.test10_13;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Practice10_13 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println();

        Solution1 solution1 = new Solution1();
        System.out.println(solution1.longestPalindrome("abccccdd"));

    }
}


//二叉树的坡度

//给定一个二叉树，计算整个树的坡度。
//
//        一个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点之和的
//        差的绝对值。空结点的的坡度是0。
//
//        整个树的坡度就是其所有节点的坡度之和。

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
class Solution {
    private int sum = 0;
    public int findTilt(TreeNode root) {
        run(root);
        return sum;
    }
    private int run(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = run(node.left);
        int right = run(node.right);
        sum += Math.abs(left - right);
        return left + right + node.val;
    }
}


//最长回文串

//给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
//
//        在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
//
//        注意:
//        假设字符串的长度不会超过 1010。

class Solution1 {
    public int longestPalindrome(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        Map<Character,Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            if (map.containsKey(key)) {
                map.put(key,map.get(key) + 1);
            } else {
                map.put(key,1);
            }
        }
        int sum = 0;
        boolean flag = true;
        for (Character key : map.keySet()) {
            int value = map.get(key);
            if (value % 2 == 0) {
                sum += value;
            } else {
                if (flag) {
                    sum += value;
                    flag = false;
                } else {
                    sum += value - 1;
                }
            }
        }
        return sum;
    }
}