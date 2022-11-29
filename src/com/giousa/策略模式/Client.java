package com.giousa.策略模式;

/**
 * 策略模式简单理解，应该是对于同一个业务功能，在不同的场景需求下提供不同的实现逻辑，来达到动态切换业务算法，满足不同场景的目的。
 * 同时它也有另外的好处，即优化代码结构，使其脱离大量逻辑判断。
 * 对外只提供 Context上下文，让算法与实际业务代码解耦，对使用者屏蔽底层实现逻辑。
 */
public class Client {

    public static void main(String[] args) {
        IStrategy strategy = new ConcreteStrategyA();
        Context context = new Context(strategy);
        context.algorithm();

        IStrategy strategyB = new ConcreteStrategyB();
        Context contextB = new Context(strategyB);
        contextB.algorithm();
    }

    interface IStrategy {
        void algorithm();
    }

    static class Context {

        private IStrategy strategy;

        public Context(IStrategy strategy) {
            this.strategy = strategy;
        }

        public void algorithm() {
            this.strategy.algorithm();
        }
    }

    static class ConcreteStrategyA implements IStrategy {

        @Override
        public void algorithm() {
            System.out.println("ConcreteStrategyA");
        }
    }

    static class ConcreteStrategyB implements IStrategy {

        @Override
        public void algorithm() {
            System.out.println("ConcreteStrategyB");
        }
    }
}
