package Chapter2;

/**
 * Created by shuoshu on 2018/1/3.
 */
public class Factorial {
    public int getZeros(int n) {
        int ans = 0;

        while (n > 0) {
            ans += n / 5;
            n /= 5;
        }

        return ans;
    }
}
