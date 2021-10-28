package com.giousa.last.demo04.v2;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2021/1/24
 * Email:65489469@qq.com
 */
public class BuildTest2 {

    public static void main(String[] args) {

        Product2 product2 = new Product2("产品", "芳文社", "1", "2", "3", "4");
        System.out.println("原始方式：");
        System.out.println(product2);

        Product2 build = new Product2.Builder().productName("xxx").companyName("ffff").part1("1111").build();

        System.out.println("链式调用：");
        System.out.println(build);
    }
}
