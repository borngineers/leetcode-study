package week04;

public class UniquePaths {

    public static void main(String[]args) {

    }

    public static int uniquePaths(int m, int n) {

        int[][]grid = new int[n][m];

        // 왼쪽 사이드 1 로 채운다.
        for(int row = 0; row < n; row++) {
            grid[row][0] = 1;
        }

        // 위쪽 사이드 1 로 채운다.
        for(int col = 0; col < m; col++) {
            grid[0][col] = 1;
        }

        for(int row = 1; row < n; row++){
            for(int col = 1; col < m; col++){
                grid[row][col] = grid[row-1][col] + grid[row][col-1];
            }
        }

        return grid[n-1][m-1];
    }
}
