package Chapter2;

/**
 * Created by shuoshu on 2018/3/1.
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int preV = nums[start], cur = start;
            do {
                int next = (cur + k) % nums.length;
                int temp = nums[next];
                nums[next] = preV;
                preV = temp;
                cur = next;
                count++;
            } while (cur != start);
        }
    }
}
