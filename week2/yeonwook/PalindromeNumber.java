public class PalindromeNumber {

    public static boolean isPalindromeByNotUsingString(int x) {
    	
    	if(x<0) {
    		return false;
        } 
    	
    	int target = x;
    	int remainder = 0;
    	int qoutient = 99999;
    	int result = 0;
    	int i = (int)(Math.log10(x));
    	
    	while(i>=0) {
    		remainder = target % 10;
    		qoutient = target / 10;
    		target = qoutient;
    		
    		if((result + remainder*Math.pow(10, i)) > Math.pow(2,31)-1 ||
    				(result + remainder*Math.pow(10, i)) < Math.pow(2,31)*-1) {
    			return false;
    		} 
    		
    		result += remainder*Math.pow(10, i);
    		
    		i--;
    	}
    	
    	if(result==x) {
    		return true;
    	} else {
    		return false;
    	}
        
    }
}