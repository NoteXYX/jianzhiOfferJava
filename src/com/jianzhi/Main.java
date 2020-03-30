package com.jianzhi;

public class Main {
    public static void main(String[] args) {
        System.out.println("main start...");
        Thread t = new Thread() {
            public void run() {
                System.out.println("thread run...");
                try {
                    Thread.sleep(10);
                    if(isInterrupted())
                        return;
                } catch (InterruptedException e) {}
                System.out.println("thread end.");
            }
        };
        t.start();
        t.interrupt();
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {}
        System.out.println("main end...");
    }
}
