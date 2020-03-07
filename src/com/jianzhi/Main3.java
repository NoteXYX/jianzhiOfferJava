//从尾到头打印链表
package com.jianzhi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
public class Main3 {
    public int[] printListFromTailToHead(ListNode listNode) { //用栈实现，非递归
        ArrayList<Integer> arrayList = new ArrayList();
        if (listNode == null){
            int[] arr = arrayList.stream().mapToInt(Integer::intValue).toArray();
            return arr;
        }
        Stack s = new Stack();
        ListNode node = listNode;
        s.push(node.val);
        //arrayList.add(0, node.val);   //也可以用ArrayList的头插add(0, val)方法
        while (node.next != null){
            node = node.next;
            s.push(node.val);
        }
        while (!s.empty()){
            arrayList.add((Integer) s.pop());
        }
        int[] arr = arrayList.stream().mapToInt(Integer::intValue).toArray();
        return arr;
    }
    ArrayList<Integer> list = new ArrayList();
    public ArrayList<Integer> recurPrintListFromTailToHead(ListNode listNode) { //递归实现
        if(listNode!=null){
            recurPrintListFromTailToHead(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }
    public static void main(String[] args) {
        Main3 m = new Main3();
        ListNode node = new ListNode(1);
        node.creatNode(node, 2);
        node.creatNode(node, 3);
        node.creatNode(node, 4);
        System.out.println(Arrays.toString(m.printListFromTailToHead(node)));
    }
}
