package Chapter4;

/**
 * Created by shuoshu on 2018/1/16.
 */
public class BuyTickets {
    public static void main(String[] args) {
        BuyTickets solution = new BuyTickets();
        System.out.println(solution.getWays(3));
    }

    int ways = 0;
    public int getWays(int n) {
        int left = n, right = n;
        dfs(n, n);
        return ways;
    }

    private void dfs(int left, int right) {
        if (left > right) {
            return;
        }

        if (left == 0 && right == 0) {
            ways++;
        }

        if (left > 0) {
            dfs(left - 1, right);
        }

        if (right > 0) {
            dfs(left, right - 1);
        }
    }
}
