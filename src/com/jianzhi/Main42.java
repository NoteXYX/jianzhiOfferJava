//连续子数组的最大和
package com.jianzhi;

public class Main42 {
    public int maxSubArray(int[] nums) {
        if (nums==null || nums.length==0)
            return 0;
        int curSum = 0;
        int greatSum = 0x80000000;
        for (int num : nums) {
            if (curSum <= 0)
                curSum = num;
            else
                curSum += num;
            if (curSum > greatSum)
                greatSum = curSum;
        }
        return greatSum;
    }
    public static void main(String[] args) {
        Main42 m = new Main42();
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(m.maxSubArray(arr));
    }
}
