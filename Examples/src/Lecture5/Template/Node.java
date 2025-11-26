package Lecture5.Template;

public class Node<ElemType> {
    public ElemType item;
    public Node<ElemType> next;
    public Node<ElemType> prev;

    public Node(ElemType i, Node<ElemType> p, Node<ElemType> n) {
        this.item = i;
        this.prev = p;
        this.next = n;
    }
}
