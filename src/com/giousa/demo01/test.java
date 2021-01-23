package com.giousa.demo01;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2021/1/23
 * Email:65489469@qq.com
 */
public class test {

    public static void main(String[] args) {


//        runSingleton1();

        runSingleton2();


    }


    private static void runSingleton1() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    Singleton1 instance = Singleton1.getInstance();

                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    Singleton1 instance = Singleton1.getInstance();

                }
            }
        }).start();
    }


    private static void runSingleton2() {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();

        thread1.run();
        thread2.run();
    }
}
