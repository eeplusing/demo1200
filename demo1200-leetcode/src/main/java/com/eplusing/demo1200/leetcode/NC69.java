package com.eplusing.demo1200.leetcode;

public class NC69 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param pHead ListNode类
     * @param k     int整型
     * @return ListNode类
     */
    public ListNode FindKthToTail(ListNode pHead, int k) {
        // write code here
        if (pHead == null || k < 1) {
            return null;
        }

        int num = 0;
        ListNode tempNode = pHead;
        while (true) {
            if (tempNode != null) {
                num++;
                tempNode = tempNode.next;
            } else {
                break;
            }
        }

        if (num < k) {
            return null;
        }

        int targetIndex = num - k;
        int index = 0;
        tempNode = pHead;

        while (true) {
            if (index == targetIndex) {
                return tempNode;
            } else {
                tempNode = tempNode.next;
                index++;
            }
        }
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
