//把字符串转换成整数
package com.jianzhi;

public class Main67 {
    public int strToInt(String str) {
        if (str==null || str.length()==0)
            return 0;
        int first = 0;
        int fuhao = 1;
        int i = 0;
        boolean metFuhao = false;
        for ( ; i < str.length(); i++) {
            if (metFuhao && !isPureNum(str.charAt(i)))
                return 0;
            if (str.charAt(i) == ' ')
                continue;
            if (!isPureNum(str.charAt(i))) {
                if (str.charAt(i) == '-' && !metFuhao) {
                    fuhao = -1;
                    metFuhao = true;
                }
                else if (str.charAt(i) == '+' && !metFuhao) {
                    fuhao = 1;
                    metFuhao = true;
                }
                else
                    return 0;
            }
            else {
                first = i;
                break;
            }
        }
        if (i == str.length()-1 && first != str.length()-1)
            return 0;
        long res = 0;
        for (int j = first; j < str.length(); j++) {
            if (isPureNum(str.charAt(j))) {
                res = res * 10 + (int)str.charAt(j) - (int)'0';
                if (res * fuhao > Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
                if (res * fuhao < Integer.MIN_VALUE)
                    return Integer.MIN_VALUE;
            }
            else
                break;
        }
        return (int)res * fuhao;
    }
    public boolean isPureNum(char c) {
        int num = c - '0';
        if (num >=0 && num <= 9)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        Main67 m = new Main67();
        System.out.println(m.strToInt("- 234"));
    }
}
