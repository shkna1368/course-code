import java.util.Scanner;

public class Application {

    public static void main(String[] args) {



        Application application=new Application();

        Human boy=   application.getValue();
        boy.calculateBMI();
        boy.printAttributes();


    }
    private Human getValue(){

        Scanner input = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name  = input.next();

        System.out.print("Enter age: ");
        int age  = input.nextInt();

        System.out.print("Enter height in cm: ");
        float height = input.nextFloat();


        System.out.print("Enter weight in kg: ");
        float weight = input.nextFloat();

        System.out.print("Enter Eye Color: ");
        String eyeColor  = input.next();


        System.out.print("Enter 1 if you boy,2 if you are girl: ");
        int gender  = input.nextInt();


 /*       Human human1=new Human(eyeColor,age,height,weight,eyeColor,gender);//pass param in constructor

        System.out.println("use getter="+human1.getName());*/
   Human human1=new Human();
   // human1.setName(name);  // pass param in setter
    human1.setAge(age);
    human1.setHeight(height);
    human1.setWeight(weight);
    human1.setEyeColor(eyeColor);
        System.out.println();
human1=null;
        return human1;





    }
}
