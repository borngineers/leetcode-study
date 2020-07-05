class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
                
        final int rows = matrix.length;
        if(rows == 0){
            return Collections.emptyList();
        }
        
        final int cols = matrix[0].length;
        
        // 달팽이배열
        int row = 0;
        int col = 0;
        
        final List<Integer> list = new ArrayList<Integer>();
        while(list.size() != rows * cols) {
            
            while(col < cols && matrix[row][col] != Integer.MIN_VALUE) {
                list.add(matrix[row][col]);
                matrix[row][col++] = Integer.MIN_VALUE;
            }
            
            col--;
            row++;
            
            while(row < rows && matrix[row][col] != Integer.MIN_VALUE){
                list.add(matrix[row][col]);
                matrix[row++][col] = Integer.MIN_VALUE;
            }
            
            col--;
            row--;
            
            while(col >= 0 && matrix[row][col] != Integer.MIN_VALUE) {
                list.add(matrix[row][col]);
                matrix[row][col--] = Integer.MIN_VALUE;
            }
            
            col++;
            row--;
            
            while(row >= 0 && matrix[row][col] != Integer.MIN_VALUE) {
                list.add(matrix[row][col]);
                matrix[row--][col] = Integer.MIN_VALUE;
            }
            
            col++;
            row++;
        }
        
        return list;
    }
}
