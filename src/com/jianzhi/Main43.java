//1~n整数中1出现的次数
package com.jianzhi;

public class Main43 {
    public int countDigitOne(int n) {
        if (n <= 0)
            return 0;
        String str = Integer.toString(n);
        return numberOf1(str);
    }
    public int numberOf1(String str) {
        if (str==null || str.charAt(0)<'0' || str.charAt(0)>'9')
            return 0;
        int length = str.length();
        int first = (int)str.charAt(0) - (int)'0';
        if (length==1 && first==0)
            return 0;
        if (length==1 && first>0)
            return 1;
        int numFirstDigit = 0;
        if (first > 1)
            numFirstDigit = powBase10(length-1);
        else if (first == 1)
            numFirstDigit = Integer.parseInt(str.substring(1, length)) + 1;
        int numOtherDigits = first * (length-1) * powBase10(length-2);
        int numRecursive = numberOf1(str.substring(1, length));
        return numFirstDigit + numOtherDigits + numRecursive;
    }
    public int powBase10(int numOfwei) {
        int result = 1;
        for (int i = 0; i < numOfwei; i++) {
            result *= 10;
        }
        return result;
    }
    public static void main(String[] args) {
        Main43 m = new Main43();
        System.out.println(m.countDigitOne(13));
    }
}
