package com.giousa.demo01;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2021/1/23
 * Email:65489469@qq.com
 */
public class Thread1 implements Runnable{


    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            Singleton2.getInstance();
        }
    }
}
