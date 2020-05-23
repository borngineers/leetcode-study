class Solution {
    public boolean isPalindrome(String s) {
        
        int len = s.length();
        if(len == 0 || len == 1) return true;
        
        s = s.toLowerCase();
        char[] charArr = s.toCharArray();
        int left = 0;
        int right = len - 1;
        
        while(left<right) {
            
            while(left<right && !((charArr[left] >= 'a' && charArr[left] <= 'z') 
                || (charArr[left] >= '0' && charArr[left] <= '9'))) {
                left++;
            }
            while(left<right && !((charArr[right] >= 'a' && charArr[right] <= 'z') 
                || (charArr[right] >= '0' && charArr[right] <= '9'))) {
                right--;
            }
            
            if(charArr[left] != charArr[right]) {
                return false;
            } 
            
            left ++;
            right --;
        }
        
        return true;
    }
}

---
    
class Solution {
    public boolean isPalindrome(String s) {
        
        String match = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]";
        s = s.replaceAll(match, "");
        s = s.replaceAll(" ", "");
        s = s.toLowerCase();
        
        int len = s.length();
        if(len == 0 || len == 1) return true;
        
        char[] charArr = s.toCharArray();
        int left = 0;
        int right = len - 1;
        
        while(left<right) {
            
            if(charArr[left] != charArr[right]) {
                return false;
            } 
            
            left ++;
            right --;
        }
        
        return true;
    }
}
