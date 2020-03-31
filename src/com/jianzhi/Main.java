package com.jianzhi;

import java.util.ArrayList;

public class Main {
    public static void f() {
        f();
    }
    public static void main(String[] args) {
        ArrayList<int[]> list = new ArrayList<>();
        while (true) {
            list.add(new int[2000000000]);
        }
    }
//    public static void main(String[] args) {
//        System.out.println("main start...");
//        Thread t = new Thread() {
//            public void run() {
//                System.out.println("thread run...");
//                try {
//                    Thread.sleep(10);
//                    if(isInterrupted())
//                        return;
//                } catch (InterruptedException e) {}
//                System.out.println("thread end.");
//            }
//        };
//        t.start();
//        t.interrupt();
//        try {
//            Thread.sleep(20);
//        } catch (InterruptedException e) {}
//        System.out.println("main end...");
//    }
}
