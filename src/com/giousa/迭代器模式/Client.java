package com.giousa.迭代器模式;

import java.util.ArrayList;
import java.util.List;

/**
 * 定义
 * 提供一种方法顺序访问一个容器对象中的各个元素，而又不需要暴露该对象的内部表示。
 *
 * 使用场景
 * 在java开发中，当你要你要实现自己的容器类，且要迭代里面的元素时。换句话还可以说，当你要使自己的类支持foreach操作的时候使用此模式。
 */
public class Client {

    /**
     * 抽象迭代器
     */
    interface Iterator<E> {

        E next();

        boolean hasNext();
    }

    /**
     * 抽象容器
     */
    interface IAggregate<E> {

        boolean add(E element);

        boolean remove(E element);

        Iterator<E> iterator();
    }

    /**
     * 具体迭代器
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

    /**
     * 测试
     */
    public static void main(String[] args) {
        ConcreteAggregate<String> aggregate = new ConcreteAggregate<>();
        aggregate.add("AA");
        aggregate.add("BB");
        aggregate.add("CC");

        Iterator<String> iterator = aggregate.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
