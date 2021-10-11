/** The Problem
 * Given an `m x n` matrix, find the length of the longest increasing path. 
 * You may move in any of the four directions (up, down, left, right).
 * 
 * Examples:
 * Input: 
 * matrix = [
 *   [9, 9, 4],
 *   [6, 6, 8],
 *   [2, 1, 1]
 * ]
 * Output: 4 (Path: [1, 2, 6, 9])
 **/

public class LongestIncreasingPath {
    public static void main(String[] args) {
        int[][] matrix = {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        };
        System.out.println("Longest Increasing Path: " + longestIncreasingPath(matrix));
    }

    public static int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;

        int rows = matrix.length, cols = matrix[0].length;
        int[][] memo = new int[rows][cols];
        int maxPath = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maxPath = Math.max(maxPath, dfs(matrix, i, j, memo));
            }
        }

        return maxPath;
    }

    private static int dfs(int[][] matrix, int row, int col, int[][] memo) {
        if (memo[row][col] != 0) return memo[row][col];

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int maxLength = 1;

        for (int k = 0; k < 4; k++) {
            int newRow = row + dx[k], newCol = col + dy[k];

            if (newRow >= 0 && newRow < matrix.length && newCol >= 0 && newCol < matrix[0].length
                    && matrix[newRow][newCol] > matrix[row][col]) {
                maxLength = Math.max(maxLength, 1 + dfs(matrix, newRow, newCol, memo));
            }
        }

        memo[row][col] = maxLength;
        return maxLength;
    }
}
