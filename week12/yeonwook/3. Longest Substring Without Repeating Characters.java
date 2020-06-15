class Solution {
    
	public int lengthOfLongestSubstring(String s)  {  
	     
        int answer = 0;
        Set<Character> set = new HashSet<>();
        Queue<Character> qu = new LinkedList<>();
        char[] arr = s.toCharArray();
        int len = s.length();
        
        for(int i=0; i<len; i++) {
        	
        	if(!set.contains(arr[i])) {
        		set.add(arr[i]);
        		qu.add(arr[i]);
        	} else {
        		
        		while(qu.peek() != arr[i]) {
        			char a = qu.poll();
        			set.remove(a);
        		}
        		
        		char a = qu.poll();
    			set.remove(a);
    			
    			set.add(arr[i]);
        		qu.add(arr[i]);
        	}
        	answer = Math.max(answer, qu.size());
        }
        return answer;
    }
}
