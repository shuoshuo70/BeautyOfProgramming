package Chapter3;

/**
 * Created by shuoshu on 2018/1/8.
 */
public class BinarySearch {
    public static void main(String[] args) {
        BinarySearch solution = new BinarySearch();
        int nums[] = {1,2,5,5,5,7,7};
        int target = 2;
        System.out.println(solution.binarySearch1(nums, target));
        System.out.println(solution.binarySearch2(nums, target));
        System.out.println(solution.binarySearch3(nums, target));
        System.out.println(solution.binarySearch4(nums, target));
        System.out.println(solution.binarySearch5(nums, target));
    }
    public int binarySearch1(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return nums[l] == target ? l : -1;
    }

    public int binarySearch2(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return nums[l] == target ? l : -1;
    }

    public int binarySearch3(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (nums[mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }

        return nums[l] == target ? l : -1;
    }

    public int binarySearch4(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (nums[mid] >= target) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }

        return nums[l] < target ? l : -1;
    }

    public int binarySearch5(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return nums[l] > target ? l : -1;
    }
}
