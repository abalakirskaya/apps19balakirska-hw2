package ua.edu.ucu.collections.immutable;


public class ImmutableLinkedList implements ImmutableList {
    private Node head;
    private Node tail;
    private int size;

    public ImmutableLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }
    public ImmutableLinkedList(Object[] arr){
        Node [] elements = make_nodes(arr);
        head = elements[0];
        tail = elements[elements.length - 1];
        size = elements.length;
    }


    public ImmutableLinkedList(ImmutableLinkedList linked_lst){
        head = new Node(linked_lst.head);
        Node our_node = linked_lst.head.next;
        Node prev = head;
        Node new_node = null;
        while(our_node.next != null){
            new_node = new Node(our_node);
            prev.next = new_node;
            new_node.prev = prev;
            prev = new_node;
            our_node = our_node.next;
        }
        size = linked_lst.size();
        tail = new Node(our_node);
        tail.prev = prev;
    }


    private Node[] make_nodes(Object[] arr){
        Node[] elements = new Node[arr.length];
        for (int i = 0; i < arr.length; i++){
            elements[i] = new Node(arr[i]);
            if (i - 1 >= 0){
                elements[i - 1].setNext(elements[i]);
            }
        }
        return elements;
    }

    public Object getFirst(){
        if (head != null){
            return head.key;
        } else{
            return null;
        }
    }

    public Object getLast(){
        if (tail != null){
            return tail.key;
        } else{
            return null;
        }
    }

    public ImmutableLinkedList addFirst(Object n){
        return (ImmutableLinkedList) add(0, n);
    }

    public ImmutableLinkedList addLast(Object n){
        return (ImmutableLinkedList) add(n);
    }

    public ImmutableLinkedList removeFirst(){
        ImmutableLinkedList linked_lst = new ImmutableLinkedList(this);
        linked_lst.head = linked_lst.head.next;
        linked_lst.head.prev = null;
        linked_lst.size--;
        return linked_lst;
    }


    public ImmutableLinkedList removeLast(){
        ImmutableLinkedList linked_lst = new ImmutableLinkedList(this);
        linked_lst.tail = linked_lst.tail.prev;
        linked_lst.tail.next = null;
        linked_lst.size--;
        return linked_lst;
    }

    @Override
    public ImmutableList remove(int i){
        if (i < size()){
            ImmutableLinkedList linked_list = new ImmutableLinkedList(this);
            Node our_node = linked_list.getNode(i);
            Node prev = our_node.prev;
            Node next = our_node.next;
            prev.next = next;
            next.prev = prev;
            linked_list.size--;
            return linked_list;
        }
        else{
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public ImmutableList add(Object n){
        return add(size(), n);
    }

    @Override
    public ImmutableList add(int i, Object n){
        Object[] arr = new Object[1];
        arr[0] = n;
        return addAll(i, arr);
    }

    @Override
    public ImmutableList addAll(Object[] n){
        return addAll(size(), n);
    }


    @Override
    public ImmutableList addAll(int i, Object[] n){
        if (i <= this.size){
            ImmutableLinkedList linked_list = new ImmutableLinkedList(this);
            Node [] elements = new Node[n.length];
            for (int k = 0; k < n.length; i++){
                elements[k] = new Node(n[k]);
                if (k - 1 >=0){
                    elements[k - 1].next = elements[i];
                }
            }
            if (i + n.length < linked_list.size){
                Node result = linked_list.getNode(i + n.length - 1);
                result.prev = elements[elements.length - 1];
            }
            if (i != 0){
                Node first = linked_list.getNode(i - 1);
                first.next = elements[0];
                elements[0].prev = first;
            } else{
                elements[elements.length - 1].next = linked_list.head;
            }
            linked_list.size += n.length;
            return linked_list;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public ImmutableList set(int i, Object n){
        if (i >= size()){
            throw new IndexOutOfBoundsException();
        } else{
            ImmutableLinkedList linked_list = new ImmutableLinkedList(this);
            Node our_node = linked_list.getNode(i);
            our_node.key = n;
            return linked_list;
        }
    }

    @Override
    public Object get(int i){
        if (i >= this.size()){
            throw new IndexOutOfBoundsException();
        } else{
            int curr = 0;
            Node our_node = this.head;
            while (i != curr){
                our_node = our_node.next;
                curr++;
            }
            return our_node.key;
        }
    }

    private Node getNode(int i){
        if (i >= this.size()){
            throw new IndexOutOfBoundsException();
        } else{
            int curr = 0;
            Node our_node = this.head;
            while(i != curr){
                our_node = our_node.next;
                curr++;
            }
            return our_node;
        }
    }
    @Override
    public int indexOf(Object n){
        int i = 0;
        Node our_node = this.head;
        while( this.size() != i){
            if(our_node.key == n){
                return i;
            } else{
                i++;
                our_node = our_node.next;
            }
        }
        if(i == this.size()){
            i = -1;
        }
        return i;
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public ImmutableList clear(){
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty(){
        return size() == 0;
    }

    @Override
    public Object[] toArray(){
        int i = 0;
        Object[] arr = new Object[size()];
        Node our_node = head;
        while(our_node != null){
            arr[i] = our_node.key;
            i++;
            our_node = our_node.next;
        }
        return arr;
    }
}
