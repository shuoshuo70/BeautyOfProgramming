package Chapter1;

import java.util.Collections;
import java.util.List;

/**
 * Created by shuoshu on 2018/1/1.
 */
public class BuyBooks {
    public double minCost(List<Integer> books) {
        Collections.sort(books, Collections.reverseOrder());
        return dfs(books.get(0), books.get(1), books.get(2), books.get(3), books.get(4));
    }
    public double dfs(int x1, int x2, int x3, int x4, int x5) {
        if (x1 == 0) {
            return 0.0;
        }

        if (x5 >= 1) {
            return min(5 * 0.75 + dfs(x1 - 1, x2 - 1, x3 - 1, x4 - 1, x5 - 1),
                    4 * 0.8 + dfs(x1 - 1, x2 - 1, x3 - 1, x4 - 1, x5),
                    3 * 0.9 + dfs(x1 - 1, x2 - 1, x3 - 1, x4, x5),
                    2 * 0.95 + dfs(x1 - 1, x2 - 1, x3, x4, x5),
                    1 + dfs(x1 - 1, x2, x3, x4, x5));
        } else if (x4 >= 1) {
            return min(4 * 0.8 + dfs(x1 - 1, x2 - 1, x3 - 1, x4 - 1, x5),
                    3 * 0.9 + dfs(x1 - 1, x2 - 1, x3 - 1, x4, x5),
                    2 * 0.95 + dfs(x1 - 1, x2 - 1, x3, x4, x5),
                    1 + dfs(x1 - 1, x2, x3, x4, x5));
        } else if (x3 >= 1) {
            return min(3 * 0.9 + dfs(x1 - 1, x2 - 1, x3 - 1, x4, x5),
                    2 * 0.95 + dfs(x1 - 1, x2 - 1, x3, x4, x5),
                    1 + dfs(x1 - 1, x2, x3, x4, x5));
        } else if (x2 >= 1) {
            return min(2 * 0.95 + dfs(x1 - 1, x2 - 1, x3, x4, x5),
                    1 + dfs(x1 - 1, x2, x3, x4, x5));
        } else {
            return 1 + dfs(x1 - 1, x2, x3, x4, x5);
        }
    }

}
