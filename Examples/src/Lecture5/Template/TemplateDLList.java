package Lecture5.Template;

public class TemplateDLList<ElemType> {
    private Node<ElemType> head;
    private Node<ElemType> tail;
    private int size;

    public TemplateDLList() {
        head = new Node<>(null, null, null);
        tail = head;
        size = 0;
    }

    public void Append(ElemType val) {
        Node<ElemType> newNode = new Node<>(val, tail, null);
        tail.next = newNode;
        tail = newNode;
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

        Node<ElemType> curr = head.next;
        while (curr != null) {
            System.out.print(curr.item);
            System.out.print(" ");
            curr = curr.next;
        }
        System.out.println();
    }

    public int getSize() {
        return size;
    }
}
