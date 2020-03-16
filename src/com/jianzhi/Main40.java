//最小的k个数
package com.jianzhi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main40 {
    public int[] getLeastNumbers_1(int[] arr, int k) {
        if (arr.length==0 || arr==null || k<=0 || k>arr.length)
            return new int[0];
        int start = 0;
        int end = arr.length - 1;
        int index = partition(arr, start, end);
        while (index != k-1) {
            if (index > k-1) {
                end = index - 1;
                index = partition(arr, start, end);
            }
            else {
                start = index + 1;
                index = partition(arr, start, end);
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }
    public int partition(int[] arr, int start, int end) {
        int index = (int)(Math.random() * (end-start+1) + start);
        swap(arr, index, end);
        int low = start - 1;
        for (int i = start; i < end; i++) {
            if (arr[i] <= arr[end]) {
                low++;
                if (low != i) {
                    swap(arr, i, low);
                }
            }
        }
        index = low + 1;
        swap(arr, index, end);
        return index;
    }
    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        if(k == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> (b - a)); //大根堆
        for(int i: arr) {
            if(queue.size() < k) {
                queue.offer(i);
            } else {
                if(queue.peek() > i) {
                    queue.poll();
                    queue.offer(i);
                }
            }
        }
        int[] ref = new int[k];
        int cnt = 0;
        while(queue.size() > 0) {
            ref[cnt++] = queue.poll();
        }
        return ref;
    }

    public static void main(String[] args) {
        Main40 m = new Main40();
        int[] arr = {0,1,2,1};
        int[] res = m.getLeastNumbers(arr,1);
        System.out.println(Arrays.toString(res));
    }
}
