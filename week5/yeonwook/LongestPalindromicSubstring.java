package practice;

import practice.LongestPalindrome;

public class Solution2 {
	
	public static void main(String args[]) {
		
		LongestPalindrome c1 = new LongestPalindrome();
		
		String strArray = "bababbacbdda";
		//System.out.println(c1.longestPalindrome(strArray));
		
		String strArray2 = "ab";
		//System.out.println(c1.longestPalindrome(strArray2));
		
		String strArray3 = "cc";
		System.out.println(c1.longestPalindrome(strArray3));
		
		String strArray4 = "cccc";
		//System.out.println(c1.longestPalindrome(strArray4));
	
	}
}

class LongestPalindrome {
	
    public String longestPalindrome(String s) {
        
    	if(s.length()==0) {
    		return "";
    	}
    	if(s.length()==1) {
    		return s;
    	}
    	
    	char[] strArray = s.toCharArray();
    	int len = strArray.length;
    	
    	int index = 0;
    	String maxPalindrom = "";
    	String tempPalindrom1 = "";
    	String tempPalindrom2 = "";
    	
    	while (index<len-1) {
    		
    		if(strArray[index]==strArray[index+1]) {
    			tempPalindrom1 = findMaxPalindrom(s, index, index+1);
    		} 
    		
    		if(index!=len-2 && strArray[index]==strArray[index+2]) {
    			tempPalindrom2 = findMaxPalindrom(s, index, index+2);
    		}
    		
    		if(tempPalindrom2.length()>tempPalindrom1.length()) {
    			tempPalindrom1 = tempPalindrom2;
    		}
    		
    		if(tempPalindrom1.length()>maxPalindrom.length()) {
    			maxPalindrom = tempPalindrom1;
    		}
    		
    		index++;
    	}
    	
    	if(tempPalindrom1=="") {
    		maxPalindrom = String.valueOf(strArray[0]);
    	}
    	
    	return maxPalindrom;
    }
    
    private String findMaxPalindrom(String subString, int startIndex, int endIndex) {
    	
    	char[] charArray = subString.toCharArray();
    	int len = subString.length();
    	
    	while (startIndex > 0 && endIndex < len-1) {
    		
    		if(charArray[startIndex-1]==charArray[endIndex+1]) {
    			startIndex--;
        		endIndex++;
    			continue;
    		}
    		break;
    	}
    	
    	return subString.substring(startIndex, endIndex+1);
    }
}
