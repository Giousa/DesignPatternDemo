package com.giousa.桥接模式;


/**
 * 桥接模式：对接口进行拓展
 */
public class Client {

    public static void main(String[] args) {

        System.out.println("---------------桥接前-正常方式---------------");
        ConcreteImplementorA concreteImplementorA = new ConcreteImplementorA();
        concreteImplementorA.operationImpl();

        System.out.println("---------------桥接后---------------");
        Abstraction abs = new RefinedAbstraction(new ConcreteImplementorA());
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
            System.out.println("我是具体实现化角色A");
        }
    }

    static class ConcreteImplementorB implements IImplementor {

        @Override
        public void operationImpl() {
            System.out.println("我是具体实现化角色B");
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
            System.out.println("扩展抽象化角色被访问");
            super.operation();
        }
    }
}
