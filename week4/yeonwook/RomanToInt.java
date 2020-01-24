package practice;

import java.util.HashMap;

public class Solution1 {
	
	public static void main(String args[]) {
	
		String testCase = "III";
		
		System.out.println(romanToInt(testCase));
		
		testCase = "IV";
		
		System.out.println(romanToInt(testCase));
		
		testCase = "IX";
		
		System.out.println(romanToInt(testCase));
		
		testCase = "LVIII";
		
		System.out.println(romanToInt(testCase));
		
		testCase = "MCMXCIV";
		
		System.out.println(romanToInt(testCase));
		
		/*
		 * Symbol       Value
			I             1
			V             5
			X             10
			L             50
			C             100
			D             500
			M             1000
		 * 
		 */
		
		
	}
	
    public static int romanToInt(String s) {
    	
    	if(s.isEmpty()) {
    		return 0;
    	}
    	
    	HashMap<Character, Integer> dataMap = new HashMap<Character, Integer>();
    	dataMap.put('I',1);
    	dataMap.put('V',5);
    	dataMap.put('X',10);
    	dataMap.put('L',50);
    	dataMap.put('C',100);
    	dataMap.put('D',500);
    	dataMap.put('M',1000);
    	
    	int sum = 0;
    	int preVal =0;
    	
    	char[] targetList = s.toCharArray();
    	
    	for(char ch : targetList) {
    		if(!dataMap.containsKey(ch)) {
    			return 0;
    		}
    		
    		if(sum!=0) {
    			if(preVal<dataMap.get(ch)) {
    				sum -= (preVal*2);
    			} 
    		}
    		
    		preVal = dataMap.get(ch);
    		sum += preVal;
    	}
        
    	return sum;
    }
    
}
