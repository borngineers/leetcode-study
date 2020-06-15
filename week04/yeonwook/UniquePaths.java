package practice;

import practice.Solution;

public class Solution4 {
	
	public static void main(String args[]) {
		
		Solution c1 = new Solution();
		
		int a = 2;
		int b = 3;
		System.out.println(c1.uniquePaths2(a,b));
		
		a = 3;
		b = 7;
		System.out.println(c1.uniquePaths2(a,b));
	}
}

class Solution {
	
    public int uniquePaths(int m, int n) {
        
    	if(m==1 || n==1) {
    		return 1; 
    	}
    	if(m<=0 || n<=0) {
    		return 0;
    	}
    	
    	int param1 = (m-1)+(n-1);
    	int param2 = (n<m) ? n-1:m-1;
    	
    	return combination(param1, param2);
    }
    
    public int combination(int a, int b) {
    	// Time Limit Exceeded
    	if(a==1) {
    		return b; 
    	}
    	if(b==1) {
    		return a; 
    	}
    	if(a==b) {
    		return 1;
    	}
    	
    	return combination(a-1, b-1) + combination(a-1, b);
    }
    
    public int uniquePaths2(int m, int n) {
        
    	if(m==1 || n==1) {
    		return 1; 
    	}
    	if(m<=0 || n<=0) {
    		return 0;
    	}
    	
    	int[][] arr = new int[m][n];
    	
    	for(int i=0; i<m; i++) {
    		for(int j=0; j<n; j++) {
    			
    			if(i==0 || j==0) {
    				arr[i][j] = 1;
    			} else {
    				arr[i][j] = arr[i-1][j] + arr[i][j-1];
    			}
    			
    		}
    	}
    	
    	return arr[m-1][n-1];
    }
}
