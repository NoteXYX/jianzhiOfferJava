//把数字翻译成字符串
package com.jianzhi;

public class Main46 {
    public int translateNum(int num) {
        if (num < 0)
            return 0;
        String numStr = String.valueOf(num);
        return getNum(numStr);
    }
    public int getNum(String numStr) {
        int len = numStr.length();
        int[] counts = new int[len];
        int count = 0;
        for (int i = len-1; i >= 0; i--) {
            if (i < len-1)
                count = counts[i+1];
            else
                count = 1;
            if (i < len -1) {
                int digit1 = (int)numStr.charAt(i) - (int)'0';
                int digit2 = (int)numStr.charAt(i+1) - (int)'0';
                int cur = 10 * digit1 + digit2;
                if (cur>=10 && cur<=25) {
                    if (i < len-2)
                        count += counts[i+2];
                    else
                        count += 1;
                }
            }
            counts[i] = count;
        }
        return counts[0];
    }

    public static void main(String[] args) {
        Main46 m = new Main46();
        System.out.println(m.translateNum(12258));
    }
}
