package com.giousa.观察者模式;

import java.util.ArrayList;
import java.util.List;

public class ObserverTest {


    /**
     * 观察者，或者叫订阅者
     * 先定义一个观察者接口，里面只有一个方法，观察者就是在这个方法里面接收被观察者发送的状态改变通知。
     */
    public interface Observer {
        //声明响应方法
        void response();
    }

    /**
     * 被观察者，或者叫订阅主题
     */
    public static abstract class Subject {

        protected List<Observer> observerList = new ArrayList<Observer>();

        /**
         * 增加观察者
         * @param observer 观察者
         */
        public void add(Observer observer) {
            observerList.add(observer);
        }

        /**
         * 注销观察者，从观察者集合中删除一个观察者
         * @param observer 观察者
         */
        public void remove(Observer observer) {
            observerList.remove(observer);
        }

        /**
         * 通知观察者
         */
        public abstract void notifyObserver();
    }

    /**
     * 具体被观察者
     */
    public static class ConcreteSubject extends Subject{

        @Override
        public void notifyObserver() {
            System.out.println("遍历观察者：");
            for (Observer observer : observerList) {
                observer.response();
            }
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // 观察者
    ///////////////////////////////////////////////////////////////////////////
    public static class ConcreteObserver1 implements Observer{

        @Override
        public void response() {
            System.out.println("我是具体观察者ConcreteObserver1");
        }
    }

    public static class ConcreteObserver2 implements Observer{

        @Override
        public void response() {
            System.out.println("我是具体观察者ConcreteObserver2");
        }
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        Subject concreteSubject = new ConcreteSubject();
        //具体观察者
        Observer concreteObserver1 = new ConcreteObserver1();
        Observer concreteObserver2 = new ConcreteObserver2();
        concreteSubject.add(concreteObserver1);
        concreteSubject.add(concreteObserver2);

        //被观察者发出通知
        concreteSubject.notifyObserver();
    }

}
