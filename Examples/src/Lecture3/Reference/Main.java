package Lecture3.Reference;

public class Main {
    public static void main(String[] args) {
        Woo w1 = new Woo(200, 100);
        System.out.println(w1.height);
        Woo.PrintWoo(w1);
        System.out.println(w1.height);

    }
    

}
