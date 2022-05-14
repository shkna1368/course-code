public class Runner  {
    public static void main(String[] args) {
        MyNumber myNum; // declare an interface reference
        myNum = () -> 123.45;
        System.out.println(myNum.getValue());

        myNum = () -> Math.random() * 100;
        System.out.println(myNum.getValue());



    }


}
