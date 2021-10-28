package com.giousa.last.demo01;

/**
 * Description: 懒汉式，线程不安全，调用效果不高，懒加载 我们需要加上锁，就变成安全了
 * Author:zhangmengmeng
 * Date:2021/1/23
 * Email:65489469@qq.com
 */
public class Singleton2 {


    private static Singleton2 instance;

    private Singleton2(){}

    public static synchronized Singleton2 getInstance(){
        if (instance == null){
            instance = new Singleton2();
        }

        System.out.println("Singleton2:  "+instance);
        return instance;
    }
}
