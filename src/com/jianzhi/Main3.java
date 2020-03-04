package com.jianzhi;

import java.util.ArrayList;
import java.util.Stack;

public class Main3 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList arrayList = new ArrayList();
        if (listNode == null){
            return arrayList;
        }
        Stack s = new Stack();
        ListNode node = listNode;
        s.push(node.val);
        while (node.next != null){
            node = node.next;
            s.push(node.val);
        }
        while (!s.empty()){
            arrayList.add(s.pop());
        }
        return arrayList;
    }
    public static void main(String[] args) {
        Main3 m = new Main3();
//        ListNode node = new ListNode(1);
//        node.creatNode(node, 2);
//        node.creatNode(node, 3);
//        node.creatNode(node, 4);
        System.out.println(m.printListFromTailToHead(null).toString());
    }

}
