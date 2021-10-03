/** The Problem
 * Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
 * The allowed operations are insert a character, delete a character, or replace a character.
 * 
 * Examples:
 * Input: word1 = "horse", word2 = "ros" Output: 3
 * Explanation: horse -> rorse -> rose -> ros
 **/

public class EditDistance {
    public static void main(String[] args) {
        int result = solution("horse", "ros");
        System.out.println("solution: " + result);
    }

    public static int solution(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }
        return dp[m][n];
    }
}
