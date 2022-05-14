public class Runner {

    public static void main(String[] args) {
        Person joe = new Person("Joe", "Portman");
        Person joeAgain = new Person("Joe", "Portman");

        System.out.println(joe.equals(joeAgain));
        System.out.println(joe==joeAgain);

        System.out.println(joe.hashCode());
        System.out.println(joeAgain.hashCode());

     ///////////////////////////


    }
}
