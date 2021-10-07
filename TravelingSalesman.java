/** The Problem
 * Given a list of cities and the distances between every pair of cities, 
 * find the shortest possible route that visits each city exactly once and returns to the origin.
 * 
 * Examples:
 * Input: distances = {{0, 10, 15, 20}, {10, 0, 35, 25}, {15, 35, 0, 30}, {20, 25, 30, 0}}
 * Output: Minimum cost = 80
 **/

public class TravelingSalesman {
    public static void main(String[] args) {
        int[][] distances = {
                {0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0}
        };
        int result = tsp(distances);
        System.out.println("Minimum cost: " + result);
    }

    public static int tsp(int[][] graph) {
        int n = graph.length;
        int[][] dp = new int[1 << n][n];

        for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE / 2);
        dp[1][0] = 0;

        for (int mask = 1; mask < (1 << n); mask++) {
            for (int u = 0; u < n; u++) {
                if ((mask & (1 << u)) == 0) continue;

                for (int v = 0; v < n; v++) {
                    if ((mask & (1 << v)) != 0) continue;

                    dp[mask | (1 << v)][v] = Math.min(dp[mask | (1 << v)][v],
                            dp[mask][u] + graph[u][v]);
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            res = Math.min(res, dp[(1 << n) - 1][i] + graph[i][0]);
        }
        return res;
    }
}
