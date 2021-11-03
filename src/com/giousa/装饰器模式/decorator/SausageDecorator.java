package com.giousa.装饰器模式.decorator;

public class SausageDecorator extends BattercakeDecorate {

    public SausageDecorator(Battercake battercake) {
        super(battercake);
    }

    @Override
    protected void toSomething() {
        System.out.println("sausage do something...");
    }

    @Override
    protected String getMsg() {
        return super.getMsg() + "+1根香肠";
    }

    @Override
    protected int getPrice() {
        return super.getPrice() + 2;
    }
}
