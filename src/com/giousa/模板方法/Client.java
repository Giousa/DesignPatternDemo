package com.giousa.模板方法;

public class Client {

    public static void main(String[] args) {
        AbstractClass abstractClassA = new ConcreteClassA();
        abstractClassA.templateMethod();

        System.out.println("------------");

        AbstractClass abstractClassB = new ConcreteClassB();
        abstractClassB.templateMethod();
    }

    static abstract class AbstractClass{
        protected void step1(){
            System.out.println("AbstractClass 实现：step1");
        }

        protected void step2(){
            System.out.println("AbstractClass 实现：step2");
        }

        protected void step3(){
            System.out.println("AbstractClass 实现：step3");
        }

        /**
         * 避免被子类重写
         */
        public final void templateMethod(){
            this.step1();
            this.step2();
            this.step3();
        }
    }

    static class ConcreteClassA extends AbstractClass{
        @Override
        protected void step1() {
            System.out.println("ConcreteClassA: step1");
        }
    }

    static class ConcreteClassB extends AbstractClass{
        @Override
        protected void step2() {
            System.out.println("ConcreteClassB: step2");
        }
    }
}
