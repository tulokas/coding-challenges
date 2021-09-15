/** The Problem
 * Find the smallest positive integer that is missing from the array.
 * 
 * Examples:
 * Input: {3, 4, -1, 1} Output: 2
 * Input: {1, 2, 0} Output: 3
 **/

public class FirstMissingPositive {
    public static void main(String[] args) {
        int result = solution(new int[]{3, 4, -1, 1});
        System.out.println("solution: " + result);
    }

    public static int solution(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
