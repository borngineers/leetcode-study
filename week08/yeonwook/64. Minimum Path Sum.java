class Solution {
    public int minPathSum(int[][] grid) {
        
        int colLen = grid.length;
        int rowLen = grid[0].length;
        
        if(rowLen==0 && colLen==0) {
            return 0;
        }
        
        return findMinPath(grid, colLen-1, rowLen-1);
    }
    
    public int findMinPath(int[][] grid, int i, int j) {
        
        if(i == 0 && j == 0) {
            return grid[0][0];
        }
        
        if(i < 0 || j < 0) {
    		return Integer.MAX_VALUE;
    	}
        
        int ceil = findMinPath(grid, i-1, j);
        
        int left = findMinPath(grid, i, j-1);
        
        return Math.min(left, ceil) + grid[i][j];
        
    }
}

------

class Solution {
    public int minPathSum(int[][] grid) {
        
        int colLen = grid.length;
        int rowLen = grid[0].length;
        
        for(int i=0; i<colLen; i++) {
            for(int j=0; j<rowLen; j++) {
                
                if(i==0 && j==0) {
                    continue;
                }
                if(i==0) {
                    grid[i][j] += grid[i][j-1];
                    continue;
                } 
                if(j==0) {
                    grid[i][j] += grid[i-1][j];
                    continue;
                }
                
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        
        return grid[colLen-1][rowLen-1];
    }
}
