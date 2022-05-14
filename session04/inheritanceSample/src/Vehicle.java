public class Vehicle {

    private String model;
    private String make;
    private int year;

    public Vehicle(String model, String make, int year) {

        System.out.println("V constructor");
        this.model = model;
        this.make = make;
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public String getMake() {
        return make;
    }

    public int getYear() {
        return year;
    }
    void describe()
    {
        System.out.println(year + " " + make + " " + model);
    }
}
