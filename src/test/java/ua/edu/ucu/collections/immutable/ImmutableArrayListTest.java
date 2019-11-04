package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImmutableArrayListTest {
    private Object[] little_arr;
    private Object[] added_little_arr;
    private Object[] removed_little_arr;

    @Before
    public void initialization() {
        little_arr = new Object[]{1, 2, 3};
        removed_little_arr = new Object[]{1, 3};
        added_little_arr = new Object[]{1, 2, 3, 4};
    }
    @Test
    public void testMakeEmpty(){
        ImmutableArrayList array = new ImmutableArrayList();
        assertTrue(array.isEmpty());
    }


    @Test
    public void testRemove() {
        ImmutableArrayList array = new ImmutableArrayList(little_arr);
        ImmutableArrayList result = (ImmutableArrayList) array.remove(1);
        assertArrayEquals(result.toArray(), removed_little_arr);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveException() {
        ImmutableArrayList array = new ImmutableArrayList(little_arr);
        ImmutableArrayList result = (ImmutableArrayList) array.remove(15);
    }

    @Test
    public void testAddIndex() {
        ImmutableArrayList array = new ImmutableArrayList(removed_little_arr);
        ImmutableArrayList result = (ImmutableArrayList) array.add(1, 2);
        assertArrayEquals(result.toArray(), little_arr);
    }

    @Test
    public void testAdd() {
        ImmutableArrayList array = new ImmutableArrayList(little_arr);
        ImmutableArrayList result = (ImmutableArrayList) array.add(4);
        assertArrayEquals(result.toArray(), added_little_arr);
    }
    @Test
    public  void testIsEmptyFalse(){
        ImmutableArrayList array = new ImmutableArrayList(little_arr);
        assertFalse(array.isEmpty());
    }
    @Test
    public  void testIsEmptyTrue(){
        ImmutableArrayList array = new ImmutableArrayList(new Object[]{});
        assertTrue(array.isEmpty());
    }
    @Test
    public void testClear(){
        ImmutableArrayList array = new ImmutableArrayList(little_arr);
        ImmutableArrayList result = (ImmutableArrayList) array.clear();
        assertTrue(result.isEmpty());
    }
    @Test
    public void testSize(){
        ImmutableArrayList array = new ImmutableArrayList(little_arr);
        assertEquals(array.size(), 3);
    }
    @Test
    public void testSizeAfterInsertion(){
        ImmutableArrayList array = new ImmutableArrayList(little_arr);
        ImmutableArrayList result = (ImmutableArrayList) array.add(5);
        assertEquals(result.size(), 4);
    }
    @Test
    public void testGet(){
        ImmutableArrayList array = new ImmutableArrayList(little_arr);
        Object result = array.get(0);
        assertEquals(result, 1);
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetException(){
        ImmutableArrayList array = new ImmutableArrayList(little_arr);
        Object result = array.get(5);
    }
//    @Test
//    public void testSet(){
//        ImmutableArrayList array = new ImmutableArrayList(little_arr);
//        ImmutableArrayList result = (ImmutableArrayList) array.set(0, 2);
//        assertEquals(result.get(0), 2);
//    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetException(){
        ImmutableArrayList array = new ImmutableArrayList(little_arr);
        ImmutableArrayList result = (ImmutableArrayList) array.set(5, 4);
    }
    @Test
    public void testIndexOf(){
        ImmutableArrayList array = new ImmutableArrayList(little_arr);
        int index = array.indexOf(1);
        assertEquals(index, 0);
    }
    @Test
    public void testFalseIndex(){
        ImmutableArrayList array = new ImmutableArrayList(little_arr);
        int index = array.indexOf(7);
        assertEquals(index, -1);
    }
    @Test
    public void testToArray() {
        ImmutableArrayList array = new ImmutableArrayList(new Object[]{});
        ImmutableArrayList result = (ImmutableArrayList) array.addAll(0, little_arr);
        assertArrayEquals(result.toArray(), little_arr);
    }

}