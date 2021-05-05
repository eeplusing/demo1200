package com.eplusing;

public class NC4 {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return false;
        }

        ListNode slowNode = head;
        ListNode fastNode = head;

        while(true){
            fastNode = fastNode.next;
            if(fastNode == null){
                return false;
            }
            fastNode = fastNode.next;
            if(fastNode == null){
                return false;
            }

            slowNode = slowNode.next;
            if(fastNode.equals(slowNode)){
                return true;
            }
        }


        //return true;
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
        ConverseListNode.ListNode head = new ConverseListNode.ListNode(arr[0]);
        ConverseListNode.ListNode curNode = head;

        for(int i = 1 ; i < arr.length; i++){
            ConverseListNode.ListNode node = new ConverseListNode.ListNode(arr[i]);
            curNode.next = node;
            curNode = node;

        }

        new ConverseListNode().ReverseList(head);

        System.out.println(head);


    }
}
