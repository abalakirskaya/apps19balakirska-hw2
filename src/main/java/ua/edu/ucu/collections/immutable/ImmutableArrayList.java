package ua.edu.ucu.collections.immutable;

public class ImmutableArrayList implements ImmutableList{
    private int size;
    private Object[] arr;


    public ImmutableArrayList(){
        arr = new Object[0];
        size = arr.length;
    }

    public ImmutableArrayList(Object[] array){
        arr = new Object[array.length];
        size = array.length;
        System.arraycopy(array, 0, arr, 0, array.length);
    }

    @Override
    public int size(){
        return this.size;
    }

    @Override
    public boolean isEmpty(){
        return this.size == 0;
    }

    @Override
    public ImmutableList clear(){
        return new ImmutableArrayList();
    }

    @Override
    public Object[] toArray(){
        Object[] arr = new Object[this.size];
        System.arraycopy(this.arr, 0, arr, 0, this.size);
        return arr;
    }


    @Override
    public int indexOf(Object n){
        for (int i = 0; i < this.arr.length; i++){
            if (this.arr[i] == n){
                return i;
            }
        }
        return -1;
    }

    @Override
    public ImmutableList add(Object n){
        Object[] array = new Object[1];
        array[0] = n;
        return this.addAll(array);
    }

    @Override
    public ImmutableList add(int i, Object n){
        Object[] array = new Object[1];
        array[0] = n;
        return this.addAll(i, array);
    }

    @Override
    public ImmutableList addAll(Object[] n){
//        ImmutableArrayList result = new ImmutableArrayList(this.size + n.length);
        return addAll(size, n);
    }

    @Override
    public ImmutableList addAll(int i, Object[] n){
        int len;
        int first;
        int last;
        if (i > size){
            len = i + n.length;
        } else{
            len = size + n.length;
        }

        Object[] result = new Object[len];
        first = Math.min(i, size);
        last = size - first;
        System.arraycopy(arr, 0, result, 0, first);
        System.arraycopy(n, 0, result, i, n.length);
        if (last != 0){
            System.arraycopy(arr, i, result, i + n.length, last);
        }
        ImmutableArrayList result2 = new ImmutableArrayList(result);
        return result2;
    }

    @Override
    public Object get(int i){
        if (i < this.size){
            return arr[i];
        } else{
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public ImmutableList set(int i, Object n){
        if (i < this.size){
            ImmutableArrayList result = new ImmutableArrayList();
            result.arr[i] = n;
            return result;
        } else{
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public ImmutableList remove(int i){
        if (i < this.size){
            Object[] new_arr = new Object[this.arr.length - 1];
            System.arraycopy(this.arr, 0, new_arr, 0, i);
            System.arraycopy(this.arr, i + 1, new_arr, i, this.arr.length - 1 - i);
            ImmutableArrayList result = new ImmutableArrayList(new_arr);
            return result;
        } else{
            throw new IndexOutOfBoundsException();
        }
    }



    
}