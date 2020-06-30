class Solution {
    public void reverseString(char[] s) {
        
        int len = s.length;
        if(len == 0 || len == 1) {
            return ;
        }
        
        int left = 0;
        int right = len - 1;
        
        while(left < right) {
            
            char temp = s[left];
            
            s[left++] = s[right];
            s[right--] = temp;           
        }
    }
}
