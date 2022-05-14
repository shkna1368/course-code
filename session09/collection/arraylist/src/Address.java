public class Address {

    private String name;
    private String street;
    private String city;
    private String state;
    private int code;
    Address(String n, String s, String c,
            String st, int cd) {
        name = n;
        street = s;
        city = c;
        state = st;
        code = cd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String toString() {
        return name + "\n" + street + "\n" +
                city + " " + state + " " + code;
    }

}
