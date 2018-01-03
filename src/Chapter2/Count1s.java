package Chapter2;

/**
 * Created by shuoshu on 2018/1/3.
 */
public class Count1s {
    public static void main(String[] args) {
        Count1s solution = new Count1s();
        System.out.println(solution.count1s1(3));
        System.out.println(solution.count1s2(3));
    }

    public int count1s1(int n) {
        int ans = 0;

        while (n > 0) {
            ans += (n & 1);
            n >>= 1;
        }

        return ans;
    }

    public int count1s2(int n) {
        int ans = 0;

        while (n > 0) {
            n &= (n - 1);
            ans++;
        }

        return ans;
    }
}
