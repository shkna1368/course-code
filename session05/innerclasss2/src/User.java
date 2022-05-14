public class User {

    private String name;
    private String family;
    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", address=" + address +
                '}';
    }
    private class Address {
        private String detail;
        private String street;

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        @Override
        public String toString() {
            return "Address{" +
                    "detail='" + detail + '\'' +
                    ", street='" + street + '\'' +
                    '}';
        }
    }
}
