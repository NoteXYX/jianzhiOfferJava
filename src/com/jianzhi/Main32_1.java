//从上到下打印二叉树
package com.jianzhi;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main32_1 {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int[] levelOrder(TreeNode root) {
        if (root == null)
            return new int[0];
        LinkedList<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode curRoot = queue.poll();
            arrayList.add(curRoot.val);
            if (curRoot.left != null)
                queue.add(curRoot.left);
            if (curRoot.right != null)
                queue.add(curRoot.right);
        }
        int[] bfs = arrayList.stream().mapToInt(Integer::intValue).toArray();
        return bfs;
    }
}
