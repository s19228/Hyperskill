public class Stats <T extends Number> {
    T [] nums;

    public Stats(T[] nums) {
        this.nums = nums;
    }

    double average(){
        double sum = 0;

        for (int i = 0; i < nums.length; i++){
            sum += nums[i].hashCode();
        }
        return sum / nums.length;

    }


}
