package Chapter2;

import java.util.Arrays;

/**
 * Created by shuoshu on 2018/1/7.
 */
public class LIS {
    public static void main(String[] args) {
        LIS solution = new LIS();
        int[] nums = {1, -1, 2, -3, 4, -5, 6, -7};
        System.out.println(solution.getLIS2(nums));
    }

    public int getLIS1(int[] nums) {
        int n = nums.length, len = 0;
        int[] arr = new int[n];

        for (int num : nums) {
            if (len == 0 || num > arr[len - 1]) {
                arr[len++] = num;
            } else {
                int index = Arrays.binarySearch(arr, 0, len - 1, num);
                if (index < 0) {
                    index = -index - 1;
                }
                arr[index] = num;
            }
        }

        return len;
    }

    public int getLIS2(int[] nums) {
        int n = nums.length, ans = 0;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }


}
