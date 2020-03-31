//和为s的连续正数序列
package com.jianzhi;
import java.util.ArrayList;

public class Main57_2 {
    public int[][] findContinuousSequence(int target) {
        ArrayList<int[]> res = new ArrayList<>();
        ArrayList<Integer> curRes = new ArrayList<>();
        int start = 1;
        int end = 2;
        int sum = 0;
        while (start<end) {
            sum = (end-start+1)*(start+end)/2;
            if (sum < target)
                end++;
            else if (sum > target)
                start++;
            else {
                for (int i = start; i<=end; i++)
                    curRes.add(i);
                res.add(curRes.stream().mapToInt(Integer::intValue).toArray());
                curRes.clear();
                start++;
                end++;
            }
        }
        int[][] result = res.toArray(new int[res.size()][]);
        return result;
    }
}
