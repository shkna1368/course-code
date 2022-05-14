public class GenDemo {
    public static void main(String[] args) {
// Create a Gen reference for Integers.
        Gen<Integer> iOb= new Gen<Integer>(88);
// Show the type of data used by iOb.
        iOb.showType();
// Get the value in iOb. Notice that
// no cast is needed.
        int v = iOb.getOb();
        System.out.println("value: " + v);
        System.out.println();


        System.out.println("---------------");


        // Create a Gen object for Strings.
        Gen<String> strOb = new Gen<String> ("Generics Test");
// Show the type of data used by strOb.
        strOb.showType();
// Get the value of strOb. Again, notice
// that no cast is needed.
        String str = strOb.getOb();
        System.out.println("value: " + str);


    }
}
