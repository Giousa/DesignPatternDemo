package com.giousa.策略模式.promotion;

public class GroupbuyStrategy implements IPromotionStrategy{
    @Override
    public void doPromotion() {
        System.out.println("5人团，可以优惠");
    }
}
