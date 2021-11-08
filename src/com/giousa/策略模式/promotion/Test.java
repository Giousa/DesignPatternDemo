package com.giousa.策略模式.promotion;

import java.util.Set;

public class Test {

    public static void main(String[] args) {
        PromotionActivity promotionActivity1 = new PromotionActivity(new CouponStrategy());
        promotionActivity1.execute();

        PromotionActivity promotionActivity2 = new PromotionActivity(new GroupbuyStrategy());
        promotionActivity2.execute();

        System.out.println("-------------------");

        Set<String> promotionKeys = PromotionStrategyFactory.getPromotionKeys();
        System.out.println("promotionKeys:");
        System.out.println(promotionKeys);

        IPromotionStrategy promotionStrategy = PromotionStrategyFactory.getPromotionStrategy("COUPON");

        promotionStrategy.doPromotion();
    }
}
