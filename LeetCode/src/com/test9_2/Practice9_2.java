package com.test9_2;


public class Practice9_2 {

    public static void main(String[] args) {

//        Solution solution = new Solution();
//        System.out.println(solution.repeatedSubstringPattern("aba"));
//        System.out.println(solution.repeatedSubstringPattern("abab"));
//        System.out.println(solution.repeatedSubstringPattern("ababab"));
//        System.out.println(solution.repeatedSubstringPattern("abac"));
//        System.out.println(solution.repeatedSubstringPattern("babbabbabbabbab"));
//
//        System.out.println("abacabac".indexOf("abac",1));

        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        Solution1 solution1 = new Solution1();
        printList(solution1.insertionSortList(l1));
    }
    private static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
}

//重复的子字符串
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.equals("") || s.length() <= 1) {
            return false;
        }
        return (s + s).indexOf(s, 1) != s.length();
    }
}


//对链表进行插入排序(LeetCode)
class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
class Solution1 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode currentNode = head;
        ListNode nextNode = null;
        while (currentNode != null) {
            nextNode = currentNode.next;
            if (nextNode != null && nextNode.val < currentNode.val) {
                while (pre.next != null && pre.next.val < nextNode.val) {
                    pre = pre.next;
                }
                ListNode temp = pre.next;
                currentNode.next = nextNode.next;
                pre.next = nextNode;
                nextNode.next = temp;
                pre = dummyHead;
            } else {
                currentNode = currentNode.next;
            }
        }
        return dummyHead.next;
    }
}