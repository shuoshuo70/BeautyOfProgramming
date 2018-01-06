package Chapter2;

/**
 * Created by shuoshu on 2018/1/6.
 */
public class MaxMinNumber {
    public static void main(String[] args) {
        MaxMinNumber solution = new MaxMinNumber();
        int[] nums = {2,35,7, 6, 4,57, 74,23, 4,2,5, 1};
        int[] res = solution.getMaxMin1(nums);
        for (int n : res) {
            System.out.print(n + " ");
        }
    }

    public int[] getMaxMin1(int[] nums) {
        int n = nums.length, max = nums[n - 1], min = nums[n - 1];

        for (int i = 0; i < n - 1; i += 2) {
            if (nums[i] > nums[i + 1]) {
                max = Math.max(nums[i], max);
                min = Math.min(nums[i + 1], min);
            } else {
                max = Math.max(nums[i + 1], max);
                min = Math.min(nums[i], min);
            }
        }

        int[] res = {max, min};

        return res;
    }

    public int[] getMaxMin2(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private int[] helper(int[] nums, int start, int end) {
        if (end <= start + 1) {
            if (nums[start] < nums[end]) {
                return new int[]{nums[end], nums[start]};
            } else {
                return new int[]{nums[start], nums[end]};
            }
        }

        int mid = (start + end) >>> 1;
        int[] left = helper(nums, start, mid), right = helper(nums, mid + 1, end);

        return new int[]{Math.max(left[0], right[0]), Math.min(left[1], right[1])};
    }
}
