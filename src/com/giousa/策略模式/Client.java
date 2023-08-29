package com.giousa.策略模式;

/**
 * 策略模式简单理解，应该是对于同一个业务功能，在不同的场景需求下提供不同的实现逻辑，来达到动态切换业务算法，满足不同场景的目的。
 * 同时它也有另外的好处，即优化代码结构，使其脱离大量逻辑判断。
 * 对外只提供 Context上下文，让算法与实际业务代码解耦，对使用者屏蔽底层实现逻辑。
 */
public class Client {

    /**
     * 策略接口，规定算法的统一操作
     */
    interface IStrategy {
        void algorithm();
    }

    /**
     * 执行
     */
    public static class Exec {
        public void fun(IStrategy iStrategy){
            iStrategy.algorithm();
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // 封装各个算法
    ///////////////////////////////////////////////////////////////////////////
    static class ConcreteStrategyA implements IStrategy {

        @Override
        public void algorithm() {
            System.out.println("策略A，实现目标");
        }
    }

    static class ConcreteStrategyB implements IStrategy {

        @Override
        public void algorithm() {
            System.out.println("策略B，实现目标");
        }
    }

    /**
     * 测试
     */
    public static void main(String[] args) {
        Exec exec = new Exec();
        exec.fun(new ConcreteStrategyA());
        exec.fun(new ConcreteStrategyB());
    }
}
