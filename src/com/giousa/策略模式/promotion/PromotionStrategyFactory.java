package com.giousa.策略模式.promotion;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PromotionStrategyFactory {

    private static Map<String, IPromotionStrategy> map = new HashMap<>();

    static {
        map.put(PromotionKey.COUPON, new CouponStrategy());
        map.put(PromotionKey.CASHBACK, new CashbackStrategy());
        map.put(PromotionKey.GROUPBY, new GroupbuyStrategy());
    }

    private static final IPromotionStrategy empty = new EmptyStrategy();

    public static IPromotionStrategy getPromotionStrategy(String key) {
        IPromotionStrategy promotionStrategy = map.get(key);

        return promotionStrategy == null ? empty : promotionStrategy;
    }

    public static Set<String> getPromotionKeys() {
        return map.keySet();
    }
}
