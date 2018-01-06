package Chapter2;

/**
 * Created by shuoshu on 2018/1/6.
 */
public class Fibonacci {
    public static void main(String[] args) {
        Fibonacci solution = new Fibonacci();
        System.out.println(solution.getFibonacci(7));
    }
    public int getFibonacci(int n) {
        if (n <= 0) {
            return 0;
        }


        int f1 = 0, f2 = 1, f3 = 1;

        for (int i = 2; i <= n; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }

        return f3;
    }
}
