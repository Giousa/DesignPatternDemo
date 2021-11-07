package com.giousa.委派模式;

import java.util.Random;

public class Client {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Delegate().doTask();
        }
    }

    interface Task {
        void doTask();
    }

    static class ConcreteA implements Task {

        @Override
        public void doTask() {
            System.out.println("A  实现");
        }
    }

    static class ConcreteB implements Task {

        @Override
        public void doTask() {
            System.out.println("B  实现");
        }
    }

    static class Delegate implements Task {

        @Override
        public void doTask() {
            System.out.println("委托代理开始：");
            Task task = null;
            if (new Random().nextBoolean()) {
                task = new ConcreteA();
            } else {
                task = new ConcreteB();
            }
            task.doTask();

            System.out.println("委托代理执行完毕！");
        }
    }
}
