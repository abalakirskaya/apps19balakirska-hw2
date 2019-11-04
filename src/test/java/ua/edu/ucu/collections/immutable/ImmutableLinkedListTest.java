package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableLinkedListTest {
    private Object[] little_arr;
//    private Object[] longArray;
    private Object[] simpleArrayFirst;
    private Object[] simpleArrayLast;
    private Object[] insertedArray;
    private Object[] insertedArrayRemoved;

    @Before
    public void setUp() {
        little_arr = new Object[]{1, 2, 3};
        simpleArrayFirst = new Object[]{2,3};
        simpleArrayLast = new Object[]{1,2};
//        longArray = new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        insertedArray = new Object[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2, 3};
        insertedArrayRemoved = new Object[]{ 1, 2, 3, 5, 6, 7, 8, 9, 10, 2, 3};
    }
    @Test
    public void testGetFirst(){
        ImmutableLinkedList list = new ImmutableLinkedList(little_arr);
        Object first = list.getFirst();
        assertEquals(first, 1);
    }
    @Test
    public void testGetLast(){
        ImmutableLinkedList list = new ImmutableLinkedList(little_arr);
        Object last = list.getLast();
        assertEquals(last, 3);
    }
    @Test
    public void testRemoveFirst() {
        ImmutableLinkedList list = new ImmutableLinkedList(little_arr);
        ImmutableLinkedList result = list.removeFirst();
        assertArrayEquals(result.toArray(), simpleArrayFirst);
    }
    @Test
    public void testRemoveLast() {
        ImmutableLinkedList list = new ImmutableLinkedList(little_arr);
        ImmutableLinkedList result = list.removeLast();
        assertArrayEquals(result.toArray(), simpleArrayLast);
    }


    @Test
    public void testGet(){
        ImmutableLinkedList list = new ImmutableLinkedList(little_arr);
        Object element = list.get(2);
        assertEquals(element, 3);
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetException(){
        ImmutableLinkedList list = new ImmutableLinkedList();
        Object element = list.get(2);
    }
    @Test
    public void testIndexOf(){
        ImmutableLinkedList list = new ImmutableLinkedList(little_arr);
        int index = list.indexOf(3);
        assertEquals(index, 2);
    }
    @Test
    public void testIndexOfOutOfBounds(){
        ImmutableLinkedList list = new ImmutableLinkedList(little_arr);
        int index = list.indexOf(11);
        assertEquals(index, -1);
    }
    @Test
    public void IsEmpty(){
        ImmutableLinkedList list = new ImmutableLinkedList(little_arr);
        assertFalse(list.isEmpty());
    }
    @Test
    public void testClear(){
        ImmutableLinkedList lst = new ImmutableLinkedList(little_arr);
        lst = (ImmutableLinkedList) lst.clear();
        boolean result = lst.isEmpty();
        assertTrue(result);
    }
    @Test
    public void testSet(){
        ImmutableLinkedList list = new ImmutableLinkedList(little_arr);
        list = (ImmutableLinkedList) list.set(0, 10);
        assertEquals(list.get(0), 10);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetException(){
        ImmutableLinkedList lst = new ImmutableLinkedList(little_arr);
        lst = (ImmutableLinkedList) lst.set(30, 9);
    }

    @Test
    public void testRemove(){
        ImmutableLinkedList list = new ImmutableLinkedList(insertedArray);
        ImmutableLinkedList result = (ImmutableLinkedList) list.remove(3);
        assertArrayEquals(result.toArray(), insertedArrayRemoved);
    }
}