package com.giousa.装饰器模式.decorator;

public abstract class BattercakeDecorate extends Battercake{

    private Battercake battercake;

    public BattercakeDecorate(Battercake battercake) {
        this.battercake = battercake;
        toSomething();
    }

    protected abstract void toSomething();

    @Override
    protected String getMsg() {
        return this.battercake.getMsg();
    }

    @Override
    protected int getPrice() {
        return this.battercake.getPrice();
    }
}
