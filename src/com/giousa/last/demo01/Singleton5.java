package com.giousa.last.demo01;

/**
 * Description: 枚举 线程安全，调用效率高，不能延时加载，可以天然的防止反射和反序列化调用
 * Author:zhangmengmeng
 * Date:2021/1/23
 * Email:65489469@qq.com
 */
public enum  Singleton5 {


    instance;

    public void getInstance(){

    }


}
