package com.giousa.last.demo01;

/**
 * Description: 双检单例
 * Author:zhangmengmeng
 * Date:2021/1/23
 * Email:65489469@qq.com
 */
public class Singleton3 {


    private volatile static Singleton3 instance;

    private Singleton3(){}

    public static Singleton3 getInstance(){

        if(instance == null){

            synchronized (Singleton3.class){
                if (instance == null){
                    instance = new Singleton3();
                }
            }
        }

        System.out.println("Singleton2:  "+instance);
        return instance;

    }
}
