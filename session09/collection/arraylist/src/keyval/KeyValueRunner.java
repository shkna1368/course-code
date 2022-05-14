package keyval;

import model.Address;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class KeyValueRunner {

    public static void main(String[] args) {
        HashMap<Integer,Address> ml = new HashMap<Integer, Address>();
        ;
        Address adr1=   new Address("J.W. West", "11 Oak Ave",
                "Urbana", "IL", 1005);

        ml.put(1005,adr1);




        Address address=   ml.put(1005,adr1);

        ml.put(1002,new Address("Ralph Baker", "1142 Maple Lane",
                "Mahomet", "IL", 1002));
        ml.put(1001,new Address("Tom Carlton", "867 Elm St",
                "Champaign", "IL", 1001));
// Display the mailing list.

        System.out.println("getVal="+ml.get(1002));

        System.out.println("-----------");

        for (Integer integer : ml.keySet()) {
            System.out.println("key is:"+integer+"- value is:"+ml.get(integer));
        }

        System.out.println("-----------hashtable");

        ///////////////////////////////////////////////////hashtablle

        // Create a hash map
        Hashtable<String,Double> balance = new Hashtable();



        balance.put("Zara", 3434.34);
        balance.put("Mahnaz",123.22);
        balance.put("Ayan", 1378.00);
        balance.put("Daisy",99.22);
        balance.put("Qadir", -19.08);

        // Show all balances in hash table.
        for (String str : balance.keySet()) {
            System.out.println("key is:"+str+"- value is:"+balance.get(str));
        }
    }
}
