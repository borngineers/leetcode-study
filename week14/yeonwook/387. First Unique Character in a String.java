class Solution {
    public int firstUniqChar(String s) {
        
        int len = s.length();
        
        Map<Character, Integer> checkMap = new HashMap<>();
        
        for(char a : s.toCharArray()) {
            if(checkMap.containsKey(a)) {
                checkMap.put(a, 2);
            } else {
                checkMap.put(a, 1);
            }
        }
        
        int i=0;
        for(char a : s.toCharArray()) {
            if(checkMap.get(a) == 1) {
                return i;
            }
            i++;
        }
        
        return -1;
    }
}
