package com.jianzhi;
import java.util.*;

public class Sort {
    //快速排序
    public void swap(int[] array, int i, int j) {
        int tmp = array[j];
        array[j] = array[i];
        array[i] = tmp;
}
    public int partition(int[] array, int left, int right) {
        int index = (int)(Math.random() * (right-left+1) + left);
        swap(array, index, right);
        int small = left - 1;
        for (int i = left; i < right; i++) {
            if (array[i] <= array[right]) {
                small++;
                if (small != i) {
                    swap(array, i, small);
                }
            }
        }
        index = small + 1;
        swap(array, index, right);
        return index;
    }
    public void quickSortCore(int[] array, int left, int right) {
        if (left >= right)
            return;
        if (left < right) {
            int mid = partition(array, left, right);
            quickSortCore(array, left, mid-1);
            quickSortCore(array, mid+1, right);
        }
    }

    public List<Integer> sortArray(int[] array) {
        List<Integer> list = new ArrayList<>();
        quickSortCore(array, 0, array.length-1);    //快速排序
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        return list;
    }
    public static void main(String[] args) {
        Sort s = new Sort();
        int[] array = {5,2,6,1,7,3};
        System.out.println(s.sortArray(array).toString());
    }
}
