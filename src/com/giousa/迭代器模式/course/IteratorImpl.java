package com.giousa.迭代器模式.course;

import java.util.List;

public class IteratorImpl<E> implements Iterator<E> {

    private List<E> list;

    private int cursor;

    private E element;

    public IteratorImpl(List list) {
        this.list = list;
    }

    @Override
    public E next() {
        System.out.println("当前位置：" + cursor);
        element = list.get(cursor);
        cursor++;
        return element;
    }

    @Override
    public boolean hasNext() {
        if (cursor > list.size() - 1) {
            return false;
        }
        return true;
    }
}
