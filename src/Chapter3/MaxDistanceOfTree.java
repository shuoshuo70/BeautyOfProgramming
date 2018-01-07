package Chapter3;

/**
 * Created by shuoshu on 2018/1/7.
 */
public class MaxDistanceOfTree {
    public static void main(String[] args) {
        MaxDistanceOfTree solution = new MaxDistanceOfTree();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(3);
        root.right.left.left = new TreeNode(4);
        root.right.left.left.left = new TreeNode(5);
        root.right.right.left = new TreeNode(4);
        root.right.right.right = new TreeNode(4);
        root.right.right.left.right = new TreeNode(5);
        System.out.println(solution.maxDistance(root));
    }

    int max = 0;
    public int maxDistance(TreeNode root) {
        pathDown(root);

        return max;
    }

    private int pathDown(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 0;
        }

        int left = pathDown(root.left), right = pathDown(root.right);

        if (left == 0) {
            max = Math.max(max, right + 1);
        }
        if (right == 0) {
            max = Math.max(max, left + 1);
        }

        max = Math.max(max, left + right + 2);

        return Math.max(left, right) + 1;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}
