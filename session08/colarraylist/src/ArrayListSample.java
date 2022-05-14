import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ArrayListSample {

    public static void main(String[] args) {


        ArrayList<String> arrayList=new ArrayList<>();
        System.out.println("size="+ arrayList.size());
        arrayList.add("Java Core");
        arrayList.add("Spring");
        arrayList.add("POSTGRES");
        arrayList.add("Collection");
        arrayList.add("Collection");
        System.out.println("size after added item="+ arrayList.size());
        String zeroIndexValue = arrayList.get(0);
        System.out.println("Value of zero="+zeroIndexValue);
        arrayList.add(0,"JEE");
        String zeroIndexValue2 = arrayList.get(0);
        System.out.println("Value of zero="+zeroIndexValue2);
        arrayList.set(0,"JME");
        System.out.println("Value of zero="+arrayList.get(0));
        arrayList.remove("JME");
        System.out.println("Value of zero="+arrayList.get(0));

        boolean isExist=arrayList.contains("Spring");
        boolean isExist2=arrayList.contains("JSF");

        System.out.println("Spring:"+isExist);
        System.out.println("JSF2:"+isExist2);

        arrayList.remove("Collection");
        System.out.println("Collection:"+arrayList.contains("Collection"));

        System.out.println("---------------------------");


        for (String item:arrayList){

            System.out.println("item is:"+item);
        }
        System.out.println("*******");
        arrayList.forEach(s -> System.out.println(s));

        System.out.println("*********");
        Iterator itr = arrayList.iterator();
        while(itr.hasNext()) {
            String element = (String) itr.next();
            System.out.print(element );
        }

    }
}
