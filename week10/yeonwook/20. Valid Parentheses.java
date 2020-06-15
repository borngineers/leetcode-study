class Solution {
    public boolean isValid(String s) {
        
        boolean answer = true;
        
        if(s.length()%2==1) {
        	return false;
        }
        
        Map<Character, Character> checkMap = new HashMap<Character, Character>();
        checkMap.put(')','(');
        checkMap.put('}','{');
        checkMap.put(']','[');
        
        Stack<Character> st = new Stack<Character>();
        
        char[] chars = s.toCharArray();
        
        for(char a : chars) {
            
            if(!checkMap.containsKey(a)) {
                st.push(a);
            } else {
                if(!st.isEmpty()) {
                    char b = st.pop();
                    if(b  != checkMap.get(a)) {
                        return false;
                    }
                }
            }
            
        }
        
        if(!st.isEmpty()) {
        	return false;
        }
        
        return answer;
    }
}