/** The Problem
 * Implement regular expression matching with support for '.' and '*'.
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * 
 * Examples:
 * Input: s = "aab", p = "c*a*b"
 * Output: true (Matches "aab")
 **/

public class RegexMatching {
    public static void main(String[] args) {
        String s = "aab", p = "c*a*b";
        System.out.println("Matches: " + isMatch(s, p));
    }

    public static boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') dp[0][j] = dp[0][j - 2];
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2] || (dp[i - 1][j] && 
                                  (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)));
                }
            }
        }

        return dp[m][n];
    }
}
