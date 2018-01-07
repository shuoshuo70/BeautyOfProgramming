package Chapter3;

/**
 * Created by shuoshu on 2018/1/7.
 */
public class ValidPreAndMid {
    public static void main(String[] args) {
        ValidPreAndMid solution = new ValidPreAndMid();
        int[] pre = {1, 2, 4, 3, 5, 6};
        int[] mid = {5, 2, 1, 4, 3, 6};
        System.out.println(solution.isValid(pre, mid));
    }

    public boolean isValid(int[] pre, int[] mid) {
        return isValid(pre, 0, pre.length - 1, mid, 0, mid.length - 1);
    }

    private boolean isValid(int[] pre, int start1, int end1, int[] mid, int start2, int end2) {
        if (end1 - start1 != end2 - start2) {
            return false;
        }

        if (end1 < start1 && end2 < start2) {
            return true;
        }

        int index = -1;
        for (int i = start2; i <= end2; i++) {
            if (mid[i] == pre[start1]) {
                index = i - start2;
                break;
            }
        }

        if (index == -1) {
            return false;
        }

        return isValid(pre, start1 + 1, start1 + index, mid, start2, start2 + index - 1) &&
                isValid(pre, start1 + index + 1, end1, mid, start2 + index + 1, end2);
    }
}
