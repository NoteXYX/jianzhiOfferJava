//最小的k个数
package com.jianzhi;

import java.util.Arrays;

public class Main40 {
    public int[] getLeastNumbers(int[] arr, int k) {
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

    public static void main(String[] args) {
        Main40 m = new Main40();
        int[] arr = {0,0,0,2,0,5};
        System.out.println(Arrays.toString(m.getLeastNumbers(arr, 2)));
    }
}
