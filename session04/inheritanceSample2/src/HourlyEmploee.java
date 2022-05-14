public class HourlyEmploee extends  Emploee{
int hours;

public void initParent(String name,String family,int age){

    super.setAge(age);
    super.setName(name);
    super.setFamily(family);




}

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    public void getSalary() {
        System.out.println("Hourly emploee"+hours*5000);

    }
}
