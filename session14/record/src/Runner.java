public class Runner
    {
        public static void main(String[] args) {
            Employee emp = new Employee("Doe, John", 1047);
            System.out.println("The employee ID for " + emp.name() + " is " +
                    emp.idNum());
        }
}
