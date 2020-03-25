//翻转单词顺序
package com.jianzhi;

import java.util.ArrayList;

public class Main58_1 {
    public String reverseWords(String s) {
        String[] strArray = s.split(" ");
        ArrayList<String> array = new ArrayList<>();
        for (String curStr: strArray) {
            if (!curStr.equals(""))
                array.add(0, curStr);
        }
        String[] res = (String[]) array.toArray(new String[0]);
        return String.join(" ", res);
    }

    public static void main(String[] args) {
        Main58_1 m = new Main58_1();
        System.out.println(m.reverseWords("  hello world!  "));
    }
}
