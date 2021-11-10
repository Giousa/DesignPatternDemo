package com.giousa.观察者模式;

import java.util.ArrayList;
import java.util.List;

public class Client {

    public static void main(String[] args) {
        ConcreteSubbject<String> subbject = new ConcreteSubbject<>();

        ConcreteObserver<String> observer1 = new ConcreteObserver<>();
        ConcreteObserver<String> observer2 = new ConcreteObserver<>();
        ConcreteObserver<String> observer3 = new ConcreteObserver<>();

        subbject.attach(observer1);
        subbject.attach(observer2);
        subbject.attach(observer3);

        subbject.notify("更新了哦");


    }

    public interface IObserver<E> {
        void update(E event);
    }

    public interface ISubject<E> {
        boolean attach(IObserver<E> observer);

        boolean detach(IObserver<E> observer);

        void notify(E event);
    }

    static class ConcreteObserver<E> implements IObserver<E> {

        @Override
        public void update(E event) {
            System.out.println("update event: " + event);
        }
    }

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
}
