package Chapter2;

/**
 * Created by shuoshu on 2018/1/7.
 */
public class MaxSubRectangle {
    public static void main(String[] args) {
        MaxSubRectangle solution = new MaxSubRectangle();
        int[][] nums = {{1, 4}, {-5, 10}, {7, 3}};
        System.out.println(solution.getMaxSubRectangle(nums));
    }

    public int getMaxSubRectangle(int[][] nums) {
        int max = Integer.MIN_VALUE, m = nums.length, n = nums[0].length;

        for (int i = 0; i < m; i++) {
            int[] arr = new int[n];
            for (int j = i; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    arr[k] += nums[j][k];
                }
                max = Math.max(max, findMaxSum(arr));
            }
        }

        return max;
    }

    private int findMaxSum(int[] arr) {
        int sum = 0, ans = Integer.MIN_VALUE;

        for (int n : arr) {
            if (sum <= 0) {
                sum = n;
            } else {
                sum += n;
            }

            ans = Math.max(ans, sum);
        }

        return ans;
    }
}
