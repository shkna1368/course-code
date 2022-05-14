package list;

import model.Address;

import java.util.ArrayList;
import java.util.Collections;



public class MailList {
    public static void main(String[] args) {
      ArrayList<Address> ml = new ArrayList<>();
// Add elements to the linked list.

        Address adr1=   new Address("J.W. West", "11 Oak Ave",
                "Urbana", "IL", 1005);

        ml.add(adr1);


        ml.add(new Address("Ralph Baker", "1142 Maple Lane",
                "Mahomet", "IL", 1002));
        ml.add(new Address("Tom Carlton", "867 Elm St",
                "Champaign", "IL", 1001));
// Display the mailing list.
        for(Address element : ml)
            System.out.println(element + "\n");
        System.out.println();

        System.out.println("---------sort1------------");

        Collections.sort(ml, (o1, o2) -> o1.getCode() - o2.getCode());
        System.out.println("sorted value");
        for(Address element : ml){
            System.out.println(element + "\n");}

        System.out.println("-----sort2------");

        Collections.sort(ml, (o1, o2) -> o2.getCode() - o1.getCode());


        for(Address element : ml){
            System.out.println(element + "\n");}

        System.out.println("-----------");

    }
}