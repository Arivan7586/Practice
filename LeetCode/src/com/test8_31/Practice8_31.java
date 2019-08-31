package com.test8_31;

import java.util.*;

public class Practice8_31 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] arr = {364,637,341,406,747,995,234,971,571,219,993,407,416,366,
                315,301,601,650,418,355,460,505,360,965,516,648,727,667,
                465,849,455,181,486,149,588,233,144,174,557,67,746,550,
                474,162,268,142,463,221,882,576,604,739,288,569,256,936,
                275,401,497,82,935,983,583,523,697,478,147,795,380,973,
                958,115,773,870,259,655,446,863,735,784,3,671,433,630,
                425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575};
        System.out.println(solution.InversePairs(arr));

        Solution1 solution1 = new Solution1();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(0);
        TreeNode t3 = new TreeNode(1);
        TreeNode t4 = new TreeNode(0);
        TreeNode t5 = new TreeNode(1);
        TreeNode t6 = new TreeNode(0);
        TreeNode t7 = new TreeNode(1);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        System.out.println(solution1.sumRootToLeaf(t1));

//        System.out.println(solution1.change("110"));
    }
}

//数组中的逆序对
class Solution {
    public int InversePairs(int [] array) {
        if (array == null || array.length <= 1) {
            return 0;
        }
        int num = inverseNumber(array,0,array.length - 1);
        return num;
    }
    private int inverseNumber(int[] arr, int l, int r) {
        if (l >= r) {
            return 0;
        }
        int mid = l + (r - l) / 2;
        inverseNumber(arr,l,mid);
        inverseNumber(arr,mid + 1, r);
        return partation(arr,l,mid,r);
    }
    private int partation(int[] arr, int l, int mid, int r) {
        int count = 0;
        int i = mid;
        int j = r;
        int[] array = new int[r - l + 1];
        int k = array.length - 1;
        while (i >= 0 && j > mid) {
            if (arr[i] > arr[j]) {
                count += (j - mid);
                array[k--] = arr[i--];
            } else {
                arr[k--] = array[j--];
            }
        }
        int start = i;
        int end = -1;
        if (j > mid) {
            start = j;
            end = mid;
        }
        while (start > end) {
            array[k--] = arr[start--];
        }
        for (int m = 0; m < array.length; m++) {
            arr[l + m] = array[m];
        }
        if (count >= 1000000007) {
            return count % 1000000007;
        }
        return count;
    }
}

//从根到叶的二进制数之和
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
class Solution1 {
    private int sum;
    public int sumRootToLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        add(root,sb);
        return sum;
    }
    private void add(TreeNode node,StringBuilder sb) {
        sb.append(node.val);
        if (node.left == null && node.right == null) {
            sum += change(sb.toString());
            return;
        }
        if (node.left != null) {
            StringBuilder value = new StringBuilder(sb);
            add(node.left,value);
        }
        if (node.right != null) {
            StringBuilder value = new StringBuilder(sb);
            add(node.right,value);
        }
    }
    public int change(String str) {
        int sum = 0;
        int n = str.length();
        for (int i = 0; i < n; i++) {
            int value = str.charAt(n - i - 1) - '0';
            sum += value * Math.pow(2,i);
        }
        return sum;
    }
}