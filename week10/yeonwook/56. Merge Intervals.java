class Solution {
    public int[][] merge(int[][] intervals) {
        
        List<Pair> list = new ArrayList<>();
        List<Pair> resultList = null;
        
        for(int i=0; i<intervals.length; i++) {
            resultList = new ArrayList<>();
        	
            for(Pair target : list) {
                if(!(target.from > intervals[i][1] || target.to < intervals[i][0])) {
                	intervals[i][0] = (target.from < intervals[i][0]) ? target.from : intervals[i][0];
                	intervals[i][1] = (target.to < intervals[i][1]) ? intervals[i][1] : target.to;
                } else {
                	resultList.add(target);
                }
            }
            
            resultList.add(new Pair(intervals[i][0], intervals[i][1]));
            list.clear();
            list = resultList;
        }
        
        int len = list.size();
        int[][] answer = new int[len][];

        for(int i=0; i<len; i++) {
            answer[i] = new int[2];
            answer[i][0] = list.get(i).from;
            answer[i][1] = list.get(i).to;
        }
        
        return answer;
    }
}

class Pair {
    int from;
    int to;
    
    public Pair(int from, int to) {
        this.from = from;
        this.to = to;
    }
}
