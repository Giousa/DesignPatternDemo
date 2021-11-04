package com.giousa.桥接模式;

public class Client {

    public static void main(String[] args) {
        IImplementor imp = new ConcreteImplementorA();
        Abstraction abs = new RefinedAbstraction(imp);
        abs.operation();
    }

    /**
     * 抽象实现
     */
    interface IImplementor {
        void operationImpl();
    }

    static class ConcreteImplementorA implements IImplementor {

        @Override
        public void operationImpl() {
            System.out.println("I am ConcreteImplementorA");
        }
    }

    static class ConcreteImplementorB implements IImplementor {

        @Override
        public void operationImpl() {
            System.out.println("I am ConcreteImplementorB");
        }
    }

    /**
     * 抽象
     */
    static abstract class Abstraction {

        protected IImplementor implementor;

        public Abstraction(IImplementor implementor) {
            this.implementor = implementor;
        }

        public void operation() {
            this.implementor.operationImpl();
        }
    }

    /**
     * 修正抽象
     */
    static class RefinedAbstraction extends Abstraction {

        public RefinedAbstraction(IImplementor implementor) {
            super(implementor);
        }

        @Override
        public void operation() {
            super.operation();
            System.out.println("refined operation");
        }
    }
}
