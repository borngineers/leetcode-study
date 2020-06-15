import java.util.Arrays;

public class LeetCode64 {
    /**
     * 64. Minimum Path Sum
     * https://leetcode.com/problems/minimum-path-sum/
     *
     * Example:
     * Input:
     * [
     *   [1,3,1],
     *   [1,5,1],
     *   [4,2,1]
     * ]
     * Output: 7
     * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
     * */
    public static void main(String[] args) {
        int[][] sample = new int[][]{
                {1,4,8,6,2,2,1,7},
                {4,7,3,1,4,5,5,1},
                {8,8,2,1,1,8,0,1},
                {8,9,2,9,8,0,8,9},
                {5,7,5,7,1,8,5,5},
                {7,0,9,4,5,6,5,6},
                {4,9,9,7,9,1,9,0}
        };  // 47
        Solution solution = new Solution();
        int result = solution.minPathSum2(sample);
        System.out.println(result);

        sample = new int[][]{
                {1,1,1,1,9,9},
                {9,1,9,9,9,9},
                {1,1,9,9,9,9},
                {1,9,9,1,1,1},
                {1,1,1,1,9,1}
        };  // 14
    }

    static class Solution {
        public int minPathSum(int[][] grid) {
            if (grid.length == 0) { return 0; }
            int rowSize = grid.length;
            int colSize = grid[0].length;
            int rowPosition = rowSize - 1;
            int colPosition = colSize - 1;
            int sum = 0;

            if (rowSize == 1) { return Arrays.stream(grid[0]).sum(); }
            if (colSize == 1) {
                for (int[] row: grid) {
                    sum += row[0];
                }
                return sum;
            }

            while (rowPosition != 0 || colPosition != 0) {
                sum += grid[rowPosition][colPosition];
                int up = rowPosition - 1;
                int left = colPosition - 1;
                if (up < 0) {
                    colPosition = left;
                } else if (left < 0) {
                    rowPosition = up;
                } else {
                    if (grid[up][colPosition] < grid[rowPosition][left]) {
                        rowPosition = up;
                    } else {
                        colPosition = left;
                    }
                }
            }
            sum += grid[0][0];
            return sum;
        }

        public int minPathSum2(int[][] grid) {
            if (grid.length == 0) { return 0; }
            int rowSize = grid.length;
            int colSize = grid[0].length;
            int sum = 0;

            if (rowSize == 1) { return Arrays.stream(grid[0]).sum(); }
            if (colSize == 1) {
                for (int[] row: grid) {
                    sum += row[0];
                }
                return sum;
            }

            int[][] sumMap = new int[rowSize][colSize];
            for (int rowPosition = 0; rowPosition < rowSize; rowPosition++) {
                for (int colPosition = 0; colPosition < colSize; colPosition++) {
                    int up = rowPosition - 1;
                    int left = colPosition - 1;
                    if (up < 0 && left < 0) {
                        sumMap[rowPosition][colPosition] = grid[rowPosition][colPosition];
                    } else if (up < 0) {
                        sumMap[rowPosition][colPosition] = sumMap[rowPosition][left] + grid[rowPosition][colPosition];
                    } else if (left < 0) {
                        sumMap[rowPosition][colPosition] = sumMap[up][colPosition] + grid[rowPosition][colPosition];
                    } else {
                        if (grid[up][colPosition] < grid[rowPosition][left]) {
                            sumMap[rowPosition][colPosition] = sumMap[up][colPosition] + grid[rowPosition][colPosition];
                        } else {
                            sumMap[rowPosition][colPosition] = sumMap[rowPosition][left] + grid[rowPosition][colPosition];
                        }
                    }
                }
            }
            for (int[] row : sumMap) {
                String test = "";
                for (int i : row) {
                    test = test + i + " ";
                }
                System.out.println(test);
            }
            return sumMap[rowSize-1][colSize-1];
        }

    }
}
