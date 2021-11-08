package com.giousa.策略模式.promotion;

public class EmptyStrategy implements IPromotionStrategy{
    @Override
    public void doPromotion() {
        System.out.println("无优惠");
    }
}
