package Lecture3.Reference;

public class Woo {
    public double weight;
    public double height;

    public Woo(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }

    public static void PrintWoo(Woo w) {
        w.height = 150;
        System.out.println(w.height);
    }

}
