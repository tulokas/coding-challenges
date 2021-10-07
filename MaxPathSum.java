/** The Problem
 * Find the maximum path sum in a binary tree. 
 * The path may start and end at any node.
 * 
 * Examples:
 * Input: [10, 2, 10, 20, 1, null, -25, null, null, null, null, 3, 4]
 * Output: 42 (20 + 2 + 10 + 10)
 **/

public class MaxPathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10, new TreeNode(2, new TreeNode(20), new TreeNode(1)),
                new TreeNode(10, null, new TreeNode(-25, new TreeNode(3), new TreeNode(4))));
        int maxSum = maxPathSum(root);
        System.out.println("Max Path Sum: " + maxSum);
    }

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static int maxSum;

    public static int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        dfs(root);
        return maxSum;
    }

    private static int dfs(TreeNode node) {
        if (node == null) return 0;

        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));

        maxSum = Math.max(maxSum, left + right + node.val);

        return node.val + Math.max(left, right);
    }
}
