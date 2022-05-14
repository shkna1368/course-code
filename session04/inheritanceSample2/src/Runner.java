public class Runner {
    public static void main(String[] args) {

        HourlyEmploee s1=new HourlyEmploee();
        s1.initParent("ali","ahmadi",25);
        s1.setHours(60);
        s1.getSalary();

 /*       SalariedEmploee s1=new SalariedEmploee("ali","ahmadi",25,70000);
 s1.getSalary();

        HourlyEmploee h1=new HourlyEmploee("ali","ahmadi",25,20);
        h1.getSalary();*/
    /*
        int x=2;

        Emploee s2=null;

        if(x==2)
        s2=new SalariedEmploee("ali","ahmadi",25,70000);

     else {
         s2= new HourlyEmploee("ali","ahmadi",25,20);

        }
       s2.getSalary();
        Emploee h2=new HourlyEmploee("ali","ahmadi",25,20);
        h2.getSalary();
    }*/
    }
}
