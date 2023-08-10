package com.giousa.享元模式;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元模式(Flyweight Pattern)：运用共享技术有效地支持大量细粒度对象的复用。
 * 系统只使用少量的对象，而这些对象都很相似，状态变化很小，可以实现对象的多次复用。
 * 由于享元模式要求能够共享的对象必须是细粒度对象，因此它又称为轻量级模式，它是一种对象结构型模式。
 * 享元模式结构较为复杂，一般结合工厂模式一起使用。
 *
 * 在享元模式中引入了享元工厂类，享元工厂类的作用在于提供一个用于存储享元对象的享元池，当用户需要对象时，首先从享元池中获取，
 * 如果享元池中不存在，则创建一个新的享元对象返回给用户，并在享元池中保存该新增对象。
 */
public class Client {

    /**
     * 抽象享元类
     */
    interface IFlyweight {
        void operation(String extrinsicState);
    }

    /**
     * 具体享元类
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
     * 享元工厂类
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
}
