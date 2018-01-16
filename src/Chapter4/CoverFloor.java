package Chapter4;

/**
 * Created by shuoshu on 2018/1/16.
 */
public class CoverFloor {
    public static void main(String[] args) {
        CoverFloor solution = new CoverFloor();
        int n = 7;
        System.out.println(solution.getMethod1(n));
        System.out.println(solution.getMethod2(n));
    }

    public int getMethod1(int n) {
        if (n <= 0) {
            return 0;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public int getMethod2(int n) {
        if (n <= 0) {
            return 0;
        }

        int f1 = 1, f2 = 1, f3 = 1;

        for (int i = 3; i <= n; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }

        return f3;
    }
}
