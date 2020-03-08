//链表中环的入口节点
package com.jianzhi;
public class Main25 {
    private static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode MeetingNode(ListNode pHead) {
        if (pHead == null)
            return null;
        ListNode fast = pHead;
        ListNode slow = pHead;
        while (fast != null) {
            slow = slow.next;
            if (fast.next == null)
                return null; //无环
            fast = fast.next.next;
            if (fast.val == slow.val)
                return fast;
        }
        return null;//无环
    }
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode meetNode = MeetingNode(pHead);
        if (meetNode == null)
            return null;    //无环
        int lenOfLoop = 1;
        int loopInVal = meetNode.val;
        meetNode = meetNode.next;
        while (meetNode.val != loopInVal) {
            lenOfLoop++;
            meetNode = meetNode.next;
        }
        if (lenOfLoop == 1)
            return meetNode;
        ListNode fast = pHead;
        ListNode slow = pHead;
        for (int i = 0; i < lenOfLoop; i++) {
            fast = fast.next;
        }
        while (fast.val != slow.val) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}