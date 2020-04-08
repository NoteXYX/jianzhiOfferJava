//反转链表
package com.jianzhi;

public class Main23 {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        ListNode(){ }
        private void create(ListNode head, int val) {
            ListNode cur = new ListNode(val);
            ListNode p = head;
            while (p.next != null)
                p = p.next;
            p.next = cur;
        }
    }
    public ListNode rereverseList0(ListNode head) { //非递归版NEW
        if (head==null || head.next==null)
            return head;
        ListNode tmp = new ListNode(-1);
        ListNode next;
        while (head != null) {
            next = head.next;
            head.next = tmp.next;
            tmp.next = head;
            head = next;
        }
        return tmp.next;
    }
    public ListNode reverseList(ListNode head) {    //非递归版old
        if (head==null || head.next==null)
            return head;
        ListNode preNode = head;
        ListNode curNode = head.next;
        ListNode nextNode = curNode.next;
        curNode.next = preNode;
        preNode.next = null;
        while (nextNode!=null) {
            preNode = curNode;
            curNode = nextNode;
            nextNode = curNode.next;
            curNode.next = preNode;
        }
        return curNode;
    }
    public ListNode curReverseList(ListNode head) { //递归版
        if(head==null || head.next==null) {
            return head;
        }
        ListNode cur = curReverseList(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }
    public static void main(String[] args) {
        Main23 m = new Main23();
        ListNode head = new ListNode(1);
        head.create(head, 2);
        head.create(head, 3);
        head.create(head, 4);
//        m.reverseList(head);
        head = m.rereverseList0(head);
    }
}