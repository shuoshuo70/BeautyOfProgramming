package Chapter2;

/**
 * Created by shuoshu on 2018/1/7.
 */
public class MaxSubSum {
    public static void main(String[] args) {
        MaxSubSum solution = new MaxSubSum();
        int[] nums = {2, 3, -5, 1, 4};
        System.out.println(solution.maxSum(nums));
    }
    public int maxSum(int[] nums) {
        int ans = Integer.MIN_VALUE, sum = 0, startIndex = 0, n = nums.length;
        int[] arr = new int[n * 2];

        for (int i = 0; i < n; i++) {
            arr[i] = nums[i];
            arr[i + n] = nums[i];
        }

        for (int i = 0; i < 2 * n; i++) {
            if (sum <= 0) {
                sum = arr[i];
                startIndex = i;
            } else {
                if (i - startIndex < n) {
                    sum += arr[i];
                    ans = Math.max(ans, sum);
                } else {
                    break;
                }
            }
        }

        return ans;
    }
}
