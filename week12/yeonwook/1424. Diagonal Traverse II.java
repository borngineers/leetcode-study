class Solution {
	
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        
        int colLen = nums.size();
        int[] answer;
        
        if(colLen == 1) {
        	int k=0;
        	answer = new int[nums.get(0).size()];
        	for(Integer a : nums.get(0)) {
        		answer[k] = a;
        		k++;
        	}
        	
        	return answer;
        }
        
        int[] rowLen = new int[colLen];
        int maxRowLen = 0;
        
        for(int i=0; i<colLen; i++) {
        	rowLen[i] = nums.get(i).size();
        	maxRowLen = Math.max(maxRowLen, rowLen[i]);
        }
        
        if(maxRowLen==1) {
        	int k=0;
        	answer = new int[colLen];
        	for(List<Integer> li : nums) {
        		answer[k] = li.get(0);
        		k++;
        	}
        	
        	return answer;
        }
        
        int i = 0;
        int j = 0;
        
        List<Integer> list = new ArrayList<Integer>();
                
        while(i<colLen && j<maxRowLen) {
            
            int ii = i;
            int jj = j;
            
            while(ii>=0 && jj<maxRowLen) {
                
            	//&& jj>=00 && ii<colLen && jj<rowLen[ii]
            	if(jj>=rowLen[ii]) {
                    ii--;
                    jj++;
            		continue;
            	}
            	
                int target = nums.get(ii).get(jj);
                list.add(target);
                
                ii--;
                jj++;
            }
            
            if(i<colLen-1) {
                i++;
            } else {
                j++;
            }
        }
        
        int answersize = list.size();
        answer = new int[answersize];
        
        for(int z=0; z<answersize; z++) {
            answer[z] = list.get(z);
        }
        
        return answer;
    }
	
}
