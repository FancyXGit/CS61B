package Lecture5.DLLists;

public class DLList {
    private IntNode head;
    private IntNode tail;
    private int size;

    public DLList() {
        head = new IntNode(0, null, null);
        tail = head;
        size = 0;
    }

    public void Append(int val) {
        IntNode new_node = new IntNode(val, tail, null);
        tail.next = new_node;
        tail = new_node;
        size++;

    }

    public boolean isEmpty() {
        return head.next == null;
    }

    public void Print() {
        if (this.isEmpty()) {
            System.out.println("Empty List");
            return;
        }

        IntNode curr = head.next;
        while (curr != null) {
            System.out.printf("%d ", curr.item);
            curr = curr.next;
        }
    }

    public int getSize() {
        return size;
    }
}
