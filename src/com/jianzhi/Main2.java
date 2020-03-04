package com.jianzhi;

public class Main2 {
    public String replaceSpace(StringBuffer str) {
        return str.toString().replace(" ", "%20");

    }
    public static void main(String[] args) {
        Main2 m = new Main2();
        StringBuffer sbf = new StringBuffer("we are happy");
        System.out.println(m.replaceSpace(sbf));

    }
}
