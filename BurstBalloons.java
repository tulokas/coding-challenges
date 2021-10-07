/** The Problem
 * Given n balloons, each with a number of coins. You can burst a balloon to gain coins.
 * The coins you gain are `nums[i-1] * nums[i] * nums[i+1]`. Find the maximum coins.
 * 
 * Examples:
 * Input: nums = {3, 1, 5, 8}
 * Output: 167
 **/

public class BurstBalloons {
    public static void main(String[] args) {
        int result = solution(new int[]{3, 1, 5, 8});
        System.out.println("solution: " + result);
    }

    public static int solution(int[] nums) {
        int n = nums.length;
        int[] balloons = new int[n + 2];
        System.arraycopy(nums, 0, balloons, 1, n);
        balloons[0] = balloons[n + 1] = 1;

        int[][] dp = new int[n + 2][n + 2];

        for (int len = 1; len <= n; len++) {
            for (int left = 1; left <= n - len + 1; left++) {
                int right = left + len - 1;
                for (int i = left; i <= right; i++) {
                    dp[left][right] = Math.max(dp[left][right],
                        dp[left][i - 1] + balloons[left - 1] * balloons[i] * balloons[right + 1] + dp[i + 1][right]);
                }
            }
        }

        return dp[1][n];
    }
}
