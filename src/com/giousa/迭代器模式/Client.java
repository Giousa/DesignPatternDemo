package com.giousa.迭代器模式;

import java.util.ArrayList;
import java.util.List;

public class Client {

    public static void main(String[] args) {
        ConcreteAggregate<String> aggregate = new ConcreteAggregate<>();

        aggregate.add("AA");
        aggregate.add("BB");
        aggregate.add("CC");

        Iterator<String> iterator = aggregate.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    /**
     * 抽象迭代器
     *
     * @param <E>
     */
    interface Iterator<E> {

        E next();

        boolean hasNext();
    }

    /**
     * 抽象容器
     *
     * @param <E>
     */
    interface IAggregate<E> {

        boolean add(E element);

        boolean remove(E element);

        Iterator<E> iterator();
    }

    /**
     * 具体迭代器
     *
     * @param <E>
     */
    static class ConcreteIterator<E> implements Iterator<E> {
        private List<E> list;

        private int cursor = 0;

        public ConcreteIterator(List<E> list) {
            this.list = list;
        }

        @Override
        public E next() {
            return this.list.get(this.cursor++);
        }

        @Override
        public boolean hasNext() {
            return this.cursor < this.list.size();
        }
    }

    /**
     * 具体容器
     *
     * @param <E>
     */
    static class ConcreteAggregate<E> implements IAggregate<E> {

        private List<E> list = new ArrayList<>();

        @Override
        public boolean add(E element) {
            return this.list.add(element);
        }

        @Override
        public boolean remove(E element) {
            return this.list.remove(element);
        }

        @Override
        public Iterator<E> iterator() {
            return new ConcreteIterator<>(this.list);
        }
    }
}
