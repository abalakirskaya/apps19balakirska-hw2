package ua.edu.ucu.collections.immutable;

final class Node  {
    public Object key;
    public Node next;
    public Node prev;

    public Object getValue() {
        return key;
    }

    public void setValue(Object key) {
        this.key = key;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrevious() {
        return prev;
    }

    public void setPrevious(Node prev) {
        this.prev = prev;
    }


    Node(Object key) {
        this.key = key;
    }

    Node(Node node) {
        key = node.key;
        next = node.next;
        prev = node.prev;
    }
}