class Solution {
    
    public boolean wordBreak(String s, List<String> wordDict) {
        
        return findWordBreak(s, new HashSet<>(wordDict), 0);
    }
    
    public boolean findWordBreak(String s, HashSet<String> wordDict, int index) {
        
        if(index == s.length()) return true;
        
        for(int i=index+1; i<=s.length(); i++) {
            
            if(wordDict.contains(s.substring(index, i)) && findWordBreak(s, wordDict, i)) {
                return true;
            }
        }
        
        return  false;
    }
}

class Solution {
    
    public boolean wordBreak(String s, List<String> wordDict) {
        
        return findWordBreak(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);
    }
    
    public boolean findWordBreak(String s, HashSet<String> wordDict, int index, Boolean[] cache) {
        
        if(index == s.length()) return true;
        if(cache[index] != null) return cache[index];
        
        for(int i=index+1; i<=s.length(); i++) {
            
            if(wordDict.contains(s.substring(index, i)) && findWordBreak(s, wordDict, i, cache)) {
                return cache[index] = true;
            }
        }
        
        return  cache[index] = false;
    }
}
