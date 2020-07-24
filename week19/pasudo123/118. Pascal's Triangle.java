class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        if(numRows == 0) {
            return Collections.emptyList();
        }
        
        final List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1));
        if(numRows == 1) {
            return list;
        } 
        
        list.add(Arrays.asList(1, 1));    
        if(numRows == 2) {
            return list;    
        }
    
        
        for(int row = 2; row < numRows; row++) {
            final List<Integer> elements = new ArrayList<>();
            
            elements.add(1);
            
            final List<Integer> upperElements = list.get(row - 1);
            
            // 그 외
            for(int col = 1; col <= row - 1; col++){
                final int sum = upperElements.get(col - 1) + upperElements.get(col);
                elements.add(sum);
            }
            
            elements.add(1);
            
            list.add(elements);
        }
        
        return list;
    }
}
