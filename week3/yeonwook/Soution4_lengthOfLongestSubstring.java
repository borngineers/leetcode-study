import java.util.ArrayList;
import java.util.HashMap;

public class Solution4 {
	
	public static void main(String args[]) {
		
		String case1 = "abcabcbb";
		System.out.println(lengthOfLongestSubstring(case1));
		
		String case2 = "bbbbb";
		System.out.println(lengthOfLongestSubstring(case2));
		
		String case3 = "pwwkew";
		System.out.println(lengthOfLongestSubstring(case3));
		
		String case4 = " ";
		System.out.println(lengthOfLongestSubstring(case4));
		
		String case5 = "ab";
		System.out.println(lengthOfLongestSubstring(case5));
		
		String case6 = "aab";
		System.out.println(lengthOfLongestSubstring(case6));
		
		String case7 = "dvdf";
		System.out.println(lengthOfLongestSubstring(case7));
		
	}
	
	public static int lengthOfLongestSubstring(String s) {
     
		char[] charList = s.toCharArray();
		if(charList.length==1) {
			return 1;
		}
		
		HashMap<Character, Character> checkMap = new HashMap<Character,Character>();
		ArrayList<HashMap> checkList = new ArrayList<HashMap>();
		int maxVal = 0;
		
		for(char a : charList) {
			
			if(!checkMap.containsKey(a)) {
				checkMap.put(a, a);
				
			} else {		
				checkList.add(checkMap);
				checkMap = new HashMap<Character,Character>();
				checkMap.put(a, a);
			}
		}
		checkList.add(checkMap);
		
		for(HashMap data : checkList) {
			if(data.size()>maxVal) {
				maxVal = data.size();
			}
		}
		
		return maxVal;
    }
}