//删除链表的节点
package com.jianzhi;
public class Main18 {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        public void creatNode(ListNode head, int val){
            ListNode p = new ListNode(val);
            while (head.next != null){
                head = head.next;
            }
            head.next = p;
        }
    }
    public ListNode deleteNode(ListNode head, int val) {
        ListNode before = head;
        ListNode cur = head.next;
        if (before==null || cur==null) {
            return null;
        }
        if (before.val == val)
            return cur;
        while (cur.val != val && cur!=null) {
            cur = cur.next;
            before = before.next;
        }
        if (cur==null) {
            System.out.println("No such val's node!");
            return head;
        }
        before.next = cur.next;
        return head;
    }
    public static void main(String[] args) {

    }
}
