class Solution {
    public int numIslands(char[][] grid) {
        
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int answer = 0;
        
        int rowLen = grid.length;
        int colLen = grid[0].length;
        
        for(int i=0; i<rowLen; i++) {
            
            for(int j=0; j<colLen; j++) {
                
                if(grid[i][j]=='1') {
                    checkIsland(grid, i, j);    
                    answer++;
                }
            }
        }
        
        return answer;    
    }
    
    //DFS
    public void checkIsland(char[][] grid, int row, int col) {
        
        int[] rows = {1,0,-1,0};
        int[] cols = {0,1,0,-1};
        
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col]=='0') {
            return ;
        }
        
        grid[row][col] = '0';
        for(int i=0; i<4; i++) {
            checkIsland(grid, row+rows[i], col+cols[i]);
        }
    }
    
    //BFS
    public void checkIsland222(char[][] grid, int row, int col) {
        
        int[] rows = {1,0,-1,0};
        int[] cols = {0,1,0,-1};
        Queue<Offset> qu = new LinkedList<Offset>();
        qu.add(new Offset(row, col));
        grid[row][col] = '0';
        
        while(!qu.isEmpty()) {
            Offset target = qu.poll();
            int row_1 = target.row;
            int col_1 = target.col;
            
            //grid[row_1][col_1] = '0';
            
            for(int i=0; i<4; i++) {
                
                if(row_1+rows[i] < 0 || col_1+cols[i] < 0 || row_1+rows[i] >= grid.length || col_1+cols[i] >= grid[0].length || grid[row_1+rows[i]][col_1+cols[i]] == '0') {
                    continue;
                }
                grid[row_1+rows[i]][col_1+cols[i]] = '0';
                qu.add(new Offset(row_1+rows[i],col_1+cols[i]));    
                
            }
        }
    }    
}

class Offset {
    int row;
    int col;
    
    public Offset(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
