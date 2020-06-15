class Solution {
	
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        
        Map<Integer, LinkedList<Integer>> map = new LinkedHashMap<>();
        
        int colSize = nums.size();
        int size = 0;
        
        for(int i=0; i<colSize; i++) {
            
            List<Integer> list = nums.get(i);
            int rowSize = list.size();
            size += rowSize;
            
            for(int j=0; j<rowSize; j++) {
                
                LinkedList<Integer> saveList = map.getOrDefault(i+j, new LinkedList<>());
                saveList.addFirst(list.get(j));
                map.put(i+j, saveList);
                
            }
            
        }
        
        int[] answer = new int[size];
        int index = 0;
        
        for(Integer key : map.keySet()) {
            for(Integer i : map.get(key)) {
                answer[index++] = i;
            }
        }
        
        return answer;

    }	
}
