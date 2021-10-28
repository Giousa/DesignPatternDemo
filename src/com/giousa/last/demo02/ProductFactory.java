package com.giousa.last.demo02;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2021/1/23
 * Email:65489469@qq.com
 */
public class ProductFactory {

    public static Product getProduct(String type){

        switch (type){

            case "A":
                return new ProductA();

            case "B":

                return new ProductB();

            case "C":

                return new ProductC();
        }


        return null;
    }
}
