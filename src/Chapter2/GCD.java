package Chapter2;

/**
 * Created by shuoshu on 2018/1/6.
 */
public class GCD {
    public static void main(String[] args) {
        GCD solution = new GCD();
        System.out.println(solution.gcd1(2, 10));
        System.out.println(solution.gcd2(2, 9));
        System.out.println(solution.gcd3(2, 9));
    }

    public int gcd1(int x, int y) {
        if (y == 0) {
            return x;
        }

        return gcd1(y, x % y);
    }

    public int gcd2(int x, int y) {
        if (x < y) {
            return gcd2(y, x);
        }

        if (y == 0) {
            return x;
        }

        return gcd2(x - y, y);
    }

    public int gcd3(int x, int y) {
        if (x < y) {
            return gcd3(y, x);
        }

        if (y == 0) {
            return x;
        }

        if (x % 2 == 0) {
            if (y % 2 == 0) {
                return gcd3(x >> 1, y >> 1) << 1;
            } else {
                return gcd3(x >> 1, y);
            }
        } else {
            if (y % 2 == 0) {
                return gcd3(x, y >> 1);
            } else {
                return gcd3(x - y, y);
            }
        }
    }
}
