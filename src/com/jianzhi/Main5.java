//中序遍历的下一个节点
package com.jianzhi;
public class Main5 {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;
        TreeLinkNode(int val) {
            this.val = val;
        }
    }
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        TreeLinkNode p = pNode;
        if (p.right != null) {
            p = p.right;
            while (p.left != null) {
                p = p.left;
            }
            return p;
        }
        if (p.next!=null && p==p.next.left) {
            return p.next;
        }
        if (p.next != null) {
            p = p.next;
            while (p.next!=null && p==p.next.right) {
                p = p.next;
            }
            return p.next;
        }
        return null;
    }
    public static void main(String[] args) {
    }
}
