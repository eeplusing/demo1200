package com.eplusing.demo1200;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test {
    public class ListNode {
        int val;
        ListNode next = null;
    }

    public class Solution {
        /**
         * reverse the given linked list
         *
         * @param head ListNode类 the head of the linked list
         * @param n    int整型 the N
         * @return ListNode类
         */
        public ListNode reverseLinkedList(ListNode head, int n) {
            if (head == null) return null;
            ListNode a = head;
            ListNode b = head;
            for (int i = 0; i < n; i++) {
                if (b == null) break;
                b = b.next;
            }
            ListNode newHead = newReverse(a, b);
            a.next = reverseLinkedList(b, n);
            return newHead;
        }

        //可以参考LeetCOde反转链表,多一个条件:当前节点不为尾节点b
        public ListNode newReverse(ListNode a, ListNode b) {
            ListNode pre = null;
            ListNode cur = a;
            while (cur != null && cur != b) {
                ListNode tmp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = tmp;
            }
            return pre;
        }
    }
}