package set;



import model.Address;

import java.util.*;

public class SetMailList {
    public static void main(String[] args) {
        HashSet<Address> ml = new HashSet<>();
     Address adr1=   new Address("J.W. West", "11 Oak Ave",
                "Urbana", "IL", 1005);

        ml.add(adr1);




     boolean isAdded=   ml.add(adr1);
        ml.add(new Address("Ralph Baker", "1142 Maple Lane",
                "Mahomet", "IL", 1002));
        ml.add(new Address("Tom Carlton", "867 Elm St",
                "Champaign", "IL", 1001));
// Display the mailing list.
        for(Address element : ml)
            System.out.println(element + "\n");
        System.out.println();

        System.out.println("sorted value");
        for(Address element : ml){
            System.out.println(element + "\n");
        }



    }
}