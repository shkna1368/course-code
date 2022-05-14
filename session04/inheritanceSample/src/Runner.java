public class Runner {
    public static void main(String[] args) {
        Car car=new Car("Ferari","XBand",1998,4);
        System.out.println("model="+car.getModel());
        System.out.println("make="+car.getMake());
        System.out.println("numWhell="+car.getNumWheels());

        car.describe();
    }
}
