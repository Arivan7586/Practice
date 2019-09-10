package com.test9_10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Practice9_10 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.letterCasePermutation("a1b2"));

    }
}

//字母大小写全排列
class Solution {
    private List<String> list = new ArrayList<>();
    public List<String> letterCasePermutation(String S) {
        if (S == null || S.equals("")) {
            return list;
        }
        S = S.toLowerCase();
        add(S,"",0);
        return list;
    }
    private void add(String src, String target, int index) {
        if (index >= src.length()) {
            if (!target.equals("")) {
                list.add(target);
            }
            return;
        }
        char c = src.charAt(index);
        if (c >= '0' && c <= '9') {
            target += c;
            add(src,target,index + 1);
        } else {
            add(src,target + c, index + 1);
            add(src,target + String.valueOf(c).toUpperCase(),index+1);
        }
    }
}


//完全二叉树的节点个数
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
class Solution1 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = 0;
        while(!queue.isEmpty()) {
            int n = queue.size();
            sum += n;
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return sum;
    }
}