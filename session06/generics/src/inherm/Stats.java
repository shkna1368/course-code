package inherm;

class Stats<T extends Number> {
    T[] nums; // array of Number or subclass
    // an array of type Number or subclass.
    Stats(T[] o) {
        nums = o;
    }
    // Return type double in all cases.
    double average() {
        double sum = 0.0;
        for(int i=0; i < nums.length; i++)
            sum += nums[i].doubleValue();
        return sum / nums.length;
    }
}


