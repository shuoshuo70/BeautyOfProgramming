package Chapter2;

/**
 * Created by shuoshu on 2018/1/4.
 */
public class TopK {
    public static void main(String[] args) {
        TopK solution = new TopK();
        int[] nums = {23, 4, 23, 3,  1,  5, 6,11, 3};
        int[] ans = solution.topK2(nums, 5);
        for (int n : ans) {
            System.out.print(n + " ");
        }
    }

    public int[] topK1(int[] nums, int k) {
        int index = quickSelect(nums, 0, nums.length - 1, k);
        int[] ans = new int[k];
        for (int i = index; i < nums.length; i++) {
            ans[i - index] = nums[i];
        }

        return ans;
    }

    private int quickSelect(int[] nums, int start, int end, int k) {
        int pivot = nums[start], i = start, j = end;

        while (i < j) {
            while (i < j && nums[j] >= pivot) {
                j--;
            }
            if (i < j) {
                nums[i++] = nums[j];
            }

            while (i < j && nums[i] < pivot) {
                i++;
            }
            if (i < j) {
                nums[j--] = nums[i];
            }
        }

        nums[i] = pivot;

        if (nums.length - i == k) {
            return i;
        } else if (nums.length - i < k) {
            return quickSelect(nums, start, i - 1, k);
        } else {
            return quickSelect(nums, i + 1, end, k);
        }
    }



    public int[] topK2(int[] nums, int k) {
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = nums[i];
        }
        
        buildHeap(ans);
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > ans[0]) {
                ans[0] = nums[i];
                adjust(ans, 0, ans.length - 1);
            }
        }

        return ans;
    }

    private void adjust(int[] ans, int start, int end) {
        int lChild = start * 2 + 1, rChild = start * 2 + 2, minIndex = start;
        if (lChild <= end && ans[lChild] < ans[minIndex]) {
            minIndex = lChild;
        }
        if (rChild <= end && ans[rChild] < ans[minIndex]) {
            minIndex = rChild;
        }

        if (minIndex != start) {
            int temp = ans[minIndex];
            ans[minIndex] = ans[start];
            ans[start] = temp;
            adjust(ans, minIndex, end);
        }
    }

    private void buildHeap(int[] ans) {
        for (int i = ans.length / 2; i >= 0; i--) {
            adjust(ans, i, ans.length - 1);
        }
    }
}
