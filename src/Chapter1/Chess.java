package Chapter1;

/**
 * Created by shuoshu on 2018/1/1.
 */
public class Chess {
    public void showPos() {
        byte n = 81;
        while (n-- > 0) {
            if (n / 9 % 3 == n % 9 % 3) {
                continue;
            }
            int x = n / 9 + 1, y = n % 9 + 1;
            System.out.print( x + " " + y + "       ");
        }
    }
}
