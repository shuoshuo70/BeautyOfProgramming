package Chapter2;

/**
 * Created by shuoshu on 2018/1/4.
 */
public class NumberOfOne {
    public static void main(String[] args) {
        NumberOfOne solution = new NumberOfOne();
        System.out.println(solution.countOne(123));
    }

    public int countOne(int n) {
        int highPart = 0, lowPart = 0, curPart = 0, factor = 1, count = 0;

        while (n / factor > 0) {
            highPart = n / (factor * 10);
            lowPart = n - n / factor * factor;
            curPart = n / factor % 10;

            if (curPart == 0) {
                count += highPart * factor;
            } else if (curPart == 1) {
                count += highPart * factor + lowPart + 1;
            } else {
                count += (highPart + 1) * factor;
            }

            factor *= 10;
        }

        return count;
    }
}
