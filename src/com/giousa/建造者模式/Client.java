package com.giousa.建造者模式;

public class Client {

    public static void main(String[] args) {
        ConcreteBuilder concreteBuilder = new ConcreteBuilder();
        System.out.println(concreteBuilder.build());
    }

    static class Product{

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    interface IBuilder{
        Product build();
    }

    static class ConcreteBuilder implements IBuilder{

        private Product product = new Product();

        @Override
        public Product build() {
            return product;
        }
    }
}
