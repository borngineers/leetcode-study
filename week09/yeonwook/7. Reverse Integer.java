class Solution {
    public int reverse(int x) {
        
        int remainder = 0;
        int quotient = Integer.MAX_VALUE;
        
        int len = String.valueOf(x).length();
        len = (x<0) ? len -1 : len;
        
        int answer = 0;
        
        for(int i=len-1; i>=0; i--) {
            
            quotient = x / 10;
            remainder = x % 10;
            
            if(answer + remainder * Math.pow(10,i) < Integer.MIN_VALUE ||
              answer + remainder * Math.pow(10,i) > Integer.MAX_VALUE) {
                return 0;
            }
                
            answer += remainder * Math.pow(10, i);
            
            x = quotient;
            
        }
        
        return answer;
    }
}
