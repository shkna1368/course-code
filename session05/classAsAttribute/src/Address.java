public class Address {
    private int plak;
    private String  streetName;

    public int getPlak() {
        return plak;
    }

    public void setPlak(int plak) {
        this.plak = plak;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    @Override
    public String toString() {
        return "Address{" +
                "plak=" + plak +
                ", streetName='" + streetName + '\'' +
                '}';
    }

    public final void print(){
        System.out.println("hi");

    }
}
