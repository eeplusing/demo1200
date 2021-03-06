package com.eplusing.demo1200.leetcode.leetcode;

public class ConverseListNode {
    public ListNode ReverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode preNode = null;
        ListNode curNode = head;

        while(curNode != null){
            ListNode curNext = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = curNext;
        }

        return preNode;

    }

    public ListNode ReverseList1(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode preNode = null;
        ListNode curNode = head;

        while(curNode != null){
           ListNode nextNode = curNode.next;
           curNode.next = preNode;
           preNode = curNode;
           curNode = nextNode;

        }

        return preNode;


    }



    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        ListNode head = new ListNode(arr[0]);
        ListNode curNode = head;

        for(int i = 1 ; i < arr.length; i++){
            ListNode node = new ListNode(arr[i]);
            curNode.next = node;
            curNode = node;

        }

        ListNode newHead =  new ConverseListNode().ReverseList1(head);
        while(newHead != null){
            System.out.println(newHead.val + ",");
            newHead = newHead.next;
        }



    }
}
