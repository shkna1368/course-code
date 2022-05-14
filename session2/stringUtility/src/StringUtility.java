public class StringUtility {


    public static void stringConcatenation(){

        //the + operator concatenates two strings

        String age = "9";
        String s = "He is " + age + " years old.";
        System.out.println(s);
    }
    public static void preventLongLines(){
        String s = """
                jhdjas
                             
                sdjkfkdsj
                kjsdkfjk
                """;
        System.out.println(s);
        String longStr = "This could have been" +

                "a very long line that would have " +
                "wrapped around. But string concatenation " +
                "prevents this.";
        System.out.println(longStr);
    }

    public  static void concatenationWithOtherDataTypes(){

        String s = "four: " + 2 + 2;
        System.out.println(s);

        String s2 = "four: " + (2 + 2);
        System.out.println(s2);
    }


    public static void searchingStrings( ) {

        //indexOf( ) Searches for the first occurrence of a character or substring.
        //lastIndexOf( ) Searches for the last occurrence of a character or substring.


        String s = "Now is the time for all good men " +
                "to come to the aid of their country.";
        System.out.println(s);
        System.out.println("indexOf(t) = " +
                s.indexOf('t'));

        /*
        System.out.println("lastIndexOf(t) = " +
                s.lastIndexOf('t'));
        System.out.println("indexOf(the) = " +
                s.indexOf("the"));
        System.out.println("lastIndexOf(the) = " +
                s.lastIndexOf("the"));
        System.out.println("indexOf(t, 10) = " +
                s.indexOf('t', 10));
        System.out.println("lastIndexOf(t, 60) = " +
                s.lastIndexOf('t', 60));
        System.out.println("indexOf(the, 10) = " +
                s.indexOf("the", 10));
        System.out.println("lastIndexOf(the, 60) = " +
                s.lastIndexOf("the", 60));*/


    }

    public static void equl( ) {



        String s1 = "Hello";
        String s2 = new String(s1);
        System.out.println(s1 + " equals " + s2 + " -> " +
                s1.equals(s2));
        System.out.println(s1 + " == " + s2 + " -> " + (s1 == s2));
    }
    public static void trimAndStrip( ) {
        System.out.print("?");
        String s2 = " Hello World ".strip();
        System.out.print(s2);
        String s3 = " Hello World ".stripLeading();
        System.out.print(s3);
        String s4 = " Hello World ".stripTrailing();
        System.out.print(s4);



    }

}
