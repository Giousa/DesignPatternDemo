package com.giousa.装饰器模式.decorator;

public class Test {

    public static void main(String[] args) {
        Battercake battercake;

        //买一个煎饼
        battercake = new BaseBattercake();

        //买一个鸡蛋
        battercake = new EggDecorator(battercake);

        //买一根香肠
        battercake = new SausageDecorator(battercake);

        //买一个鸡蛋
        battercake = new EggDecorator(battercake);

        System.out.println("购买明细：" + battercake.getMsg());
        System.out.println("总价：" + battercake.getPrice());
    }
}
