package Lecture3.Lists;

public class IntList {
    public IntNode head;
    public int size;

    public IntList() {
        head = null;
        size = 0;
    }

    public IntList(int first, IntList rest) {
        head = new IntNode();
        head.value = first;
        head.next = rest.head;
        size++;
    }

    public void AppendBefore(int first) {
        IntNode rest = head;
        head = new IntNode();
        head.value = first;
        head.next = rest;
        size++;
    }

    public void PrintList() {
        IntNode curr = head;
        while (curr != null) {
            System.out.printf("%d ", curr.value);
            curr = curr.next;
        }
    }
}
