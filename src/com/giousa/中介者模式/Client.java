package com.giousa.中介者模式;

public class Client {

    public static void main(String[] args) {
        ConcreteMediator concreteMediator = new ConcreteMediator();

        ConcreteColleagueA concreteColleagueA = new ConcreteColleagueA(concreteMediator);
        ConcreteColleagueB concreteColleagueB = new ConcreteColleagueB(concreteMediator);

        concreteColleagueA.sefMethodA();
        System.out.println("-------------");
        concreteColleagueA.depMethodA2B();
    }

    /**
     * 抽象中介者
     */
    static abstract class Mediator {
        protected ConcreteColleagueA colleagueA;
        protected ConcreteColleagueB colleagueB;

        public void setColleagueA(ConcreteColleagueA colleagueA) {
            this.colleagueA = colleagueA;
        }

        public void setColleagueB(ConcreteColleagueB colleagueB) {
            this.colleagueB = colleagueB;
        }

        //中介者业务逻辑
        public abstract void transferA2B();

        public abstract void transferB2A();
    }

    static class ConcreteMediator extends Mediator {

        @Override
        public void transferA2B() {
            //协调行为，A转发给B
            this.colleagueB.sefMethodB();
        }

        @Override
        public void transferB2A() {
            //协调行为，B转发给A
            this.colleagueA.sefMethodA();
        }
    }

    /**
     * 参与类
     */
    static abstract class Colleague {

        protected Mediator mediator;

        public Colleague(Mediator mediator) {
            this.mediator = mediator;
        }
    }

    static class ConcreteColleagueA extends Colleague {

        public ConcreteColleagueA(Mediator mediator) {
            super(mediator);
            this.mediator.setColleagueA(this);
        }

        //自己处理
        public void sefMethodA() {
            System.out.println(this.getClass().getSimpleName() + ",sefMethodA");
        }

        //转发中介者
        public void depMethodA2B() {
            System.out.println(this.getClass().getSimpleName() + ",depMethodA2B");
            this.mediator.transferA2B();
        }
    }

    static class ConcreteColleagueB extends Colleague {

        public ConcreteColleagueB(Mediator mediator) {
            super(mediator);
            this.mediator.setColleagueB(this);
        }

        //自己处理
        public void sefMethodB() {
            System.out.println(this.getClass().getSimpleName() + ",sefMethodB");
        }

        //转发中介者
        public void depMethodB2A() {
            System.out.println(this.getClass().getSimpleName() + ",depMethodB2A");
            this.mediator.transferB2A();
        }
    }
}
