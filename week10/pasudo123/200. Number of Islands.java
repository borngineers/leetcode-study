package leetcode.week03;

public class S200 {

    public static void main(String[]args) {

    }

    static final int[]MOVE1 = {1, -1, 0, 0};
    static final int[]MOVE2 = {0, 0, 1, -1};

    public int numIslands(char[][] grid) {

        if(grid.length == 0){
            return 0;
        }

        final int rows = grid.length;
        final int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];
        int islands = 0;

        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(grid[row][col] == '0' || visited[row][col]){
                    continue;
                }

                search(row, col, grid, visited);
                islands += 1;
            }
        }

        return islands;
    }

    private static void search(int row, int col, char[][]grid, boolean[][]visited){
        visited[row][col] = true;

        for(int m = 0; m < 4; m++){
            int moveRow = row + MOVE1[m];
            int moveCol = col + MOVE2[m];
            if(moveRow < 0 || moveRow >= grid.length
                    || moveCol < 0 || moveCol >= grid[row].length){
                continue;
            }

            if(visited[moveRow][moveCol] || grid[moveRow][moveCol] == '0'){
                continue;
            }

            search(moveRow, moveCol, grid, visited);
        }
    }
}
