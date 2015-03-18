package com.fanhl.util;

import java.util.ArrayList;


/**
 * 一个ArrayList,并且每个元素都有一个prev(),next()方法用于取它的前后方法
 *
 * @param <E> 实现Nodeable接口的类型
 *            Created by fanhl on 15/1/5.
 */
public class NodeList<E extends NodeList.Nodeable> extends ArrayList<E> {

    @Override
    public boolean add(E object) {
        if (getLast() != null) {
            getLast().setNext(object);
            object.setPrev(getLast());
        }

        return super.add(object);
    }

    @Override
    public E remove(int index) {
        if (index >= size()) {
            throw new IndexOutOfBoundsException("Invalid index " + index + ", size is " + size());
        }

        E current = get(index);

        //前后都为空时不处理
        if (current.getPrev() != null && current.getNext() != null) {
            current.getPrev().setNext(current.getNext());
            current.getNext().setPrev(current.getPrev());
        } else if (current.getPrev() == null && current.getNext() != null) {
            current.getNext().setPrev(null);
        } else if (current.getPrev() != null && current.getNext() == null) {
            current.getPrev().setNext(null);
        }


        return super.remove(index);
    }

    public E getLast() {
        return size() == 0 ? null : get(size() - 1);
    }

    /**
     * @param <T> 此处为实现这个接口的类 如: class ClassA implements Nodeable<ClassA>{...}
     */
    public static interface Nodeable<T extends Nodeable> {

//        T prev, next;//实现类要实现这个

        T getPrev();

        void setPrev(T t);

        T getNext();

        void setNext(T t);
    }
}
