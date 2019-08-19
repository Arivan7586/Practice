package com.test8_19;

import java.util.ArrayList;
import java.util.Arrays;

public class Practice8_19 {

    public static void main(String[] args) {

        int[] arr = {3,2,1,6,0,5};
        Solution solution = new Solution();
        Solution.TreeNode node = solution.constructMaximumBinaryTree(arr);
        printTree(node);
    }
    private static void printTree(Solution.TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        printTree(root.left);
        printTree(root.right);
    }
}


//最大二叉树
class Solution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int n = nums.length;
        if (n == 1) {
            return new TreeNode(nums[0]);
        } else if (n == 2) {
            int maxIndex = findMaxIndex(nums);
            TreeNode root = new TreeNode(nums[maxIndex]);
            if (maxIndex == 0) {
                root.right = new TreeNode(nums[1]);
            } else {
                root.left = new TreeNode(nums[0]);
            }
            return root;
        } else if (n == 3) {
            int maxIndex = findMaxIndex(nums);
            TreeNode root = new TreeNode(nums[maxIndex]);
            if (maxIndex == 1) {
                root.left = new TreeNode(nums[0]);
                root.right = new TreeNode(nums[2]);
            } else if (maxIndex == 0) {
                root.right = constructMaximumBinaryTree(new int[]{nums[1],nums[2]});
            } else {
                root.left = constructMaximumBinaryTree(new int[]{nums[0],nums[1]});
            }
            return root;
        } else {
            int index = findMaxIndex(nums);
            int[] arr1 = new int[index];
            int[] arr2 = new int[n - index - 1];
            TreeNode root = new TreeNode(nums[index]);
            System.arraycopy(nums,0,arr1,0,index);
            System.arraycopy(nums,index+1,arr2,0,n-index-1);

            root.left = constructMaximumBinaryTree(arr1);
            root.right = constructMaximumBinaryTree(arr2);
            return root;
        }
    }
    private int findMaxIndex(int[] arr) {
        int n = arr.length;
        int[] temp = Arrays.copyOf(arr,n);
        Arrays.sort(temp);
        int maxValue = temp[n-1];
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == maxValue) {
                index = i;
                break;
            }
        }
        return index;
    }
}

//从二叉搜索树到更大的树
class Solution1 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public TreeNode bstToGst(TreeNode root) {
        if (root == null) {
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        add(list,root);
        change(root,list);
        return root;
    }
    private void change(TreeNode node, ArrayList<Integer> list) {
        if (node == null) {
            return;
        }
        node.val = sum(list,node.val);
        change(node.left,list);
        change(node.right,list);
    }
    private void add(ArrayList<Integer> list, TreeNode node) {
        if (node == null) {
            return;
        }
        add(list,node.left);
        list.add(node.val);
        add(list,node.right);
    }
    private int sum(ArrayList<Integer> list, int value) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) >= value) {
                sum += list.get(i);
            }
        }
        return sum;
    }
}