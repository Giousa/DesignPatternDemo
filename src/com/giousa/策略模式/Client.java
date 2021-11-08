package com.giousa.策略模式;

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
