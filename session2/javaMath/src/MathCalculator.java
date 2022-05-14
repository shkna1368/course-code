

public class MathCalculator {

    public  void mathSamples(){
        double x = 28;
        double y = 4;

        if(x>y){
            System.out.println(x);
        }
        else {
            System.out.println(y);
        }

        // return the maximum of two numbers
        System.out.println("Maximum number of x and y is: " +Math.max(x, y));
///////////////////////////

        // return the square root of y
        System.out.println("Square root of y is: " + Math.sqrt(y));

        //returns 28 power of 4 i.e. 28*28*28*28
        System.out.println("Power of x and y is: " + Math.pow(x, y));


    }
}
