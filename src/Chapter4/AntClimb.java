package Chapter4;

/**
 * Created by shuoshu on 2018/1/18.
 */
public class AntClimb {
    public static void main(String[] args) {
        AntClimb solution = new AntClimb();
        int[] nums = {3, 7, 11, 17, 23};
        double[] res = solution.getTime(nums, 27, 1.0);
        for (double n : res) {
            System.out.print(n + " ");
        }
    }

    public double[] getTime(int[] nums, int total, double speed) {
        double min =  0, max = 0;

        for (int num : nums) {
            if (num > total / 2) {
                min = Math.max(min, (total - num) / speed);
                max = Math.max(max,num / speed);
            } else {
                min = Math.max(min, num / speed);
                max = Math.max(max, (total - num) / speed);
            }
        }

        double[] res = new double[2];
        res[0] = min;
        res[1] = max;

        return res;
    }
}
