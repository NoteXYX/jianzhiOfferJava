//左旋转字符串
package com.jianzhi;

public class Main58_2 {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }
    public static void main(String[] args) {
        Main58_2 m = new Main58_2();
        System.out.println(m.reverseLeftWords("abcdefg", 2));
    }
}
