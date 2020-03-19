//数组中的逆序对
package com.jianzhi;
import java.util.Arrays;

public class Main51 {
    public int reversePairs(int[] nums) {
        if (nums==null || nums.length<=1)
            return 0;
        int[] copy = Arrays.copyOf(nums, nums.length);
        int numberOfInversePairs = reversePairsCore(nums, copy, 0, nums.length-1);
        return numberOfInversePairs;
    }
    public int reversePairsCore(int[] nums, int[] copy, int start, int end) {
        if (start == end) {
            copy[start] = nums[start];
            return 0;
        }
        int len = (end - start) / 2;
        int leftNum = reversePairsCore(copy, nums, start, start+len);
        int rigthNum = reversePairsCore(copy, nums, start+len+1, end);
        int i = start + len;
        int j = end;
        int copyIndex = end;
        int count = 0;
        while (i>=start && j>=start+len+1) {
            if (nums[i] > nums[j]) {
                copy[copyIndex--] = nums[i--];
                count += j - start - len;
            }
            else {
                copy[copyIndex--] = nums[j--];
            }
        }
        for ( ; i>=start; --i) {
            copy[copyIndex--] = nums[i];
        }
        for ( ; j>=start+len+1; --j) {
            copy[copyIndex--] = nums[j];
        }
        return count + leftNum + rigthNum;
    }
}
