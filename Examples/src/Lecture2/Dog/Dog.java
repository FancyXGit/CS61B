package Lecture2.Dog;

public class Dog {

    public String type;

    public Dog(String type){
        this.type = type;
    }

    public void Bark(){
        System.out.println(type + " dog is barking");
    }
}
