package com.jianzhi;
import java.util.*;

public class Sort {
    /********************************************快速排序********************************************/
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
        if (left < right) {
            int mid = partition(array, left, right);
            quickSortCore(array, left, mid-1);
            quickSortCore(array, mid+1, right);
        }
    }
    /****************************************************************************************************/

    /**************************************归并排序*******************************************************/
    public static void sort(int []arr){
        int []temp = new int[arr.length];//在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        sort(arr,0,arr.length-1,temp);
    }
    private static void sort(int[] arr,int left,int right,int []temp){
        if(left<right){
            int mid = (left+right)/2;
            sort(arr,left,mid,temp);//左边归并排序，使得左子序列有序
            sort(arr,mid+1,right,temp);//右边归并排序，使得右子序列有序
            merge(arr,left,mid,right,temp);//将两个有序子数组合并操作
        }
    }
    private static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i = left;//左序列指针
        int j = mid+1;//右序列指针
        int t = 0;//临时数组指针
        while (i<=mid && j<=right){
            if(arr[i]<=arr[j]){
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
            }
        }
        while(i<=mid){//将左边剩余元素填充进temp中
            temp[t++] = arr[i++];
        }
        while(j<=right){//将右序列剩余元素填充进temp中
            temp[t++] = arr[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while(left <= right){
            arr[left++] = temp[t++];
        }
    }
    /****************************************************************************************************/
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
