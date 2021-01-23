package com.giousa.demo02;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2021/1/23
 * Email:65489469@qq.com
 */
public class Test {

    public static void main(String[] args) {

        ProductA a = (ProductA) ProductFactory.getProduct("A");
        a.method1();

        ProductB b = (ProductB) ProductFactory.getProduct("B");
        b.method1();


        ProductC c = (ProductC) ProductFactory.getProduct("C");
        c.method1();


//        Product d =  ProductFactory.getProduct("D");
//        d.method1();
    }
}
