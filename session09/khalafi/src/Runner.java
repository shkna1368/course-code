import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;


public class Runner {

    public static void main(String[] args) {

        Khalafi k1=new Khalafi();
        k1.setAmount(200000);
        k1.setLocation("Andarzgoo");
        k1.setTakhalofType(TakhalofType.HEJAB);

         Khalafi k2=new Khalafi();
        k2.setAmount(60000);
        k2.setLocation("Yadegar");
        k2.setTakhalofType(TakhalofType.HIGH_SPEED);

           Khalafi k3=new Khalafi();
        k3.setAmount(90000);
        k3.setLocation("Niaiesh");
        k3.setTakhalofType(TakhalofType.RED_LIGHT);

            Khalafi k4=new Khalafi();
        k4.setAmount(190000);
        k4.setLocation("Tohid");
        k4.setTakhalofType(TakhalofType.KAMARBAND);


        //----------------------------------

        Hashtable<String, List<Khalafi>> khalfiKeyValue =new Hashtable<>();

        List<Khalafi> khalafiListZahra=new ArrayList<>();
        khalafiListZahra.add(k1);

         List<Khalafi> khalafiListReza=new ArrayList<>();
        khalafiListReza.add(k2);

          List<Khalafi> khalafiListAhmad=new ArrayList<>();
        khalafiListAhmad.add(k3);
        khalafiListAhmad.add(k4);


        khalfiKeyValue.put("1111",khalafiListZahra);
        khalfiKeyValue.put("2222",khalafiListReza);
        khalfiKeyValue.put("3333",khalafiListAhmad);

        System.out.println("khalafi zahra:"+khalfiKeyValue.get("1111"));
        List<Khalafi> khalafis = khalfiKeyValue.get("3333");

        khalafis.forEach(khalafi -> System.out.println(khalafi));

String str="Me;";
String st="oowjkosdajkfsdmnfjknsdnfoooosfdmsdfncsm";

        char[] chars = str.toCharArray();

        khalfiKeyValue.co



    }
}
