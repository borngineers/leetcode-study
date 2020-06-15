package leetcode.week04;

public class S064 {
    public static void main(String[]args) {

    }

    public static int minPathSum(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        for(int row = 1; row < rows; row++){
            grid[row][0] += grid[row - 1][0];
        }

        for(int col = 1; col < cols; col++){
            grid[0][col] += grid[0][col - 1];
        }

        for(int row = 1; row < rows; row++){
            for(int col = 1; col < cols; col++){
                grid[row][col] = Math.min(grid[row][col] + grid[row-1][col], grid[row][col] + grid[row][col-1]);
            }
        }
        return grid[rows-1][cols-1];
    }
}
