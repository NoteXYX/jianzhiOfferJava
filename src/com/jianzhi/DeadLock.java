package com.jianzhi;

public class DeadLock {
    Object a = new Object();
    Object b = new Object();
    public static void main(String[] args) {
        DeadLock lock=new DeadLock();
        lock.deadLock();
    }
    public void deadLock(){
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (a){
                    System.out.println("我有笔，没有本");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (b){
                        System.out.println("我有笔，也有本");
                    }
                }
            }
        });
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (b){
                    System.out.println("我有本，没有笔");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (a){
                        System.out.println("我有本，也有笔");
                    }
                }
            }
        });
        thread1.start();
        thread.start();
    }
}