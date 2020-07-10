class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> answer = new ArrayList<>();
        
        int rowSize = matrix.length;
        if(rowSize == 0) return answer;
        
        int colSize = matrix[0].length;
        
        int[][] direct = {
            {0,1},
            {1,0},
            {0,-1},
            {-1,0}
        };
        
        int[][] visited = new int[rowSize][colSize];
        
        int row = 0;
        int col = 0;
        int dir = 0;

        for(int i=0; i<colSize*rowSize; i++) {
            
            answer.add(matrix[row][col]);
            visited[row][col] = 1;
            
            int tempRow = row + direct[dir%4][0];
            int tempCol = col + direct[dir%4][1];
            if(tempRow == -1 || tempRow == rowSize ||
              tempCol == -1 || tempCol == colSize ||
              visited[tempRow][tempCol] == 1) {
                dir++;
            }
            
            row = row + direct[dir%4][0];
            col = col + direct[dir%4][1];
        }
        
        return answer;
    }
}
