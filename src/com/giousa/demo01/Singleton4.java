package com.giousa.demo01;

/**
 * Description: 静态内部类实现  线程安全，调用效率高，可以延时加载
 * Author:zhangmengmeng
 * Date:2021/1/23
 * Email:65489469@qq.com
 */
public class Singleton4 {


    private static class Singleton4Instance{
        private static final Singleton4 instance = new Singleton4();
    }

    private Singleton4(){}

    public static Singleton4 getInstance(){

        return Singleton4Instance.instance;

    }
}
