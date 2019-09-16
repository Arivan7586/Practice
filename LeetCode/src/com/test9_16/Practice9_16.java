package com.test9_16;

import java.util.*;

public class Practice9_16 {

    public static void main(String[] args) {


    }
}


//试炼
class Solution {
    public static void solution(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            System.out.println(getMaxSum(arr));
        }
        in.close();
    }

    private static int getMaxSum(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        int maxSum = 0;
        Arrays.sort(arr);
        boolean flag = true;
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            if (arr[l] >= arr[r]) {
                if (flag) {
                    maxSum += arr[l];
                    flag = false;
                } else {
                    flag = true;
                }
                l++;
            } else {
                if (flag) {
                    maxSum = arr[r];
                    flag = false;
                } else {
                    flag = true;
                }
                r--;
            }
        }
        return maxSum;
    }
}

//二叉树的中序遍历（非递归）
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
class Solution1 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            if (node == null) {
                node = stack.pop();
                list.add(node.val);
                node = node.right;
            } else {
                stack.push(node);
                node = node.left;
            }
        }
        return list;
    }
}