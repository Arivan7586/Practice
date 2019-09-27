package com.test9_27;

import java.util.ArrayList;
import java.util.List;

public class Practice9_27 {

    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(0);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(1);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;

        TreeNode l1 = new TreeNode(1);
        TreeNode l2 = new TreeNode(0);
        l1.left = l2;

        Solution solution = new Solution();
        System.out.println(solution.sumNumbers(t1));
        System.out.println(solution.sumNumbers(l1));
    }

}

//求根到叶子结点数字之和
//给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
//
//        例如，从根到叶子节点路径 1->2->3 代表数字 123。
//
//        计算从根到叶子节点生成的所有数字之和。
//
//        说明: 叶子节点是指没有子节点的节点。
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
class Solution {
    private List<String> list = new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        getNum(root,"");
        for (int i = 0; i < list.size(); i++) {
            sum += Integer.valueOf(list.get(i));
        }
        return sum;
    }
    private void getNum(TreeNode node, String value) {
        if (node.left == null && node.right == null) {
            list.add(value + node.val);
            return;
        }
        value += node.val;
        if (node.left != null) {
            getNum(node.left,value);
        }
        if (node.right != null) {
            getNum(node.right,value);
        }
    }
}
