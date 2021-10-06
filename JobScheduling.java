/** The Problem
 * You have `n` jobs where every job is represented by a start time, end time, and profit.
 * Find the maximum profit you can achieve without overlapping jobs.
 * 
 * Examples:
 * Input: startTime = {1, 2, 3, 3}, endTime = {3, 4, 5, 6}, profit = {50, 10, 40, 70}
 * Output: 120
 **/

import java.util.*;

public class JobScheduling {
    public static void main(String[] args) {
        int result = solution(new int[]{1, 2, 3, 3}, new int[]{3, 4, 5, 6}, new int[]{50, 10, 40, 70});
        System.out.println("solution: " + result);
    }

    static class Job {
        int start, end, profit;

        Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }

    public static int solution(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }

        Arrays.sort(jobs, Comparator.comparingInt(a -> a.end));
        int[] dp = new int[n];
        dp[0] = jobs[0].profit;

        for (int i = 1; i < n; i++) {
            int includeProfit = jobs[i].profit;
            int lastNonConflict = binarySearch(jobs, i);
            if (lastNonConflict != -1) {
                includeProfit += dp[lastNonConflict];
            }
            dp[i] = Math.max(dp[i - 1], includeProfit);
        }

        return dp[n - 1];
    }

    private static int binarySearch(Job[] jobs, int index) {
        int low = 0, high = index - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (jobs[mid].end <= jobs[index].start) {
                if (jobs[mid + 1].end <= jobs[index].start) {
                    low = mid + 1;
                } else {
                    return mid;
                }
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
