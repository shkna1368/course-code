public class Khalafi {

    private int amount;
    private String location;
    private TakhalofType takhalofType;


    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public TakhalofType getTakhalofType() {
        return takhalofType;
    }

    public void setTakhalofType(TakhalofType takhalofType) {
        this.takhalofType = takhalofType;
    }

    @Override
    public String toString() {
        return "Khalafi{" +
                "amount=" + amount +
                ", location='" + location + '\'' +
                ", takhalofType=" + takhalofType +
                '}';
    }
}
