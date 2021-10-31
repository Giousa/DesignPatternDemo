package com.giousa.单例模式;


/**
 * 饿汉式
 * 刚开始就初始化
 */
public class Client {

    public static void main(String[] args) {
        Singleton.getInstance();
        Singleton.getInstance();
        Singleton.getInstance();
        Singleton.getInstance();
    }

    public static class Singleton {

        private static final Singleton instance = new Singleton();

        private Singleton() {
        }

        public static Singleton getInstance() {
            System.out.println("创建单例: " + instance);
            return instance;
        }

    }
}
