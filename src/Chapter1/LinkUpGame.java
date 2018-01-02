package Chapter1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by shuoshu on 2018/1/2.
 */
public class LinkUpGame {
    public static void main(String[] args) {
        LinkUpGame solution = new LinkUpGame();
        int[][] graph = {{1, 0, 0}, {1, 1, 0}, {1, 0, 1}};
        System.out.println(solution.canFindPath(graph, 0, 0, 2, 0));
    }
    public boolean canFindPath(int[][] graph, int startx, int starty, int descx, int descy) {
        int m = graph.length, n = graph[0].length;
        boolean[][] visited = new boolean[m][n];

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startx, starty});
        int count = 0;

        while (!q.isEmpty()) {
            if (count++ > 2) {
                break;
            }

            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curArr = q.poll();
                int x = curArr[0], y = curArr[1];
                visited[x][y] = true;
                //left
                while (--y >= 0) {
                    if (graph[x][y] == 0) {
                        if (!visited[x][y]) {
                            q.add(new int[]{x, y});
                        }
                    } else if (x == descx && y == descy) {
                        return true;
                    } else {
                        break;
                    }

                }
                y = curArr[1];
                //right
                while (++y < n) {
                    if (graph[x][y] == 0) {
                        if (!visited[x][y]) {
                            q.add(new int[]{x, y});
                        }
                    } else if (x == descx && y == descy) {
                        return true;
                    } else {
                        break;
                    }
                }
                y = curArr[1];
                //up
                while (--x >= 0) {
                    if (graph[x][y] == 0) {
                        if (!visited[x][y]) {
                            q.add(new int[]{x, y});
                        }
                    }else if (x == descx && y == descy) {
                        return true;
                    } else {
                        break;
                    }
                }
                x = curArr[0];
                //down
                while (++x < m) {
                    if (graph[x][y] == 0) {
                        if (!visited[x][y]) {
                            q.add(new int[]{x, y});
                        }
                    }else if (x == descx && y == descy) {
                        return true;
                    } else {
                        break;
                    }

                }
            }

        }

        return false;
    }


}
