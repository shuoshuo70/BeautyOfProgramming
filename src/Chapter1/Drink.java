package Chapter1;

/**
 * Created by shuoshu on 2018/1/1.
 */
public class Drink {
    public static void main(String[] args) {
        Drink  solution = new Drink();
        int[] weights = {2, 1};
        int[] satisfies = {2, 1};
        int[] counts = {3, 3};
        System.out.println(solution.maxSatisfied(weights, satisfies, counts, 5));
    }

    public int maxSatisfied(int[] weights, int[] satisfies, int[] counts, int w) {
        int n = weights.length;
        int[][] dp = new int[n + 1][w + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                for (int k = 0; k <= counts[i - 1]; k++) {
                    if (j < weights[i - 1] * k) {
                        break;
                    }
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - weights[i - 1] * k] + satisfies[i - 1] * k);
                }
            }
        }

        return dp[n][w];
    }
}
