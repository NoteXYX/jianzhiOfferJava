//合并两个排好序的链表
package com.jianzhi;
public class Main24 {
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){    //递归
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode head = null;
        if (l1.val < l2.val) {
            head = l1;
            head.next = mergeTwoLists(l1.next, l2);
        }
        else {
            head = l2;
            head.next = mergeTwoLists(l1, l2.next);
        }
        return head;
    }
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {  //非递归
        ListNode p1 = l1;
        ListNode p2 = l2;
        if (p1==null && p2!=null)
            return p2;
        if (p1!=null && p2==null)
            return p1;
        if (p1==null && p2==null)
            return null;
        ListNode head;
        if (p1.val <= p2.val) {
            head = new ListNode(p1.val);
            p1 = p1.next;
        }
        else {
            head = new ListNode(p2.val);
            p2 = p2.next;
        }
        ListNode cur = head;
        while (p1!=null || p2!=null) {
            if (p1!=null && p2!=null && p1.val<= p2.val) {
                cur.next = new ListNode(p1.val);
                cur = cur.next;
                p1 = p1.next;
            }
            else if (p1!=null && p2!=null && p2.val< p1.val) {
                cur.next = new ListNode(p2.val);
                cur = cur.next;
                p2 = p2.next;
            }
            else if (p1!=null && p2==null) {
                cur.next = p1;
                break;
            }
            else if (p1==null && p2!=null) {
                cur.next = p2;
                break;
            }
        }
        return head;
    }
    public static void main(String[] args) {
        Main24 m = new Main24();
        ListNode head1 = new ListNode(1);
        head1.create(head1, 2);
        head1.create(head1, 3);
        head1.create(head1, 4);
        ListNode head2 = new ListNode(2);
        head2.create(head2, 3);
        head2.create(head2, 4);
        head2.create(head2, 5);
        ListNode head = m.mergeTwoLists(head1, head2);
        System.out.println();
    }
}
