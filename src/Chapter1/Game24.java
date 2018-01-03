package Chapter1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shuoshu on 2018/1/3.
 */
public class Game24 {
    private static final double THRESHOLD = 1E-6;

    public static void main(String[] args) {
        Game24 solution = new Game24();
        System.out.println(solution.judgePoint24(new int[]{1, 2, 1, 2}));
    }

    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for (int num : nums) {
            list.add((double) num);
        }
        
        return helper(list);
    }

    private boolean helper(List<Double> list) {
        if (list.size() == 0) {
            return false;
        }
        
        if (list.size() == 1) {
            if (Math.abs(list.get(0) - 24) < THRESHOLD) {
                return true;
            } else {
                return false;
            }
        }

        for (int i = 1; i < list.size(); i++) {
            for (int j = 0; j < i; j++) {
                List<Double> newList = new ArrayList<>();
                for (int k = 0; k < list.size(); k++) {
                    if (k != i && k != j) {
                        newList.add(list.get(k));
                    }
                }

                List<Double> next = new ArrayList<>();
                double op1 = list.get(i), op2 = list.get(j);
                next.addAll(Arrays.asList(op1 + op2, op1 - op2, op2 - op1, op1 * op2));
                if (Math.abs(op2) > THRESHOLD) {
                    next.add(op1 / op2);
                }
                if (Math.abs(op1) > THRESHOLD) {
                    next.add(op2 / op1);
                }

                for (double d : next) {
                    newList.add(d);
                    if (helper(newList)) {
                        return true;
                    }
                    newList.remove(newList.size() - 1);
                }
            }
        }

        return false;
    }
}
