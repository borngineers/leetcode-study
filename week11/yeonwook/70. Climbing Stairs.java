class Solution {
    
    Map<Integer, Integer> map = new HashMap<>();
    
    public int climbStairs(int n) {
        
        if(map.containsKey(n)) {
            return map.get(n);
        }
        
        if(n < 0) return -1;
        if(n==1 || n==2) return n;
        
    	int result = 0;
        int climb1 = 1;
        int climb2 = 2;
        
        for(int i=3; i<=n; i++) {
            result = climb1 + climb2;
            climb1 = climb2;
            climb2 = result;
        }
        
        map.put(n, result);
        return result;
    }
}
