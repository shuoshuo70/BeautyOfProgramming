package Chapter2;

/**
 * Created by shuoshu on 2018/1/7.
 */
public class ConsecutiveArray {
    public static void main(String[] args) {
        ConsecutiveArray solution = new ConsecutiveArray();
        System.out.println(solution.consecutiveArray(8));
    }
    public String consecutiveArray(int n) {
        int left = 1, right = 1, sum = 0;

        while (left <= n / 2) {
            while (sum < n) {
                sum += right++;
            }


            while (sum >= n && left <= right) {
                if (sum > n) {
                  sum -= left++;
                }

                if (sum == n) {
                    return left + ", " + --right;
                }
            }
        }

        return null;
    }
}
