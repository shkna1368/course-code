
import java.util.Scanner;

public class MonthCalculator {



    public int getValue(){
        System.out.println("please enter month number between 1..12");
        Scanner in = new Scanner(System.in);
        return in.nextInt();

    }

    public void printValue(int num){
        System.out.println("entered:"+num);
    }
    private String getMonthName(int month){

        String mothValue= switch (month){
            case 1:

                yield "Farvardin";

            case 2:
                yield "Ordibehesht";

            case 3:
                yield "Khordad";

            case 4:

                yield "Tir";

            case 5:

                yield "Mordad";

            case 6:

                yield "Shahrivar";

            case 7:

                yield "Mehr";

            case 8:

                yield "Aban";


            case 9:

                yield "Azar";



            case 10:

                yield "Dey";

            case 11:

                yield "Bahman";

            case 12:

                yield "esfand";

            default :

                yield "Addad eshtebah";



        };


        return mothValue;
    }
}
