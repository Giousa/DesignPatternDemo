package com.giousa.享元模式;

import java.util.HashMap;
import java.util.Map;

public class Client {

    public static void main(String[] args) {

        FlyweightFactory flyweightFactory = new FlyweightFactory();
        IFlyweight flyweight1 = FlyweightFactory.getFlyweight("aa");
        IFlyweight flyweight2 = flyweightFactory.getFlyweight("bb");
        IFlyweight flyweight3 = flyweightFactory.getFlyweight("aa");
        IFlyweight flyweight4 = flyweightFactory.getFlyweight("aa");

        flyweight1.operation("111");
        flyweight2.operation("222");
        flyweight3.operation("333");
        flyweight4.operation("444");
    }

    interface IFlyweight {
        void operation(String extrinsicState);
    }

    /**
     * 具体享元角色
     */
    public static class ConcreteFlyweight implements IFlyweight {

        private String intrinsicState;

        public ConcreteFlyweight(String intrinsicState) {
            this.intrinsicState = intrinsicState;
        }

        @Override
        public void operation(String extrinsicState) {
            System.out.println("Object address: " + System.identityHashCode(this));
            System.out.println("IntrinsicState: " + this.intrinsicState);
            System.out.println("ExtrinsicState: " + extrinsicState);
        }
    }

    /**
     * 享元工厂
     */
    public static class FlyweightFactory {
        private static Map<String, IFlyweight> pool = new HashMap<>();

        public static IFlyweight getFlyweight(String intrinsicState) {
            if (!pool.containsKey(intrinsicState)) {
                IFlyweight flyweight = new ConcreteFlyweight(intrinsicState);
                pool.put(intrinsicState, flyweight);
            }
            return pool.get(intrinsicState);
        }
    }
}
