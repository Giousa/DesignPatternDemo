package com.giousa.委派模式;

import java.util.Random;

/**
 * 1. 委派模式的优点
 * （1）委派模式通过委派者，将具体任务的实现隐藏，外部调用者不用关心其内部的具体实现，提供外部调用的统一处理接口，易于扩展，简化调用。
 * （2）通过任务委派能够将一个大型的任务细化，然后通过统一管理这些子"任务的完成情况实现任务的跟进，能够加快任务执行的效率。
 * 2. 委派模式的缺点
 * （1）委派者模式的使用将会使用更多的类，代码量会变大。对于理解委派者内部的业务逻辑造成学习的困难，
 * （2）任务委派方式需要根据任务的复杂程度进行不同的改变，在任务比较复杂的情况下可能需要进行多重委派，容易造成紊乱。
 * 4.2 模式适用环境
 * 在以下情况下可以使用委派模式：
 * （1）在设计系统时，需要用一个对象统一处理请求，并需要将请求分发到具体的请求处理类上。
 * （2）让客户端能够忽略不同对象具体任务的执行逻辑，客户端可以针对委派者进行编程，无需关心具体任务的实现细节。
 * （3）需要根据不同的使用环境，对具体任务进行不同方式的处理，根据传入的环境参数，动态的选择具体的操作逻辑。
 */
public class Client {

    /**
     * 抽象任务角色
     */
    interface Task {
        void doTask();
    }

    /**
     * 委派者角色-A
     */
    static class ConcreteA implements Task {

        @Override
        public void doTask() {
            System.out.println("A  实现");
        }
    }

    /**
     * 委派者角色-B
     */
    static class ConcreteB implements Task {

        @Override
        public void doTask() {
            System.out.println("B  实现");
        }
    }

    /**
     * 具体任务角色
     */
    static class Delegate implements Task {

        @Override
        public void doTask() {
            System.out.println("委托代理开始：");
            Task task;
            if (new Random().nextBoolean()) {
                task = new ConcreteA();
            } else {
                task = new ConcreteB();
            }
            task.doTask();

            System.out.println("委托代理执行完毕！");
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Delegate().doTask();
        }
    }
}
