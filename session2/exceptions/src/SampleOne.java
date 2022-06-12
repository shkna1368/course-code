public class SampleOne {

    public static void main(String[] args) {
        int a=100;
        int b=10;
        int x=a/b; //ArithmeticException:/ by zero

        String s=null;
        System.out.println(s.length());//NullPointerException

        String s2="abc";
        int i=Integer.parseInt(s2);//NumberFormatException

        int a2[]=new int[5];
        a2[10]=50; //ArrayIndexOutOfBoundsException
    }
}
