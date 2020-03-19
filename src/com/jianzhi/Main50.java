//第一个只出现一次的字符
package com.jianzhi;

import java.util.HashMap;

public class Main50 {
    public char firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char res = ' ';
        for (char ch: s.toCharArray()) {
            if (map.containsKey(ch))
                map.put(ch, map.get(ch) + 1);
            else
                map.put(ch, 1);
        }
        for (char key: s.toCharArray()) {
            if (map.get(key) == 1) {
                res = key;
                break;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Main50 m = new Main50();
        System.out.println(m.firstUniqChar("leetcode"));
    }
}
