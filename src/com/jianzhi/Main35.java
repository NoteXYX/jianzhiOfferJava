//复杂链表的复制
package com.jianzhi;
public class Main35 {
    private static class Node {
        int val;
        Node next;
        Node random;
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        cloneNodes(head);
        cloneRandomNodes(head);
        return cutCopyList(head);
    }
    public void cloneNodes(Node head) {
        Node nextNode = head.next;
        Node curNode = head;
        while (curNode != null) {
            Node copyNode = new Node(curNode.val);
            curNode.next = copyNode;
            copyNode.next = nextNode;
            curNode = nextNode;
            if (curNode != null)
                nextNode = curNode.next;
        }
    }
    public void cloneRandomNodes(Node head) {
        Node curNode = head;
        Node copyNode = head.next;
        while (curNode != null) {
            if (curNode.random != null)
                copyNode.random = curNode.random.next;
            curNode = copyNode.next;
            if (curNode != null)
                copyNode = curNode.next;
        }
    }
    public Node cutCopyList(Node head) {
        Node oldNode = head;
        Node newHead = head.next;
        Node curNewNode = newHead;
        Node nextNode = newHead.next;
        while (oldNode != null) {
            oldNode.next = nextNode;
            if (nextNode != null)
                curNewNode.next = nextNode.next;
            else
                curNewNode.next = null;
            oldNode = nextNode;
            curNewNode = curNewNode.next;
            if (nextNode!=null && curNewNode!=null)
                nextNode = curNewNode.next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        Main35 m = new Main35();
        Node head0 = new Node(7);
        Node head1 = new Node(13);
        Node head2 = new Node(11);
        Node head3 = new Node(10);
        Node head4 = new Node(1);
        head0.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head1.random = head0;
        head2.random = head4;
        head3.random = head2;
        head4.random = head0;
        Node node = m.copyRandomList(head0);
        System.out.println();

    }
}
