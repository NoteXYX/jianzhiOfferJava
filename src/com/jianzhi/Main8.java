//青蛙跳台阶 1 or 2
package com.jianzhi;
public class Main8 {
    public int JumpFloor(int target) {
        int fnm1 = 2;
        int fnm2 = 1;
        if (target == 1) {
            return fnm2;
        }
        if (target == 2) {
            return fnm1;
        }
        int f = 0;
        for (int i = 3; i <= target; i++) {
            f = fnm1 + fnm2;
            fnm2 = fnm1;
            fnm1 = f;
        }
        return f;
    }
    public static void main(String[] args) {
        Main8 m = new Main8();
        System.out.println(m.JumpFloor(3));
    }
}
