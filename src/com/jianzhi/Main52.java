//两个链表的第一个公共节点
package com.jianzhi;

public class Main52 {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
        void creat(ListNode head, int val) {
            ListNode cur = head;
            while (cur.next != null)
                cur = cur.next;
            cur.next = new ListNode(val);
        }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA==null || headB==null)
            return null;
        int numOfA = 1;
        int numOfB = 1;
        ListNode hA = headA;
        ListNode hB = headB;
        while (hA.next != null) {
            hA = hA.next;
            numOfA++;
        }
        while (hB.next != null) {
            hB = hB.next;
            numOfB++;
        }
        ListNode hLong = headA;
        ListNode hShort = headB;
        int step = numOfA - numOfB;
        if (numOfA < numOfB){
            hLong = headB;
            hShort = headA;
            step = numOfB - numOfA;
        }
        for (int i = 0; i < step; i++) {
            hLong = hLong.next;
        }
        while (hLong != hShort) {
            hLong = hLong.next;
            hShort = hShort.next;
            if (hLong==null || hShort==null)
                return null;
        }
        return hLong;
    }

    public static void main(String[] args) {
        Main52 m = new Main52();
        ListNode headA = new ListNode(4);
        headA.creat(headA, 1);
        headA.creat(headA, 8);
        headA.creat(headA, 4);
        headA.creat(headA, 5);
        ListNode headB = new ListNode(5);
        headB.creat(headB, 0);
        headB.creat(headB, 1);
        headB.next.next.next = headA.next.next;
        System.out.println(m.getIntersectionNode(headA, headB).val);
    }
}
