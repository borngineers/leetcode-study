class Solution {
    
    private Map<Integer, Boolean> cache = new HashMap<>();
    
    public boolean isHappy(int n) {
        
        if(cache.containsKey(n)) {
            return cache.get(n);
        }
        
        boolean answer = findHappyNum(n);
        
        cache.put(n, answer);
        
        return answer;
    }
    
    public boolean findHappyNum(int n) {
        
        if(n==1) return true;
            
        Set<Integer> checkSet = new HashSet<Integer>();
        checkSet.add(n);
        
        while(n > 0) {
            
            int happy = 0;
            while(n > 0) {
                int reamainder = n % 10;
                int quotient = n / 10;
                n = quotient;
                happy += reamainder * reamainder;
            }
            
            if(checkSet.contains(happy)) {
                return false;
            }
            if(happy == 1 ) {
                break;
            }
            checkSet.add(happy);
            n = happy; 
        }
        
        return true;
    }
}
