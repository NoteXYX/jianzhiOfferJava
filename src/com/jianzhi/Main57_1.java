//和为s的两个数字
package com.jianzhi;

public class Main57_1 {
    public int[] twoSum(int[] nums, int target) {
        if (nums==null || nums.length<2)
            return new int[0];
        int start = 0;
        int end = nums.length-1;
        while (start<end && nums[start]+nums[end]!=target) {
            if (nums[start] + nums[end] > target)
                end--;
            else if (nums[start] + nums[end] < target)
                start++;
        }
        return new int[]{nums[start], nums[end]};
    }
}
