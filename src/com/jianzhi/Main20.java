//表示数值的字符串
package com.jianzhi;
public class Main20 {
    public boolean isNumber(String s) {
        if (s.length() == 0)
            return false;
        s = s.trim();
        boolean metNum = false;
        boolean metE = false;
        boolean metdot = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (i>0 && (s.charAt(i-1)!='e' && s.charAt(i-1)!='E'))
                    return false;
            }
            else if (s.charAt(i) == '.') {
                if (metdot || metE)
                    return false;
                metdot = true;
            }
            else if (s.charAt(i)=='e' || s.charAt(i)=='E') {
                if (metE || !metNum)
                    return false;
                metE = true;
                metNum = false;
            }
            else if (Character.isDigit(s.charAt(i)))
                metNum = true;
            else
                return false;
        }
        return metNum;
    }
    public static void main(String[] args) {
        Main20 m = new Main20();
        System.out.println(m.isNumber(" 005047e+6"));
    }
}
