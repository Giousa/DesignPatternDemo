package com.giousa.单例模式;

public class PatternSingleton {

    /**
     * 双重加锁-非常安全
     */
    public static class SingletonDoubleSync {
        private static SingletonDoubleSync instance;

        public static SingletonDoubleSync getInstance() {
            if (instance == null) {
                synchronized (SingletonDoubleSync.class) {
                    if (instance == null) {
                        instance = new SingletonDoubleSync();
                    }
                }
            }
            return instance;
        }
    }

    /**
     * 饿汉式-线程安全
     * 初始化时加载
     */
    public static class SingletonHunger {
        private static final SingletonHunger instance = new SingletonHunger();

        private SingletonHunger() {
        }

        public static SingletonHunger getInstance() {
            return instance;
        }
    }

    /**
     * 懒加载（懒汉式）-线程不安全
     */
    public static class SingletonLazy {
        private static SingletonLazy instance;

        public static SingletonLazy getInstance() {
            if (instance == null) {
                instance = new SingletonLazy();
            }
            return instance;
        }
    }
}
