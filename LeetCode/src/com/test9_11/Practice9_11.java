package com.test9_11;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Practice9_11 {

    public static void main(String[] args) {


    }
}


// 二叉树的最近公共父节点
// （1.若左子树不空，左子树值都小于父节点；
// 2.如右子树不空，右子树值都大于父节点；
// 3.左、右子树都是二元查找树；
// 4. 没有键值相等的节点）上任意两个节点的值，请找出它们最近的公共祖先。
// 输入三行行，第一行为树层级，第二行为数节点（其中-1表示为空节点），第三行为需要查找祖先的两个数。
class Solution {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[(int) (Math.pow(2,n) - 1)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        int a = in.nextInt();
        int b = in.nextInt();
        int indexA = -1;
        int indexB = -1;
        //寻找两数的位置
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == a) {
                indexA = i;
            }
            if (arr[i] == b) {
                indexB = i;
            }
            if (indexA != -1 && indexB != -1) {
                break;
            }
        }
        //右子树的父节点下标为（n - 2） / 2
        //左子树的父节点下标为（n - 1） / 2
        while (indexA >= 0 && indexB >= 0) {
            //如果下标相等，则当前节点为父节点
            if (indexA == indexB) {
                break;
            } else if (indexA > indexB) {
                //如果当前下标为奇数，则为左子树，否则为右子树
                if (indexA % 2 == 1) {
                    indexA = (indexA - 1) / 2;
                } else {
                    indexA = (indexA - 2) / 2;
                }
            } else {
                if (indexB % 2 == 1) {
                    indexB = (indexB - 1) / 2;
                } else {
                    indexB = (indexB - 2) / 2;
                }
            }
        }
        if (indexA < 0 || indexB < 0) {
            System.out.println(-1);
        } else {
            System.out.println(arr[indexA]);
        }
    }
}


//小度的部队
class Solution1 {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int k = in.nextInt();
            System.out.println(count(n,k));
        }
        in.close();
    }

    private static int count(int n, int k) {
        if (k > n) {
            return 0;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        int count = 0;
        while (!queue.isEmpty()) {
            int value = queue.poll();
            if ((value - k) % 2 == 0 && value > k) {
                queue.add((value - k) / 2);
                queue.add((value - k) / 2 + k);
            } else {
                count++;
            }
        }
        return count;
    }
}