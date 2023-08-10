package com.giousa.工厂模式;

/**
 * 简单工厂模式
 */
public class Client {

    public interface IProduct {
        void doSomething();
    }

    public static class ProductA implements IProduct {

        @Override
        public void doSomething() {
            System.out.println("I am product A");
        }
    }

    public static class ProductB implements IProduct {

        @Override
        public void doSomething() {
            System.out.println("I am product B");
        }
    }

    public static class ProductC implements IProduct {

        @Override
        public void doSomething() {
            System.out.println("I am product C");
        }
    }

    public static class Constant {
        public static final int PRODUCT_A = 1;
        public static final int PRODUCT_B = 2;
        public static final int PRODUCT_C = 3;
    }

    public static class ProductFactory {

        public static IProduct getProduct(int index) {

            switch (index) {
                case Constant.PRODUCT_A:
                    return new ProductA();

                case Constant.PRODUCT_B:
                    return new ProductB();

                case Constant.PRODUCT_C:
                    return new ProductC();
            }

            return null;
        }
    }


    public static void main(String[] args) {
        IProduct product = ProductFactory.getProduct(1);
        product.doSomething();

        IProduct product2 = ProductFactory.getProduct(2);
        product2.doSomething();

        IProduct product3 = ProductFactory.getProduct(3);
        product3.doSomething();
    }
}
