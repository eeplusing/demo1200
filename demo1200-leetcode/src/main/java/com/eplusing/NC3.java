package com.eplusing;

public class NC3 {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return null;
        }

        ListNode slowNode = head.next;
        ListNode fastNode = head.next.next;

        while(slowNode != fastNode){
            if(slowNode == null || fastNode == null){
                return null;
            }
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }

        ListNode tempNode = head;
        while(fastNode != tempNode){
            fastNode = fastNode.next;
            tempNode = tempNode.next;
        }

        return tempNode;



    }




    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

}

