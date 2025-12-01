package deque;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class LinkedListDeque61B<T> implements Deque61B<T> {
    private Node head;
    private int size;

    public LinkedListDeque61B(){
        head = new Node(null, null, null);
        head.prev = head;
        head.next = head;
        size = 0;
    }

    @Override
    public void addFirst(T x) {
        Node second = head.next;
        Node newNode = new Node(x, head, second);
        head.next = newNode;
        second.prev = newNode;
        size++;
    }

    @Override
    public void addLast(T x) {
        Node firstButLast = head.prev;
        Node newNode = new Node(x, firstButLast, head);
        firstButLast.next = newNode;
        head.prev = newNode;
        size++;
    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        Node curr = head;
        for (int i = 0; i < size; i++){
            curr = curr.next;
            returnList.add(curr.elem);
        }
        return returnList;
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
        if (this.isEmpty()){
            return null;
        }
        Node toBeRemoved = head.next;
        head.next = toBeRemoved.next;
        toBeRemoved.next.prev = head;
        size--;
        return toBeRemoved.elem;
    }

    @Override
    public T removeLast() {
        if (this.isEmpty()){
            return null;
        }
        Node toBeRemoved = head.prev;
        head.prev = toBeRemoved.prev;
        toBeRemoved.prev.next = head;
        size--;
        return toBeRemoved.elem;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size){
            return null;
        }
        Node curr = head.next;
        for (int i = 0; i < index; i++){
            curr = curr.next;
        }
        return curr.elem;
    }

    @Override
    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return getRecursiveHelper(head.next, index);
    }

    private T getRecursiveHelper(Node node, int index) {
        if (index == 0) {
            return node.elem;
        }
        return getRecursiveHelper(node.next, index - 1);
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListDequeIterator();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof LinkedListDeque61B<?> otherDeque){
            if (size == otherDeque.size){
                for (int i = 0; i < size; i++){
                    if (!this.get(i).equals(otherDeque.get(i))){
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return this.toList().toString();
    }

    private class Node{
        T elem;
        Node prev;
        Node next;

        Node(T elem, Node prev, Node next){
            this.elem = elem;
            this.prev = prev;
            this.next = next;
        }
    }

    private class LinkedListDequeIterator implements Iterator<T>{

        private int index;
        private Node currNode;

        public LinkedListDequeIterator(){
            index = 0;
            currNode = head.next;
        }

        @Override
        public boolean hasNext() {
            return index < size();
        }

        @Override
        public T next() {
            if (this.hasNext()){
                T res = currNode.elem;
                currNode = currNode.next;
                index++;
                return res;
            }
            throw new NoSuchElementException();
        }
    }
}
