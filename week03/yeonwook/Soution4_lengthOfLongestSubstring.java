import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Solution4 {
	
	public static void main(String args[]) {
		
		
		String case1 = "abcabcbb";
		System.out.println(case1 + " : " +lengthOfLongestSubstring(case1));
		
		String case2 = "bbbbb";
		System.out.println(case2 + " : " +lengthOfLongestSubstring(case2));
		
		String case3 = "pwwkew";
		System.out.println(case3 + " : " +lengthOfLongestSubstring(case3));
		
		String case4 = " ";
		System.out.println(case4 + " : " +lengthOfLongestSubstring(case4));
		
		String case5 = "ab";
		System.out.println(case5 + " : " +lengthOfLongestSubstring(case5));
		
		String case6 = "aab";
		System.out.println(case6 + " : " +lengthOfLongestSubstring(case6));
		
		String case7 = "dvdf";
		System.out.println(case7 + " : " +lengthOfLongestSubstring(case7));
		
		String case8 = "tmmzuxt";
		System.out.println(case8 + " : " +lengthOfLongestSubstring(case8));
		
	}
	
	public static int lengthOfLongestSubstring(String s) {
	     
			char[] charList = s.toCharArray();
			if(charList.length==1) {
				return 1;
			}
			
			Queue<Character> queue = new LinkedList<Character>();
			
			HashMap<Character, Character> checkMap = new HashMap<Character,Character>();
			int maxLen = 0;
			int i=0;
			
			for(char a : charList) {
				
				if(checkMap.containsKey(a)) {
					while(!queue.isEmpty()) {
						char temp = queue.poll();

						if(temp==a) {
							break;
						} 
						checkMap.remove(temp);
					}
					queue.offer(a);
				} else {		
					queue.offer(a);
					checkMap.put(a, a);
				}
				if(queue.size()>maxLen) {
					maxLen = queue.size();
				}
			}
			
			return maxLen;
    }
}