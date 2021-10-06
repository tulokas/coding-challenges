/** The Problem
 * Given an n x n matrix where each row and each column are sorted in ascending order,
 * find the kth smallest element in the matrix.
 * 
 * Examples:
 * Input: matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}, k = 8
 * Output: 13
 **/

import java.util.PriorityQueue;

public class KthSmallestInMatrix {
    public static void main(String[] args) {
        int result = solution(new int[][]{
            {1, 5, 9},
            {10, 11, 13},
            {12, 13, 15}
        }, 8);
        System.out.println("solution: " + result);
    }

    public static int solution(int[][] matrix, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < matrix.length; i++) {
            minHeap.offer(new int[]{matrix[i][0], i, 0});
        }

        while (k-- > 1) {
            int[] current = minHeap.poll();
            int row = current[1], col = current[2];

            if (col + 1 < matrix[row].length) {
                minHeap.offer(new int[]{matrix[row][col + 1], row, col + 1});
            }
        }

        return minHeap.poll()[0];
    }
}
