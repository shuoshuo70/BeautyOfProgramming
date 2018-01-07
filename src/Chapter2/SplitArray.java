package Chapter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shuoshu on 2018/1/7.
 */
public class SplitArray {
    public static void main(String[] args) {
        SplitArray solution = new SplitArray();
        int[] nums = {1, 5, 7, 8, 9, 6, 3, 11, 20, 17};
        System.out.println(solution.splitArray2(nums));
    }


    public int splitArray1(int[] nums) {
        int n = nums.length, sum = 0;
        for (int num : nums) {
            sum += num;
        }

        boolean[][] dp = new boolean[n / 2 + 1][sum / 2 + 1];
        dp[0][0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n / 2 && j <= i; j++) {
                for (int k = 0; k <= sum / 2; k++) {
                    if (k >= nums[i - 1]) {
                        dp[j][k] = dp[j - 1][k - nums[i - 1]];
                    }
                }
            }
        }

        for (int i = sum / 2; i >= 0; i--) {
            if (dp[n / 2][i]) {
                return i;
            }
        }

        return -1;
    }

    int bias = Integer.MAX_VALUE;
    List<Integer> res = new ArrayList<>();
    public List<Integer> splitArray2(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        Arrays.sort(nums);

        dfs(nums, nums.length - 1, sum / 2, 0, list);

        return res;
    }

    private void dfs(int[] nums, int index, int target, int sum, List<Integer> list) {
        if (sum > target) {
            return;
        }

        if (list.size() == nums.length / 2) {
            if (target - sum < bias) {
                bias = target - sum;
                res = new ArrayList<>(list);
            }
            return;
        }

        for (int i = index; i >= 0; i--) {
            list.add(nums[i]);
            dfs(nums, i - 1, target, sum + nums[i], list);
            list.remove(list.size() - 1);
        }


    }
}
