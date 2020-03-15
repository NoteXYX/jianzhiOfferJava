//数字序列中某一位的数字
package com.jianzhi;

public class Main44 {
    public int findNthDigit(int n) {
        if (n <= 0)
            return 0;
        if (n <= 9)
            return n;
        long weishu = 1;
        long remainNum = 9;
        int begin = 1;
        while (n-weishu*remainNum > 0) {
            n = (int) (n - weishu * remainNum);
            weishu++;
            remainNum *= 10;
            begin *= 10;
        }
        int num = (int) (n / weishu);
        int wei = (int) (n % weishu);
        String resTotalNum;
        if (wei == 0) {
            num--;
            resTotalNum = String.valueOf(num+begin);
            wei = resTotalNum.length();
        }
        else
            resTotalNum = String.valueOf(num+begin);
        return (int)resTotalNum.charAt(wei-1) - (int)'0';
    }

    public static void main(String[] args) {
        Main44 m = new Main44();
        System.out.println(m.findNthDigit(190));
        System.out.println((int)Math.pow(2, 31)-1);
    }
}
