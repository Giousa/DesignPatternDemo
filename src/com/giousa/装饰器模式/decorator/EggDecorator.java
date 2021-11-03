package com.giousa.装饰器模式.decorator;

public class EggDecorator extends BattercakeDecorate {

    public EggDecorator(Battercake battercake) {
        super(battercake);
    }

    @Override
    protected void toSomething() {
        System.out.println("egg do something...");
    }

    @Override
    protected String getMsg() {
        return super.getMsg() + "+1个鸡蛋";
    }

    @Override
    protected int getPrice() {
        return super.getPrice() + 1;
    }
}
