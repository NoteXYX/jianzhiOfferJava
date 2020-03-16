//把数组排成最小的数
package com.jianzhi;
import java.util.ArrayList;

public class Main45 {
    public String minNumber(int[] nums) {
        ArrayList<String> strList = new ArrayList<>();
        for (int num : nums) {
            strList.add(String.valueOf(num));
        }
        strList.sort((s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        StringBuilder sb = new StringBuilder();
        for (String str : strList) {
            sb.append(str);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Main45 m = new Main45();
        int[] nums = {3,30,34,5,9};
        System.out.println(m.minNumber(nums));
    }
}
