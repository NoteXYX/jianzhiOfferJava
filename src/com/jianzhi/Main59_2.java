//队列的最大值
package com.jianzhi;

import java.util.LinkedList;

public class Main59_2 {
}
class MaxQueue {
    LinkedList<Integer> maxList;
    LinkedList<Integer> list;
    public MaxQueue() {
        maxList = new LinkedList<>();
        list = new LinkedList<>();
    }

    public int max_value() {
        return maxList.size()>0 ? maxList.peek() : -1;
    }

    public void push_back(int value) {
        list.offer(value);
        if (maxList.isEmpty())
            maxList.offer(value);
        else {
            while (maxList.size() > 0 && maxList.peekLast() < value) {
                maxList.pollLast();
            }
            maxList.offer(value);
        }
    }

    public int pop_front() {
        int tmp = list.size()>0 ? list.poll() : -1;
        if (maxList.size() > 0 && maxList.peek() == tmp)
            maxList.poll();
        return tmp;
    }
}
