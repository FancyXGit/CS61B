package Lecture4.Lists;

public class SLList {
    private IntNode head;

    public SLList() {
        head = new IntNode(0, null);
    }

    public void Append(int value) {

        IntNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = new IntNode(value, null);

    }

    public boolean IsEmpty() {
        return head.next == null;
    }

    public void PrintList() {
        if (this.IsEmpty()) {
            System.out.println("空列表");
            return;
        }
        IntNode curr = head.next;
        while (curr != null) {
            System.out.printf("%d ", curr.item);
            curr = curr.next;
        }
    }
}
