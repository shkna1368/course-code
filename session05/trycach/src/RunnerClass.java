import java.lang.invoke.WrongMethodTypeException;

public class RunnerClass {
    public static void main(String[] args) {

   /*     String str = null;
        System.out.println(str.length());

*/
        int res =0;

        try
        {
            res = divideByZero(10,0);
        }
        // doesn't matches with ArithmeticException
        catch(WrongMethodTypeException ex)
        {
            System.out.println("NumberFormatException is occured");
        }


     catch(ArithmeticException ex)
        {
            System.out.println("NumberFormatException is occured");
        }



        finally {
            System.out.println("finally call");

        }


        System.out.println(res);

        checkAge(15); // Set age to 15 (which is below 18...)
    }


    static int divideByZero(int a, int b){

        // this statement will cause ArithmeticException(/ by zero)
        int i = a/b;

        return i;
    }

    static void checkAge(int age) {
        if (age < 18) {
            throw new ArithmeticException("Access denied - You must be at least 18 years old.");
        }
        else {
            System.out.println("Access granted - You are old enough!");
        }
    }
}
