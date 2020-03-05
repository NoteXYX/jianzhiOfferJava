//从尾到头打印链表
package com.jianzhi;
import java.util.ArrayList;
import java.util.Stack;
public class Main3 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) { //用栈实现，非递归
        ArrayList arrayList = new ArrayList();
        if (listNode == null){
            return arrayList;
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
            arrayList.add(s.pop());
        }
        return arrayList;
    }
    public ArrayList<Integer> recurPrint(ListNode listNode){
        ArrayList arrayList = new ArrayList();
        recurCore(arrayList, listNode);
        return arrayList;
    }
    public void recurCore(ArrayList arrayList, ListNode listNode){
        if (listNode!=null){
            recurCore(arrayList, listNode.next);
            arrayList.add(listNode.val);
        }
    }
    public static void main(String[] args) {
        Main3 m = new Main3();
        ListNode node = new ListNode(1);
        node.creatNode(node, 2);
        node.creatNode(node, 3);
        node.creatNode(node, 4);
        System.out.println(m.recurPrint(node).toString());
    }
}
