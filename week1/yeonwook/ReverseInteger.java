public class TwoSum {

	public static void main(String args[]) {
		
		int result = reverse(1563847412);
		System.out.println(result);
	}
	
	
    public static int reverse(int x) {
    	int result = 0;
        
    	int remainder = 0;
    	int quotient = 0;
    	int temp = x;
    	int len = 0;
    	
    	if(x<0) {
    		len = String.valueOf(x).length()-2;
        } else {
        	len = String.valueOf(x).length()-1;
        }
    	for(int i=len; i>=0; i--) {
    		remainder = temp%10;
    		quotient = temp/10;
    		temp = quotient;
    		
    		if((result + remainder*Math.pow(10, i)) > Math.pow(2,31)-1 ||
    				(result + remainder*Math.pow(10, i)) < Math.pow(2,31)*-1) {
    			return 0;
    		} else {
    			result += remainder*Math.pow(10, i);
    		}
    		
    	}
        
        return result;
    }
}