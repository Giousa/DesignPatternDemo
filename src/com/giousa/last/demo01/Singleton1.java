package com.giousa.last.demo01;

/**
 * Description: 饿汉式/饱汉式  一开始就创建了，非懒加载  线程安全，调用效率高，但浪费资源
 * Author:zhangmengmeng
 * Date:2021/1/23
 * Email:65489469@qq.com
 */
public class Singleton1 {

    private static Singleton1 instance = new Singleton1();

    private Singleton1(){}

    public static Singleton1 getInstance(){
        System.out.println("Singleton1:  "+instance);

        return instance;
    }
}
