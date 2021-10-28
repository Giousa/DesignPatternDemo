package com.giousa.last.demo04;

/**
 * Description: 建造者模式，是为了解决get和set属性不方便的情况
 *
 * 模式定义：
 * 将一个复杂对象的创建与他的表示分离，使得同样的构建过程可以创建不同的表示
 *
 * 如：链式构建对象，每一次赋值属性，都返回对象本身
 *
 * 简单来说：将一个对象，拆分成n个子对象
 *
 * 一般配合不可变对象进行使用
 *
 * Author:zhangmengmeng
 * Date:2021/1/23
 * Email:65489469@qq.com
 */
public class BuilderTest {

    public static void main(String[] args) {
//        Product2 product = new Product2();
//        product.setCompanyName("xxx");
//
//        product.setPart1("1");
//        product.setPart2("2");
//        product.setPart3("3");
//        product.setPart4("4");
//
//        System.out.println(product);


        DefaultConcreteProductBuilder defaultConcreteProductBuilder = new DefaultConcreteProductBuilder();

        Director director = new Director(defaultConcreteProductBuilder);

        Product product = director.makeProduct("产品", "芳文社", "1", "2", "3", "4");

        System.out.println(product);

        System.out.println("-------------------------------");

        SpecialConcreteProductBuilder specialConcreteProductBuilder = new SpecialConcreteProductBuilder();

        Director director2 = new Director(specialConcreteProductBuilder);

        Product product2 = director2.makeProduct("产品2", "芳文社2", "a", "b", "c", "d");

        System.out.println(product2);

    }
}
