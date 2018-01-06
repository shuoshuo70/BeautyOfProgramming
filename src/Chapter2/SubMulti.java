package Chapter2;

/**
 * Created by shuoshu on 2018/1/6.
 */
public class SubMulti {
    public static void main(String[] args) {
        SubMulti solution = new SubMulti();
        int[] nums = {-2, 3, 2, -3};
        System.out.println(solution.maxSubMul(nums));
    }

    public int maxSubMul(int[] nums) {
        int n = nums.length;
        int[] left = new int[n], right = new int[n];
        left[0] = 1;
        right[n - 1] = 1;

        for (int i = 0; i < n - 1; i++) {
            left[i + 1] = left[i] * nums[i];
        }

        for (int i = n - 1; i > 0; i--) {
            right[i - 1] = right[i] * nums[i];
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, left[i] * right[i]);
        }

        return max;
    }

}
