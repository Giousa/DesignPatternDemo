package com.giousa.工厂模式;

/**
 * 工厂方法模式
 */
public class ClientFactory {

    public static void main(String[] args) {
        FactoryA factoryA = new FactoryA();
        factoryA.makeProduct().doSomething();

        FactoryB factoryB = new FactoryB();
        factoryB.makeProduct().doSomething();
    }

    public interface IProduct{
        void doSomething();
    }

    public interface IFactory{
        IProduct makeProduct();
    }

    public static class ProductA implements IProduct{

        @Override
        public void doSomething() {
            System.out.println("I am Product A");
        }
    }

    public static class ProductB implements IProduct{

        @Override
        public void doSomething() {
            System.out.println("I am Product B");
        }
    }

    public static class FactoryA implements IFactory{

        @Override
        public IProduct makeProduct() {
            return new ProductA();
        }
    }

    public static class FactoryB implements IFactory{

        @Override
        public IProduct makeProduct() {
            return new ProductB();
        }
    }
}
