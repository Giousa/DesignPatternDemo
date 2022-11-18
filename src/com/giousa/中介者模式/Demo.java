package com.giousa.中介者模式;

import java.util.ArrayList;
import java.util.List;

public class Demo {

    /**
     * 中介者抽象类
     */
    public static abstract class Mediator {

        /**
         * 注册同事类
         */
        public abstract void register(Colleague colleague);

        /**
         * 处理接收逻辑
         */
        public abstract void operation(Colleague colleague);
    }

    /**
     * 具体中介者类
     */
    public static class ConcreteMediator extends Mediator {

        private List<Colleague> colleagues = new ArrayList<>();

        @Override
        public void register(Colleague colleague) {
            if (!colleagues.contains(colleague)) {
                colleagues.add(colleague);
                colleague.setMediator(this);
            }
        }

        @Override
        public void operation(Colleague colleague) {
            for (Colleague coll : colleagues) {
                if (!coll.equals(colleague)) {
                    coll.receive();
                }
            }
        }
    }


    /**
     * 抽象同事类
     */
    public static abstract class Colleague {

        protected Mediator mediator;

        public void setMediator(Mediator mediator) {
            this.mediator = mediator;
        }

        public abstract void receive();

        public abstract void send();
    }

    /**
     * 具体同事类1
     */
    public static class ConcreteColleague1 extends Colleague {

        @Override
        public void receive() {
            System.out.println("具体同事类 ConcreteColleague1 接收请求");
        }

        @Override
        public void send() {
            System.out.println("具体同事类 ConcreteColleague1 发送请求");
            /*中介者进行转发*/
            mediator.operation(this);
        }
    }

    /**
     * 具体同事类2
     */
    public static class ConcreteColleague2 extends Colleague {

        @Override
        public void receive() {
            System.out.println("具体同事类 ConcreteColleague2 接收到请求");
        }

        @Override
        public void send() {
            System.out.println("具体同事类 ConcreteColleague2 发送请求");
            mediator.operation(this);
        }
    }


    public static void main(String[] args) {
        Mediator concreteMediator = new ConcreteMediator();
        Colleague concreteColleague1 = new ConcreteColleague1();
        Colleague concreteColleague2 = new ConcreteColleague2();
        concreteMediator.register(concreteColleague1);
        concreteMediator.register(concreteColleague2);
        concreteColleague1.send();
        concreteColleague2.send();

    }

}
