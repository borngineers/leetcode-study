package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution1 {
	
	public static void main(String args[]) {
		
		Solution11 s1 = new Solution11();
		
		//[10,2,5,3]
		//[7,1,14,11]
		//[3,1,7,11]
		
		int[] arr = new int[] {10,2,5,3};
		System.out.println(s1.checkIfExist(arr));
		
		int[] arr2 = new int[] {7,1,14,11};
		System.out.println(s1.checkIfExist(arr2));
		
		int[] arr3 = new int[] {3,1,7,11};
		System.out.println(s1.checkIfExist(arr3));
		
	}

}

class Solution11  {
	
	//2 <= arr.length <= 500
	//-10^3 <= arr[i] <= 10^3
	
    public boolean checkIfExist(int[] arr) {
    	
    	int len = arr.length;
    	if(len < 2 || len > 500) {
    		return false;
    	}
    	
    	for(int i=0; i<len; i++) {
    		for(int j=0; j<len; j++) {
    			if(i!=j && arr[i]==2*arr[j]) {
    				return true;
    			}
    		}
    	}
        
    	return false;
    }
}

