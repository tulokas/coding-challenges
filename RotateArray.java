/** The Problem
 * Rotate an array to the right by k steps.
 * 
 * Examples:
 * Input: {1, 2, 3, 4, 5}, k = 2 Output: {4, 5, 1, 2, 3}
 * Input: {1, 2}, k = 3 Output: {2, 1}
 **/

public class RotateArray {
    public static void main(String[] args) {
        int[] result = solution(new int[]{1, 2, 3, 4, 5}, 2);
        System.out.print("solution: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public static int[] solution(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
        return nums;
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}
