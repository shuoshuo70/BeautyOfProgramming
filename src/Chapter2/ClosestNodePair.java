package Chapter2;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by shuoshu on 2018/1/6.
 */
public class ClosestNodePair {
    public static void main(String[] args) {
        ClosestNodePair solution = new ClosestNodePair();
        Node[] nodes = {new Node(0.5, 3.2), new Node(-2, 2.1), new Node(0.3, -1.9),
         new Node(3.2, 0.2)};
        System.out.println(solution.closestDistance(nodes));
    }

    public double closestDistance(Node[] nodes) {
        Arrays.sort(nodes, (o1, o2) -> new BigDecimal(o1.x).compareTo(new BigDecimal(o2.x)));

        return helper(nodes, 0, nodes.length - 1);
    }

    private double helper(Node[] nodes, int start, int end) {
        if (start == end) {
            return 0;
        }

        if (start == end - 1) {
            return getDistance(nodes[0], nodes[1]);
        }

        int mid = start + (end - start) / 2;
        double minDistance = Math.min(helper(nodes, start, mid), helper(nodes, mid, end));

        for (int i = mid - 1; i >= 0 && nodes[mid].x - nodes[i].x <= minDistance; i--) {
            for (int j = mid + 1; j < nodes.length && nodes[j].x - nodes[mid].x <= minDistance; j++) {
                if (Math.abs(nodes[i].y - nodes[j].y) <= minDistance) {
                    minDistance = Math.min(minDistance, getDistance(nodes[i], nodes[j]));
                }
            }
        }

        return minDistance;
    }

    private double getDistance(Node n1, Node n2) {
        return Math.sqrt(Math.pow(n1.x - n2.x, 2) + Math.pow(n1.y - n2.y, 2));
    }
}

class Node {
    double x;
    double y;
    Node (double x, double y) {
        this.x = x;
        this.y = y;
    }
}