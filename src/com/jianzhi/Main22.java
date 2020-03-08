//链表的倒数第k个节点
package com.jianzhi;
public class Main22 {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        private void create(ListNode head, int val) {
            ListNode cur = new ListNode(val);
            ListNode p = head;
            while (p.next != null)
                p = p.next;
            p.next = cur;
        }
    }
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head==null && k<=0)
            return null;
        ListNode p = head;
        int i = 1;
        while (p.next!=null && i<k) {
            i++;
            p = p.next;
        }
        if (i == k) {
            ListNode res = head;
            while (p.next!=null) {
                p = p.next;
                res = res.next;
            }
            return res;
        }
        else
            return head;
    }
    public static void main(String[] args) {
        Main22 m = new Main22();
        ListNode head = new ListNode(1);
        head.create(head, 2);
        head.create(head, 3);
        head.create(head, 4);
        System.out.println(m.getKthFromEnd(head, 1).val);
    }
}
