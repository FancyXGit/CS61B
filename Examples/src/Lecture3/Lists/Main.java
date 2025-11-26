package Lecture3.Lists;

public class Main {
    public static void main(String[] args) {
        IntList l1 = new IntList();
        l1.AppendBefore(10);
        l1.AppendBefore(20);
        l1.AppendBefore(30);
        l1.AppendBefore(40);
        l1.PrintList();
        System.out.println(l1.size);
    }
}
