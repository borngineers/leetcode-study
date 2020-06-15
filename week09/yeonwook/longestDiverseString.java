package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Practice {
	
	public static void main(String args[]) {
		
		//a = 1, b = 1, c = 7
		
		char[][] arr = new char[2][3];
		//System.out.println(arr[0][1]);
		//System.out.println(arr[0][0] == '\0');
		System.out.println(new Solution().longestDiverseString(1,1,7) );
		
	}
}


class Solution {
	
	
    public String longestDiverseString(int a, int b, int c) {
    	
    	List<A> descList = new ArrayList<A>();
    	A aa = new A('a', a);
    	A bb = new A('b', b);
    	A cc = new A('c', c);
    	
    	descList.add(aa);
    	descList.add(bb);
    	descList.add(cc);
    	Collections.sort(descList);
    	
    	char[][] maps = new char[descList.get(0).cnt][6];
    	
    	for(char[] arr : maps) {
    		
    		if(descList.get(1).cnt !=0 ) {
    			arr[2] = descList.get(1).letter;
    			descList.get(1).cnt -= 1;
    		} else if(descList.get(2).cnt !=0) {
    			arr[2] = descList.get(2).letter;
    			descList.get(2).cnt -= 1;
    		} else {
    			break;
    		}
    		arr[0] = descList.get(0).letter;
    		descList.get(0).cnt -= 1;
    	}
    	
    	for(char[] arr : maps) {
    		
    		if(arr[2] == '\0') {
    			break;
    		}
    		
    		if(descList.get(0).cnt !=0) {
    			arr[1] = descList.get(0).letter;
    			descList.get(0).cnt -= 1;
    		}
    		
    		if(descList.get(1).cnt !=0 ) {
    			arr[3] = descList.get(1).letter;
    			descList.get(1).cnt -= 1;
    		} else if(descList.get(2).cnt !=0) {
    			arr[3] = descList.get(2).letter;
    			descList.get(2).cnt -= 1;
    		} 
    		
    	}
    	
    	
    	StringBuffer result = new StringBuffer();
    	
    	for(char[] arr : maps) {
    		
    		for(char ch : arr) {
    			if(ch != '\0') {
    				result.append(ch);
    			}
    		}
    	}
    	
    	for(int i=0 ; i<2; i++) {
    		if(descList.get(0).cnt !=0 ) {
    			result.append(descList.get(0).letter);
    			descList.get(0).cnt -= 1;
    		}
    	}
    	
    	
    	
    	return result.toString();
    }

}

class A implements Comparable<A> {
	char letter;
	Integer cnt;
	
	A (char letter, int cnt) {
		this.letter = letter;
		this.cnt = cnt;
	}

	@Override
	public int compareTo(A o) {
		// TODO Auto-generated method stub
		return this.cnt.compareTo(o.cnt)*-1;
	}
}

