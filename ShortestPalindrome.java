/** The Problem
 * You are given a string s. Find the shortest palindrome by adding characters to the front of it.
 * 
 * Examples:
 * Input: s = "aacecaaa"
 * Output: "aaacecaaa"
 **/

public class ShortestPalindrome {
    public static void main(String[] args) {
        String result = solution("aacecaaa");
        System.out.println("solution: " + result);
    }

    public static String solution(String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + reversed;

        int[] lps = computeLPS(combined);
        int charsToAdd = s.length() - lps[combined.length() - 1];

        return reversed.substring(0, charsToAdd) + s;
    }

    private static int[] computeLPS(String str) {
        int[] lps = new int[str.length()];
        int len = 0;
        int i = 1;

        while (i < str.length()) {
            if (str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else if (len > 0) {
                len = lps[len - 1];
            } else {
                lps[i] = 0;
                i++;
            }
        }

        return lps;
    }
}
