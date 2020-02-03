package practice;

public class Solution1 {
	
	public static void main(String args[]) {
		
		LongestCommonPrefix c1 = new LongestCommonPrefix();
	
		String[] strArray = {"flower","flow","flight"};
		System.out.println(c1.longestCommonPrefix(strArray));
		
		String[] strArray2 = {};
		System.out.println(c1.longestCommonPrefix(strArray2));
		
		String[] strArray3 = {"","b"};
		System.out.println(c1.longestCommonPrefix(strArray3));
		
		//["a","ac"]
		String[] strArray4 = {"a","ac"};
		System.out.println(c1.longestCommonPrefix(strArray4));
	}

}

class LongestCommonPrefix {
	
	public String longestCommonPrefix(String[] strs) {
		
		if(strs.length==0) {
			return "";
		}
		
		int len = strs.length;
		char[] compareArray = null;
		
		for(int i=0; i<len; i++) {
			
			if(strs[i].length()==0) {
				return "";
			}
			if(i==0) {
				compareArray = strs[0].toCharArray();
			}
			
			char[] tempArray = new char[compareArray.length];
			char[] targetArray = strs[i].toCharArray();
			
			int subArrayLengt = (targetArray.length<=compareArray.length) ? targetArray.length: compareArray.length;
			
			for(int j=0; j<subArrayLengt; j++) {
				if(targetArray[j]!=compareArray[j]) {
					break;
				} 
				tempArray[j] = compareArray[j];
			}
			
			compareArray = tempArray;
		}
		
		return String.valueOf(compareArray).trim();
    }
}
