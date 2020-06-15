package week05;

public class UniquePathsWithObstacles {

    public static void main(String[]args) {

//        System.out.println(uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
//
//        System.out.println(uniquePathsWithObstacles(new int[][]{{0}}));
//
//        System.out.println(uniquePathsWithObstacles(new int[][]{{1, 0}}));

        System.out.println(uniquePathsWithObstacles(new int[][]{{0, 0}, {1, 0}}));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

        // runtime : 0ms
        // memory : 37.7MB

        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

        if(obstacleGrid[0][0] == 1 || obstacleGrid[rows-1][cols-1] == 1){
            return 0;
        }

        obstacleGrid[0][0] = 1;

        for(int row = 1; row < rows; row++) {
            if(obstacleGrid[row][0] == 1){
                for(int subRow = row; subRow < rows; subRow++){
                    obstacleGrid[subRow][0] = 0;
                }

                break;
            }

            obstacleGrid[row][0] = 1;
        }

        for(int col = 1; col < cols; col++) {
            if(obstacleGrid[0][col] == 1){
                for(int subCol = col; subCol < cols; subCol++){
                    obstacleGrid[0][subCol] = 0;
                }

                break;
            }

            obstacleGrid[0][col] = 1;
        }

        for(int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {

                if(obstacleGrid[row][col] == 1){
                    obstacleGrid[row][col] = 0;
                    continue;
                }

                obstacleGrid[row][col] = obstacleGrid[row-1][col] + obstacleGrid[row][col-1];
            }
        }

        return obstacleGrid[rows-1][cols-1];
    }
}
