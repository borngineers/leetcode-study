class Solution {
    public int[][] merge(int[][] intervals) {
        
        int colLen = intervals.length;
        if(colLen == 0) {
            return new int[0][0];
        }
        if(colLen == 1) {
            int[][] arr1 = {{intervals[0][0], intervals[0][1]}}; 
            return arr1;
        }    
        
        Arrays.sort(intervals, Comparator.comparingInt(o1->o1[0]));
        
        List<List<Integer>> list = new ArrayList<>();
        
        int from = intervals[0][0];
        int to = intervals[0][1];
        
        boolean flag = false;
        
        for(int i=1; i<colLen;  i++) {
            
            if(to < intervals[i][0]) {
                List<Integer> target = Arrays.asList(from, to);
                list.add(target);
                
                from = intervals[i][0];
                to = intervals[i][1];
                flag = true;
            } else {
                
                to = (to < intervals[i][1]) ? intervals[i][1] : to;
                if(i == colLen -1) flag = true;
            }
            
        }
        
        if(flag) {
            List<Integer> additional = Arrays.asList(from, to);
            list.add(additional);
        }
        
        int[][] answer = new int[list.size()][2];
        int index = 0;
        
        for(List<Integer> pair : list) {
            answer[index][0] = pair.get(0);
            answer[index++][1] = pair.get(1);
        }
        
        return answer;
    }
}
