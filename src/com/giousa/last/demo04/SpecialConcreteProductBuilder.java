package com.giousa.last.demo04;

/**
 * Description: 自定义特殊的构建方式
 * Author:zhangmengmeng
 * Date:2021/1/23
 * Email:65489469@qq.com
 */
public class SpecialConcreteProductBuilder implements ProductBuilderInterface {


    private String productName;

    private String companyName;

    private String part1;
    private String part2;
    private String part3;
    private String part4;



    @Override
    public void buildProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public void buildCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public void buildPart1Name(String part1) {
        this.part1 = part1;
    }

    @Override
    public void buildPart2Name(String part2) {
        this.part2 = part2;

    }

    @Override
    public void buildPart3Name(String part3) {
        this.part3 = part3;

    }

    @Override
    public void buildPart4Name(String part4) {
        this.part4 = part4;

    }

    @Override
    public Product buildProduct() {
        return new Product(this.productName,this.companyName,this.part1,this.part2,this.part3,this.part4);
    }
}
