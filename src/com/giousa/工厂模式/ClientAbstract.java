package com.giousa.工厂模式;

/**
 * 抽象工厂模式
 */
public class ClientAbstract {
    public interface IProductA {
        void doA();
    }

    public interface IProductB {
        void doB();
    }

    public interface IFactory {
        IProductA makeProductA();

        IProductB makeProductB();
    }

    public static class ConcreteProductAWithFamilyA implements IProductA {

        @Override
        public void doA() {
            System.out.println("family A product A");
        }
    }

    public static class ConcreteProductBWithFamilyA implements IProductB {

        @Override
        public void doB() {
            System.out.println("family A product B");
        }
    }

    public static class ConcreteProductAWithFamilyB implements IProductA {

        @Override
        public void doA() {
            System.out.println("family B product A");
        }
    }

    public static class ConcreteProductBWithFamilyB implements IProductB {

        @Override
        public void doB() {
            System.out.println("family B product B");
        }
    }

    public static class ConcreteFactoryA implements IFactory {

        @Override
        public IProductA makeProductA() {
            return new ConcreteProductAWithFamilyA();
        }

        @Override
        public IProductB makeProductB() {
            return new ConcreteProductBWithFamilyA();
        }
    }

    public static class ConcreteFactoryB implements IFactory {

        @Override
        public IProductA makeProductA() {
            return new ConcreteProductAWithFamilyB();
        }

        @Override
        public IProductB makeProductB() {
            return new ConcreteProductBWithFamilyB();
        }
    }


    public static void main(String[] args) {
        ConcreteFactoryA concreteFactoryA = new ConcreteFactoryA();
        concreteFactoryA.makeProductA().doA();
        concreteFactoryA.makeProductB().doB();
    }
}
