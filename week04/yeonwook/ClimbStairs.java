package practice;

public class Solution3 {
	
	public static void main(String args[]) {
		
		int a = 44;
		System.out.println(climbStairs(a));
		
		//int b = 8;
		//System.out.println(climbStairs(b));
		
	}
	
    public static int climbStairs(int n) {
    	
    	if(n<=0 || n==1 || n==2) {
    		return n;
    	} 
    	/*
    	return climbStairs(n-1)+climbStairs(n-2);
    	*/
    	
    	int climb1 = 1;
    	int climb2 = 2;
    	int result = 0;
    	
    	for(int i=0; i<n-2; i++) {
    		result = climb1 + climb2;
    		climb1 = climb2;
    		climb2 = result;
    	}
    	
    	return result;
    }
}
