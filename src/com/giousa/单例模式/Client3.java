package com.giousa.单例模式;

import java.lang.reflect.Constructor;

/**
 * 静态内部类创建单例
 */
public class Client3 {

    public static void main(String[] args) {

//        test();

        reflex();
    }

    private static void reflex() {
        try {
            Class<LazySingleton> clazz = LazySingleton.class;

            Constructor<LazySingleton> declaredConstructor = clazz.getDeclaredConstructor(null);

            declaredConstructor.setAccessible(true);

            System.out.println(declaredConstructor.newInstance());
            System.out.println(declaredConstructor.newInstance());
            System.out.println(declaredConstructor.newInstance());
            System.out.println(declaredConstructor.newInstance());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void test(){
        System.out.println(LazySingleton.getInstance());
        System.out.println(LazySingleton.getInstance());
        System.out.println(LazySingleton.getInstance());
        System.out.println(LazySingleton.getInstance());
    }

    public static class LazySingleton {

        private LazySingleton() {
            System.out.println("LazySingleton 构造方法加载");

            //此判断方法，是为了防止反射，恶意破坏单例模式
            if(LazyHolder.INSTANCE != null){
                throw new RuntimeException("不能创建多个实例");
            }
        }

        private static LazySingleton getInstance() {
            return LazyHolder.INSTANCE;
        }

        private static class LazyHolder {
            private static final LazySingleton INSTANCE = new LazySingleton();
        }
    }

}
