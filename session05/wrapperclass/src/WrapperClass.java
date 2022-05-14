public class WrapperClass {

    //wrapper classes provide a way to use primitive data types (int, boolean, etc..) as objects.

    public void init(){

        Integer myInt = 5;
        Double myDouble = 5.99;
        Character myChar = 'A';
        System.out.println(myInt);
        System.out.println(myDouble);
        System.out.println(myChar);

    }

     public void init2(){

         Integer myInt = 5;
         Double myDouble = 5.99;
         Character myChar = 'A';
         System.out.println(myInt.intValue());
         System.out.println(myDouble.doubleValue());
         System.out.println(myChar.charValue());

    }



 public void init3(){

         Integer myInt = null;
         //int x=null;

    }


 public void init4(){
        String s1="589hfgh";
         Integer myS1 = Integer.parseInt(s1);
         int x=Integer.parseInt(null);

     String s2="12.69";
     Double myS2=Double.parseDouble(s2);




    }









}
