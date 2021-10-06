/** The Problem
 * Given an array of integers `nums` and an integer `k`, there is a sliding window
 * of size `k` which moves from the very left of the array to the very right. 
 * You can only see the `k` numbers in the window. Find the maximum for each window.
 * 
 * Examples:
 * Input: nums = {1,3,-1,-3,5,3,6,7}, k = 3
 * Output: {3,3,5,5,6,7}
 **/

import java.util.*;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] result = solution(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        System.out.println("solution: " + Arrays.toString(result));
    }

    public static int[] solution(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) return new int[0];

        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            // Remove indices outside the current window
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove indices of smaller elements
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Add the current index
            deque.offerLast(i);

            // Add the maximum for the window to the result
            if (i >= k - 1) {
                result[index++] = nums[deque.peekFirst()];
            }
        }
        return result;
    }
}
