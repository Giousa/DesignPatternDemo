package com.giousa.观察者模式;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式是一个非常常用且影响巨大的设计模式，又称为发布-订阅模式。
 *
 * 定义
 * 定义对象间的一种一对多的依赖关系，当一个对象的状态发生改变时，所有依赖于它的对象都可以得到通知并自动更新。
 *
 * Subject
 * 被观察者，有时也叫Observable，其是一个接口，定义了观察者如何订阅与取消订阅的方法，以及当状态发生变化时的通知方法
 *
 * ConcreteSunject
 * 实现Subject，持有Observer的集合
 *
 * Observer
 * 观察者，也是一个接口。定义了如何接收事件通知的方法。
 *
 * ConcreteObserver
 * 观察者实现类
 */
public class Client {

    /**
     * 观察者，或者叫订阅者
     * 先定义一个观察者接口，里面只有一个方法，观察者就是在这个方法里面接收被观察者发送的状态改变通知。
     */
    public interface IObserver<E> {
        void update(E event);
    }

    /**
     * 被观察者，或者叫订阅主题
     */
    public interface ISubject<E> {
        boolean attach(IObserver<E> observer);

        boolean detach(IObserver<E> observer);

        void notify(E event);
    }

    /**
     * 具体观察者
     */
    static class ConcreteObserver<E> implements IObserver<E> {

        @Override
        public void update(E event) {
            System.out.println("update event: " + event);
        }
    }

    /**
     * 具体的被观察者
     */
    static class ConcreteSubbject<E> implements ISubject<E> {

        private List<IObserver<E>> observerList = new ArrayList<>();

        @Override
        public boolean attach(IObserver<E> observer) {
            return !observerList.contains(observer) && observerList.add(observer);
        }

        @Override
        public boolean detach(IObserver<E> observer) {
            return observerList.remove(observer);
        }

        @Override
        public void notify(E event) {
            for (IObserver observer : observerList) {
                observer.update(event);
            }
        }
    }


    /**
     * 测试
     */
    public static void main(String[] args) {
        //被观察者
        ConcreteSubbject<String> subbject = new ConcreteSubbject<>();

        //观察者集合
        ConcreteObserver<String> observer1 = new ConcreteObserver<>();
        ConcreteObserver<String> observer2 = new ConcreteObserver<>();
        ConcreteObserver<String> observer3 = new ConcreteObserver<>();
        subbject.attach(observer1);
        subbject.attach(observer2);
        subbject.attach(observer3);

        //被观察者，发布通知
        subbject.notify("更新了哦");
    }
}
