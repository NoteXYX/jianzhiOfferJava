package com.jianzhi;
public class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
    public void creatNode(ListNode head, int val){
        ListNode p = new ListNode(val);
        while (head.next != null){
            head = head.next;
        }
        head.next = p;
    }
}