//最长不含重复字符的子字符串
package com.jianzhi;

import java.util.Arrays;
import java.util.HashMap;

public class Main48 {
    public int lengthOfLongestSubstring(String s) { //dp[i] = dp[i-1] + 1
        if (s==null || s.length()==0)
            return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int curLen = 0;
        int maxLen = 0;
        char curChar;
        for (int i = 0; i < s.length(); i++) {
            curChar= s.charAt(i);
            if (!map.containsKey(curChar) || i-map.get(curChar) > curLen)
                curLen++;
            else {
                if (curLen > maxLen)
                    maxLen = curLen;
                curLen = i - map.get(curChar);
            }
            map.put(curChar, i);
        }
        if (curLen > maxLen)
            maxLen = curLen;
        return maxLen;
    }

    public static void main(String[] args) {
        Main48 m = new Main48();
        System.out.println(m.lengthOfLongestSubstring("abcaf"));
    }
}
