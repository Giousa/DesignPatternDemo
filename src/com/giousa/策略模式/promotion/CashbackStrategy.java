package com.giousa.策略模式.promotion;

public class CashbackStrategy implements IPromotionStrategy{
    @Override
    public void doPromotion() {
        System.out.println("返现，直接打款到支付宝");
    }
}
