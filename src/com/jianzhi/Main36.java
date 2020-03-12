//二叉搜索树与双向链表
package com.jianzhi;
public class Main36 {
    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node() {}
        public Node(int _val) {
            val = _val;
        }
        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
    public Node treeToDoublyList(Node root) {
        if (root == null)
            return null;
        Node lastListPoint = null;
        lastListPoint = doublyListCore(root, lastListPoint);
        Node head = lastListPoint;
        while (head!=null && head.left!=null)
            head = head.left;
        lastListPoint.right = head;
        head.left = lastListPoint;
        return head;
    }
    public Node doublyListCore(Node root, Node lastListPoint) {
        if (root == null)
            return null;
        if (root.left != null)
            lastListPoint = doublyListCore(root.left, lastListPoint);
        root.left = lastListPoint;
        if (lastListPoint != null)
            lastListPoint.right = root;
        lastListPoint = root;
        if (root.right != null)
            lastListPoint = doublyListCore(root.right, lastListPoint);
        return lastListPoint;
    }

    public static void main(String[] args) {
        Main36 m = new Main36();
        Node root11 = new Node(4);
        Node root21 = new Node(2);
        Node root22 = new Node(5);
        Node root31 = new Node(1);
        Node root32 = new Node(3);
//        Node root33 = new Node(4);
//        Node root41 = new Node(7);
//        Node root42 = new Node(2);
//        Node root43 = new Node(5);
//        Node root44 = new Node(1);
        root11.left = root21;
        root11.right = root22;
        root21.left = root31;
        root21.right = root32;
//        root22.left = root32;
////        root22.right = root33;
////        root31.left = root41;
////        root31.right = root42;
////        root33.left = root43;
////        root33.right = root44;
        m.treeToDoublyList(root11);
        System.out.println();
    }
}
