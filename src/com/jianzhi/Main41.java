//数据流中的中位数
package com.jianzhi;
import java.util.PriorityQueue;

public class Main41 {
    PriorityQueue<Integer> minHeap;
    PriorityQueue< Integer > maxHeap;
    int count = 0;
    public Main41() {
        minHeap = new PriorityQueue<>();    // 小根堆
        maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1); //大根堆
    }
    public void addNum(int num) {
        if ((count & 1) == 0) { // 偶数个数
            maxHeap.offer(num); // 先入大根堆
            minHeap.offer(maxHeap.poll()); // 获取大根堆中最大值后将大根堆中的最大值放入小根堆
        } else {
            // 奇数时，先入小根堆
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll()); // 获取小根堆中的最小值后将这个最小值放入大根堆
        }
        count++;
    }
    public double findMedian() {
        if ((count & 1) == 0)
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        else
            return minHeap.peek() / 1.0;
    }
    public static void main(String[] args) {
        Main41 m = new Main41();
        m.addNum(5);
        m.addNum(4);
        m.addNum(3);
        m.addNum(2);
        m.addNum(1);
        System.out.println(m.findMedian());
    }
}
