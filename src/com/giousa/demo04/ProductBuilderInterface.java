package com.giousa.demo04;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2021/1/23
 * Email:65489469@qq.com
 */
public interface ProductBuilderInterface {

    void buildProductName(String productName);
    void buildCompanyName(String companyName);
    void buildPart1Name(String part1);
    void buildPart2Name(String part2);
    void buildPart3Name(String part3);
    void buildPart4Name(String part4);

    Product buildProduct();
}
