public class LeetCode289 {
    /**
     * 289. Game of Life
     * https://leetcode.com/problems/game-of-life/
     *
     * Any live cell with fewer than two live neighbors dies, as if caused by under-population.
     * Any live cell with two or three live neighbors lives on to the next generation.
     * Any live cell with more than three live neighbors dies, as if by over-population..
     * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
     *
     * Example:
     * Input:
     * [
     *   [0,1,0],
     *   [0,0,1],
     *   [1,1,1],
     *   [0,0,0]
     * ]
     * Output:
     * [
     *   [0,0,0],
     *   [1,0,1],
     *   [0,1,1],
     *   [0,1,0]
     * ]
     */

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] board = {
                {0,1,0},
                {0,0,1},
                {1,1,1},
                {0,0,0}
        };

        solution.gameOfLife(board);  // 4
        System.out.println(board);
    }

    static class Solution {
        // Runtime: 1 ms, faster than 30.19% of Java online submissions for Game of Life.
        // Memory Usage: 37.9 MB, less than 44.93% of Java online submissions for Game of Life.
        public void gameOfLife(int[][] board) {
            int row = board.length;
            int col = board[0].length;
            int[][] copyBoard = new int[row][col];

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    copyBoard = checkAround(board, copyBoard, i, j);
                }
            }

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    board[i][j] = copyBoard[i][j];
                }
            }
        }

        public int[][] checkAround(int[][] board, int[][] copyBoard, int baseRow, int baseCol) {
            int[][] around = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
            int countAroundLiveCell = 0;
            int countAroundDeadCell = 0;
            int baseCell = board[baseRow][baseCol];

            for (int[] temp : around) {
                int moveRow = baseRow + temp[0];
                int moveCol = baseCol + temp[1];
                if (!isValid(board, moveRow, moveCol)) { continue; }
                int checkCell = board[moveRow][moveCol];
                if (checkCell == 1) {
                    countAroundLiveCell++;
                } else {
                    countAroundDeadCell++;
                }
            }

            if (baseCell == 0) {
                if (countAroundLiveCell == 3) {
                    copyBoard[baseRow][baseCol] = 1;
                } else {
                    copyBoard[baseRow][baseCol] = baseCell;
                }
            } else {
                if (countAroundLiveCell != 2 && countAroundLiveCell != 3) {
                    copyBoard[baseRow][baseCol] = 0;
                } else {
                    copyBoard[baseRow][baseCol] = baseCell;
                }
            }
            return copyBoard;
        }

        public boolean isValid(int[][] board, int row, int col) {
            return (0 <= row && 0 <= col) && (row < board.length && col < board[0].length);
        }
    }

}
