package com.giousa.中介者模式;

import java.util.ArrayList;
import java.util.List;

/**
 * 中介者模式解决问题的思路很简单，就是通过引入一个中介对象，让其他对象只与中介对象交互，
 * 而中介对象知道如何和其他所有对象的交互，这样对象之间的交互关系就没有了，从而实现了对象之间的解耦。
 *
 * 中介者模式的主要优点
 * 1、中介者模式简化了对象之间的交互，它用中介者和同事的一对多交互代替了原来同事之间的多对多交互，一对多关系更容易理解、维护和扩展，将原本难以理解的网状结构转换成相对简单的星型结构。
 *
 * 2、中介者模式可将各同事对象解耦。中介者有利于各同事之间的松耦合，我们可以独立的改变和复用每一个同事和中介者，增加新的中介者和新的同事类都比较方便，更好地符合 “开闭原则”。
 *
 * 3、可以减少子类生成，中介者将原本分布于多个对象间的行为集中在一起，改变这些行为只需生成新的中介者子类即可，这使各个同事类可被重用，无须对同事类进行扩展。
 *
 * 中介者模式的主要缺点
 * 1、在具体中介者类中包含了大量同事之间的交互细节，可能会导致具体中介者类非常复杂，使得系统难以维护。（也就是把具体同事类之间的交互复杂性集中到了中介者类中，结果中介者成了最复杂的类）
 *
 * 适用场景
 * 1、系统中对象之间存在复杂的引用关系，系统结构混乱且难以理解。
 *
 * 2、一个对象由于引用了其他很多对象并且直接和这些对象通信，导致难以复用该对象。
 *
 * 3、想通过一个中间类来封装多个类中的行为，而又不想生成太多的子类。可以通过引入中介者类来实现，在中介者中定义对象交互的公共行为，如果需要改变行为则可以增加新的具体中介者类。
 *
 * 以房屋中介功能为例，实现的功能是：
 * 租客发布租房信息到房屋中介，房屋中介将收到的信息发布给所有的房东
 * 房东发布信息到房屋中介，房屋中介将收到的信息发布给租客
 *
 * 以公司同事为例，实现的功能是：
 * 同事可以发出所有消息或任务，除本人外，其他人都可以接收到。
 */
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
