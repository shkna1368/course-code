package gen_two;

import java.util.HashMap;
import java.util.Map;

class SimpGen {
    public static void main(String[] args) {
        TwoGen<Integer, String> tgObj =
                new TwoGen<Integer, String>(88, "Generics");

        Map<String,Integer> m=new HashMap<>();
        m.put("s",1);
        m.put("s",22);
        m.put("s",445);





// Show the types.
        tgObj.showTypes();
// Obtain and show values.
        int v = tgObj.getOb1();
        System.out.println("value: " + v);
        String str = tgObj.getOb2();
        System.out.println("value: " + str);
    }
}