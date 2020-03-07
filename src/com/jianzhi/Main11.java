//旋转数组的最小数字
package com.jianzhi;
public class Main11 {
    public int minNumberInRotateArray(int [] array) {
        int p1 = 0;
        int p2 = array.length-1;
        int mid = 0;
        while (array[p1] >= array[p2]) {
            mid = (p2+p1) / 2;
            if (array[p1] == array[mid] && array[mid] == array[p2]) {
                return inOrder(array);
            }
            if (array[p1] <= array[mid]) {
                p1 = mid;
            }
            else if (array[p2] >= array[mid]) {
                p2 = mid;
            }
            if (p2-p1 == 1) {
                mid = p2;
                break;
            }
        }
        return array[mid];
    }
    public int inOrder(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length ; i++) {
            if (array[i] < min){
                min = array[i];
            }
        }
        return min;
    }
    public static void main(String[] args) {
        Main11 m = new Main11();
        int[] array = {10,1,10,10,10};
        System.out.println(m.minNumberInRotateArray(array));
    }
}
