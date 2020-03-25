//滑动窗口的最大值
package com.jianzhi;

import java.util.Arrays;

public class Main59_1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums==null || nums.length==0 || nums.length<k)
            return new int[0];
        if (k == 1)
            return nums;
        int len = nums.length;
        int[] res = new int[len-k+1];
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        for (int i = 0; i < k; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        res[0] = max;
        for (int i = 1; i <= len-k; i++) {
            if (nums[i+k-1] >= max) {
                max = nums[i+k-1];
                maxIndex = i+k-1;
                res[i] = nums[maxIndex];
            }
            else if (i > maxIndex) {
                max = nums[i];
                for (int j = i; j < i+k; j++) {
                    if (nums[j] >= max) {
                        max = nums[j];
                        maxIndex = j;
                    }
                }
                res[i] = nums[maxIndex];
            }
            else
                res[i] = nums[maxIndex];
        }
        return res;
    }

    public static void main(String[] args) {
        Main59_1 m = new Main59_1();
        int[] nums = {7,2,4};
        System.out.println(Arrays.toString(m.maxSlidingWindow(nums, 2)));
    }
}
