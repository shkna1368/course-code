package samone;

public class Dog extends Animal {
    private String color;
    public Dog() {

    }

    // private constructor with a single parameter
    private Dog(String color) {

    }
    public void display() {
        System.out.println("I am a dog.");
    }
    private void makeSound() {
        System.out.println("Bark Bark");
    }
    protected String print(String msg) {
        System.out.println(msg);
        return msg;
    }
}