class Solution {
    public String longestPalindrome(String s) {
        
        int len = s.length();
        
        if(len == 0) {
            return "";
        }
        
        char[] arr = s.toCharArray();
        String temp1 = "";
        String temp2 = "";
        String answer = "";
        
        for(int i = 0; i<len-1; i++) {
            
            // aa pattern
            if(arr[i] == arr[i+1]) {
                temp1 = findPalindromic(s, i, i+1);
            }
            
            // aba pattern
            if(i != len-2 && arr[i] == arr[i+2]) {
                temp2 = findPalindromic(s, i, i+2);
            }
            
            if( temp1.length() < temp2.length() ){
                temp1 = temp2;
            }
            
            if( temp1.length() > answer.length() ){
                answer = temp1;
            }
        }
        
        if(temp1 == "") {
            return String.valueOf(arr[0]);
        }
        
        return answer;
    }
    
    public String findPalindromic(String s, int leftIndex, int rightIndex) {
        
        int len = s.length();
        char[] arr = s.toCharArray();
        
        while(leftIndex > 0 && rightIndex < len-1) {
            
            if(arr[leftIndex-1] == arr[rightIndex+1]) {
                leftIndex--;
                rightIndex++;
                continue;
            }
            break;
        }
        
        return s.substring(leftIndex, rightIndex+1);
    }
    
}
