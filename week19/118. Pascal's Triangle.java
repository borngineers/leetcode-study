class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> answer = new ArrayList<>();
        
        if(numRows == 0) return answer;
        List<Integer> preList = new ArrayList<>();
        
        for(int i=0; i<numRows; i++) {
            List<Integer> curList = new ArrayList<>();
            
            for(int j=0; j<=i; j++) {
                
                if(j == 0 || j == i) {
                    curList.add(1);
                } else {
                    curList.add(preList.get(j-1)+preList.get(j));
                }
            }
            answer.add(curList);
            preList.clear();
            preList.addAll(curList);
        }
        
        return answer;
    }
}
