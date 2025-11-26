package Lecture5.DLLists;

public class IntNode {
    public int item;
    public IntNode next;
    public IntNode prev;

    public IntNode(int i, IntNode p, IntNode n) {
        this.item = i;
        this.prev = p;
        this.next = n;
    }
}
