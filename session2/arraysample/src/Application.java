public class Application {

    public static void main(String[] args) {
        ArraySample arraySample=new ArraySample();
        int[] monthDay = arraySample.initArray();
        arraySample.printMonthValue(6,monthDay);

        int[] monthDay2 = arraySample.init2();
        arraySample.printMonthValue(5,monthDay2);

        System.out.println("***************");
        arraySample.getAverage();




    }
}
