package practice;

import java.util.HashMap;
import java.util.TreeSet;

public class Solution2 {
	
	public static void main(String args[]) {
		
		//s = "bab", t = "aba"
		//1
		//s = "leetcode", t = "practice"
		//5
		//s = "anagram", t = "mangaar"
		//0
		//s = "xxyyzz", t = "xxyyzz"
		//0
		//s = "friend", t = "family"
		//4
		
		Solution22 ss = new Solution22();
		
		String s = "bab";
		String t = "aba";
		System.out.println(ss.minSteps(s, t));
		
		String s1 = "leetcode";
		String t1 = "practice";
		System.out.println(ss.minSteps(s1, t1));
		
		String s2 = "anagram";
		String t2 = "mangaar";
		System.out.println(ss.minSteps(s2, t2));
		
		String s3 = "xxyyzz";
		String t3 = "xxyyzz";
		System.out.println(ss.minSteps(s3, t3));
		
		String s4 = "friend";
		String t4 = "family";
		System.out.println(ss.minSteps(s4, t4));
		
	}
}

class Solution22 {
	//1 <= s.length <= 50000
	//s.length == t.length
	//s and t contain lower-case English letters only.
	
    public int minSteps(String s, String t) {
    	
    	char[] tList = t.toCharArray();
    	HashMap<Character, Integer> tMap = new HashMap<Character, Integer>();
    	
    	char[] sList = s.toCharArray();
    	HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
    	
    	int cnt = 0;
    	
    	for(char ch : tList) {
    		if(tMap.containsKey(ch)) {
    			tMap.put(ch, tMap.get(ch)+1);
    		} else {
    			tMap.put(ch, 1);
    		}
    	}
    	
    	for(char ch : sList) {
    		if(sMap.containsKey(ch)) {
    			sMap.put(ch, sMap.get(ch)+1);
    		} else {
    			sMap.put(ch, 1);
    		}
    	}
    	
    	for(Character ch : sMap.keySet()) {
    		if(tMap.containsKey(ch)) {
    			int value = (sMap.get(ch)>tMap.get(ch)) ? sMap.get(ch)-tMap.get(ch) : 0;
    			cnt = cnt + value;
    		} else {
    			cnt = cnt + sMap.get(ch);
    		}
    	}
    	
    	return cnt;
    }
}
