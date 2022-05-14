public class ArraySample {



    public int[] initArray(){

   // init array
    int[] monthDays = new int[12];  //init array
    monthDays[0] = 31;
    monthDays[1] = 28;
    monthDays[2] = 31;
    monthDays[3] = 30;
    monthDays[4] = 31;
    monthDays[5] = 30;
    monthDays[6] = 31;
    monthDays[7] = 31;
    monthDays[8] = 30;
    monthDays[9] = 31;
    monthDays[10] = 30;
    monthDays[11] = 31;

   return   monthDays;

}


public int[] init2(){
    int[] monthDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31,
            30, 31 };

    return  monthDays;

}

 public void printMonthValue(int index,int[] array){
     System.out.println("value of index:"+array[index]);
 }
    public    void getAverage(){
        double[] nums = {10.1, 11.2, 12.3, 13.4, 14.5};
        double result = 0;

        int arrayLenth=nums.length;
        int i;
        for(i=0; i<nums.length; i++){
            result = result + nums[i];}
        System.out.println("Average is " + result / nums.length);
    }


}
