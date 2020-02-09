package practice;

import java.util.HashMap;
import java.util.TreeSet;

public class Solution2 {
	
	public static void main(String args[]) {
		
		Solution22 c1 = new Solution22();
		
		//String strArray = "3,3,3,3,5,5,5,2,2,7";
		int[] arr = new int[] {3,3,3,3,5,5,5,2,2,7};
		//System.out.println("정답 : "+c1.minSetSize(arr));
		
		int[] arr1 = new int[] {7,7,7,7,7,7};
		//System.out.println("정답 : "+c1.minSetSize(arr1));
		
		int[] arr2 = new int[] {1,9};
		//System.out.println("정답 : "+c1.minSetSize(arr2));
		
		int[] arr3 = new int[] {1000,1000,3,7};
		//System.out.println("정답 : "+c1.minSetSize(arr3));
		
		int[] arr4 = new int[] {1,2,3,4,5,6,7,8,9,10};
		System.out.println("정답 : "+c1.minSetSize(arr4));
	}
}

class Solution22 {
	
    public int minSetSize(int[] arr) {
    	
    	int len = arr.length;
    	
    	if(len == 0) {
    		return 0;
    	}
    	
    	if(len == 1 || len == 2) {
    		return 1;
    	}
    	
    	int minSetSize = (int) Math.ceil(len/2);
    	System.out.println("minSetSize : "+ minSetSize);
    	HashMap<Integer, Integer> checkMap = new HashMap<Integer, Integer>();
    	TreeSet<Integer> checkTress = new TreeSet<Integer>();
    	int tryVal = 0;
    	
    	for(int i=0; i<len; i++) {
    		if(checkMap.containsKey(arr[i])) {
    			checkMap.put(arr[i], checkMap.get(arr[i])+1);
    		} else {
    			checkMap.put(arr[i], 1);
    		}
    	}
    	
    	for(Integer i : checkMap.keySet()) {
    		System.out.println("key : "+ i +", value : "+checkMap.get(i));
    		checkTress.add(checkMap.get(i));
    	}
    	
    	while(minSetSize > 0) {
    		
    		
    		int removeVal = 0;
    		//checkTress.lower(e)
    		//Returns the greatest element in this set strictly less than thegiven element, 
    		//or null if there is no such element.
    		//checkTress.
    		
    		if(checkTress.floor(minSetSize)==null) {
    			removeVal = checkTress.higher(minSetSize);
    		} else {
    			removeVal = checkTress.floor(minSetSize);
    		}
    		System.out.println("removeVal : " + removeVal+"minSetSize : "+minSetSize);
    		minSetSize -= removeVal;
    		checkTress.remove(removeVal);
    		
    		tryVal++;
    	}
    	
    	return tryVal;   
    }
}
