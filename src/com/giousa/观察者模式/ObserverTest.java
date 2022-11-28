package com.giousa.观察者模式;

import java.util.ArrayList;
import java.util.List;

public class ObserverTest {

    public interface Observer {
        /**声明响应方法*/
        void response();
    }


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

        /**通知观察者*/
        public abstract void notifyObserver();
    }

    public static class ConcreteSubject extends Subject{

        @Override
        public void notifyObserver() {
            System.out.println("遍历观察者：");
            for (Observer observer : observerList) {
                observer.response();
            }
        }
    }

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

    public static void main(String[] args) {
        Subject concreteSubject = new ConcreteSubject();
        //具体观察者
        Observer concreteObserver1 = new ConcreteObserver1();
        Observer concreteObserver2 = new ConcreteObserver2();
        concreteSubject.add(concreteObserver1);
        concreteSubject.add(concreteObserver2);

        concreteSubject.notifyObserver();
    }

}
