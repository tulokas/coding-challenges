/** The Problem
 * The N-Queens puzzle is the problem of placing N queens on an N×N chessboard so that
 * no two queens attack each other.
 * 
 * Examples:
 * Input: N = 4
 * Output: [[1,0,0,0], [0,0,1,0], [0,1,0,0], [0,0,0,1]]
 **/

import java.util.*;

public class NQueens {
    public static void main(String[] args) {
        List<List<String>> result = solveNQueens(4);
        for (List<String> solution : result) {
            System.out.println(solution);
        }
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');
        solve(0, board, results);
        return results;
    }

    private static void solve(int row, char[][] board, List<List<String>> results) {
        if (row == board.length) {
            results.add(construct(board));
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isSafe(row, col, board)) {
                board[row][col] = 'Q';
                solve(row + 1, board, results);
                board[row][col] = '.';
            }
        }
    }

    private static boolean isSafe(int row, int col, char[][] board) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }

        for (int i = 1; row - i >= 0 && col - i >= 0; i++) {
            if (board[row - i][col - i] == 'Q') return false;
        }

        for (int i = 1; row - i >= 0 && col + i < board.length; i++) {
            if (board[row - i][col + i] == 'Q') return false;
        }

        return true;
    }

    private static List<String> construct(char[][] board) {
        List<String> result = new ArrayList<>();
        for (char[] row : board) {
            result.add(new String(row));
        }
        return result;
    }
}
