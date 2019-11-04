package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList lst;

    public Stack() {
        lst = new ImmutableLinkedList();
    }

    public Object peek() {
        return lst.getFirst();
    }

    public Object pop() {
        Object n = lst.getFirst();
        lst = lst.removeFirst();
        return n;
    }

    public void push(Object n) {
        lst = lst.addFirst(n);
    }


}