package deque;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class ArrayDeque61B<T> implements Deque61B<T> {
    private T[] data;
    private int front;
    private int rear;
    private int capacity;
    private int size;
    private static final int DEFAULT_CAPACITY = 8;

    @SuppressWarnings("unchecked")
    public ArrayDeque61B() {
        capacity = DEFAULT_CAPACITY;
        data = (T[]) new Object[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }

    private boolean isFull() {
        return Math.floorMod(rear + 1, capacity) == front;
    }

    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {

        if (newCapacity <= size) {
            return;
        }

        T[] newData = (T[]) new Object[newCapacity];

        for (int i = 0; i < size; i++) {
            int toBeAddIndex = Math.floorMod(front + i, capacity);
            newData[i] = data[toBeAddIndex];
        }

        data = newData;
        front = 0;
        rear = size;
        capacity = newCapacity;
    }

    @Override
    public void addFirst(T x) {

        if (this.isFull()) {
            this.resize(2 * capacity);
        }

        int indexToAdd = Math.floorMod(front - 1, capacity);
        data[indexToAdd] = x;
        front = indexToAdd;
        size++;
    }

    @Override
    public void addLast(T x) {
        if (this.isFull()) {
            this.resize(2 * capacity);
        }

        data[rear] = x;
        rear = Math.floorMod(rear + 1, capacity);
        size++;
    }

    @Override
    public List<T> toList() {
        List<T> res = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            res.add(data[Math.floorMod(front + i, capacity)]);
        }
        return res;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        if (this.isEmpty()) {
            return null;
        }

        T toRemove = data[front];
        data[front] = null;
        front = Math.floorMod(front + 1, capacity);
        size--;

        if (capacity > DEFAULT_CAPACITY && size < capacity / 4) {
            resize(Math.max(DEFAULT_CAPACITY, capacity / 2));
        }

        return toRemove;
    }

    @Override
    public T removeLast() {
        if (this.isEmpty()) {
            return null;
        }

        int toRemoveIndex = Math.floorMod(rear - 1, capacity);
        T toRemove = data[toRemoveIndex];
        data[toRemoveIndex] = null;
        rear = toRemoveIndex;
        size--;

        if (capacity > DEFAULT_CAPACITY && size < capacity / 4) {
            resize(Math.max(DEFAULT_CAPACITY, capacity / 2));
        }

        return toRemove;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        return data[Math.floorMod(front + index, capacity)];
    }


    @Override
    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        return getRecursiveHelper(front, index);
    }

    private T getRecursiveHelper(int subIdx, int index) {
        if (index == 0) {
            return data[subIdx];
        }
        return getRecursiveHelper(Math.floorMod(subIdx + 1, capacity), index - 1);
    }

    private class ArrayDequeIterator implements Iterator<T>{
        private int index;

        public ArrayDequeIterator(){
            index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            if (this.hasNext()){
                T res = get(index);
                index++;
                return res;
            }
            throw new NoSuchElementException();
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    @Override
    public String toString() {
        return this.toList().toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ArrayDeque61B<?> otherDeque){
            if (size != otherDeque.size){
                return false;
            }

            for (int i = 0; i < this.size; i++){
                if (!this.get(i).equals(otherDeque.get(i))){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
