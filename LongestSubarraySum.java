/** The Problem
 * Given an array of integers and a target sum, find the length of the longest
 * subarray whose elements add up to the target sum.
 * 
 * Examples:
 * Input: {1, -1, 5, -2, 3}, target = 3 Output: 4 (subarray: {1, -1, 5, -2})
 * Input: {-2, -1, 2, 1}, target = 1 Output: 2 (subarray: {-1, 2})
 **/

import java.util.HashMap;

public class LongestSubarraySum {
    public static void main(String[] args) {
        int result = solution(new int[]{1, -1, 5, -2, 3}, 3);
        System.out.println("solution: " + result);
    }

    public static int solution(int[] nums, int target) {
        HashMap<Integer, Integer> prefixMap = new HashMap<>();
        int sum = 0, maxLength = 0;
        prefixMap.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (prefixMap.containsKey(sum - target)) {
                maxLength = Math.max(maxLength, i - prefixMap.get(sum - target));
            }
            prefixMap.putIfAbsent(sum, i);
        }
        return maxLength;
    }
}
