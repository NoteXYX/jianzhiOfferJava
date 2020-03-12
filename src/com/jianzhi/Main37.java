//序列化二叉树
package com.jianzhi;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main37 {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
  }
    public String serialize(TreeNode root) {
        ArrayList<String> res = new ArrayList<>();
        if (root == null)
            return res.toString();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode node = null;
        while (!queue.isEmpty()) {
            node = queue.poll();
            if (node != null) {
                res.add(Integer.toString(node.val));
                queue.offer(node.left);
                queue.offer(node.right);
            }
            else
                res.add("null");
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || "[]".equals(data))
            return null;
        String res = data.substring(1,data.length()-1);
        String[] values = res.split(",");
        int index = 0;
        TreeNode head = generateTreeNode(values[index++]);
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node = head;
        queue.offer(head);
        while(!queue.isEmpty()){
            node = queue.poll();
            node.left = generateTreeNode(values[index++]);
            node.right = generateTreeNode(values[index++]);
            if(node.left!=null){
                queue.offer(node.left);
            }
            if(node.right!=null){
                queue.offer(node.right);
            }
        }
        return head;
    }
    public TreeNode generateTreeNode(String value){
        if("null".equals(value))
            return null;
        return new TreeNode(Integer.valueOf(value));
    }

    public static void main(String[] args) {
        Main37 m = new Main37();
        TreeNode root11 = new TreeNode(1);
        TreeNode root21 = new TreeNode(2);
        TreeNode root22 = new TreeNode(3);
        TreeNode root31 = new TreeNode(4);
        TreeNode root32 = new TreeNode(5);
        root11.left = root21;
        root11.right = root22;
        root22.left = root31;
        root22.right = root32;
        System.out.println(m.serialize(root11));
        TreeNode root = m.deserialize("[1,2]");
        System.out.println();
    }
}
