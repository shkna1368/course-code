public class Car extends Vehicle{
    private int numWheels;

    public Car(String model, String make, int year,int numWheels) {
        super(model, make, year);

        System.out.println("C constructor");

        this.numWheels=numWheels;
    }

    public int getNumWheels() {
        return numWheels;
    }

    void describe() {
        System.out.print("This car is a "); // Print without newline – see Chapter 1.
        super.describe();
    }
}
