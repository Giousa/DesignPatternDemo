package com.giousa.demo04;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2021/1/23
 * Email:65489469@qq.com
 */
public class Director {

    private ProductBuilderInterface builder;

    public Director(ProductBuilderInterface builder) {
        this.builder = builder;
    }

    public Product makeProduct(String productName, String companyName, String part1, String part2, String part3, String part4){
        //控制顺序

        builder.buildProductName(productName);
        builder.buildCompanyName(companyName);
        builder.buildPart1Name(part1);
        builder.buildPart2Name(part2);
        builder.buildPart3Name(part3);
        builder.buildPart4Name(part4);

        return builder.buildProduct();
    }
}
