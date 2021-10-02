/** The Problem
 * Given a string containing just the characters '(' and ')', find the length
 * of the longest valid (well-formed) parentheses substring.
 * 
 * Examples:
 * Input: s = "(()" Output: 2
 * Input: s = ")()())" Output: 4
 **/

import java.util.Stack;

public class LongestValidParentheses {
    public static void main(String[] args) {
        int result = solution(")()())");
        System.out.println("solution: " + result);
    }

    public static int solution(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }
        return maxLength;
    }
}
