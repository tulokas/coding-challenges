/** The Problem
 * Given a string and a dictionary of words, determine if the string can be segmented 
 * into a space-separated sequence of dictionary words.
 * 
 * Examples:
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true ("leet code")
 **/

import java.util.*;

public class WordBreak {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        System.out.println("Can Break: " + wordBreak(s, wordDict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
