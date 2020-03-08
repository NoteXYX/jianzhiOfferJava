//调整数组顺序使奇数位于偶数前面
package com.jianzhi;
import java.util.Arrays;
public class Main21 {
    public int[] exchange(int[] nums) {
        if (nums.length == 0)
            return nums;
        int[] sorted = Arrays.copyOf(nums, nums.length);
        int i = 0;
        int j = 0;
        int tmp,tmpIndex;
        while (i<sorted.length && j<sorted.length) {
            while (i < sorted.length && (sorted[i] & 1) == 1)  //如果是奇数
                i++;
            j = i + 1;
            while (j < sorted.length && (sorted[j] & 1) == 0)  //如果是偶数
                j++;
            if (j < sorted.length) {
                tmp = sorted[j];
                for (tmpIndex = j; tmpIndex > i; tmpIndex--) {
                    sorted[tmpIndex] = sorted[tmpIndex-1];
                }
                sorted[i] = tmp;
            }
        }
        return sorted;
    }
    public static void main(String[] args) {
        Main21 m = new Main21();
        int[] array = {1,2,3,4,5,6};
        System.out.println(Arrays.toString(m.exchange(array)));
    }
}
