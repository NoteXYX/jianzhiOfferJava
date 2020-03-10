//变态跳台阶 1 or 2 or ..... or n
package com.jianzhi;
public class Main9 {
    public int JumpFloorII(int n) {
        return (int) Math.pow(2,(n-1));
    }
    public static void main(String[] args) {
        Main9 m = new Main9();
        System.out.println(m.JumpFloorII(3));
    }
}
