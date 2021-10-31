package com.giousa.单例模式;

/**
 * 懒汉式
 * 使用时加载
 * <p>
 * 多线程下，不安全
 */
public class Client2 {

    public static void main(String[] args) {

//        simpleTest();

        //测试多线程，需要关闭上面方法
        System.out.println("------测试多线程------");

        threadTest();
    }

    private static void simpleTest() {
        LazySingleton.getInstance();
        LazySingleton.getInstance();
        LazySingleton.getInstance();
        LazySingleton.getInstance();
    }


//    public static class LazySingleton {
//
//        private static LazySingleton instance;
//
//        public static LazySingleton getInstance() {
//            if (instance == null) {
//                instance = new LazySingleton();
//            }
//            return instance;
//        }
//    }

    /**
     * 加锁
     */
//    public static class LazySingleton {
//
//        private static LazySingleton instance;
//
//        public synchronized static LazySingleton getInstance() {
//            if (instance == null) {
//                instance = new LazySingleton();
//            }
//            return instance;
//        }
//    }

    /**
     * 双重加锁
     */
    public static class LazySingleton {

        private static LazySingleton instance;

        public static LazySingleton getInstance() {
            if (instance == null) {
                synchronized (LazySingleton.class) {
                    if (instance == null) {
                        instance = new LazySingleton();
                    }
                }
            }
            return instance;
        }
    }

    /**
     * 注意，测试多线程，上面不要打印日志，因为System.out.println是耗时操作，就不容易打印出错误日志。
     */
    private static void threadTest() {

        Thread thread1 = new Thread(new ExectorThread());
        Thread thread2 = new Thread(new ExectorThread());
        Thread thread3 = new Thread(new ExectorThread());

        thread1.start();
        thread2.start();
        thread3.start();

        System.out.println("------end------");

        /**
         * 打印结果，有不一致的情况存在，说明不安全
         * 线程名：Thread-0 ,实例名称： com.giousa.单例模式.Client2$LazySingleton@352ebfc0
         * 线程名：Thread-1 ,实例名称： com.giousa.单例模式.Client2$LazySingleton@352ebfc0
         * 线程名：Thread-2 ,实例名称： com.giousa.单例模式.Client2$LazySingleton@7ac3ed36
         */
    }

    public static class ExectorThread implements Runnable {

        @Override
        public void run() {
            LazySingleton instance = LazySingleton.getInstance();
            System.out.println("线程名：" + Thread.currentThread().getName() + " ,实例名称： " + instance);
        }
    }
}
