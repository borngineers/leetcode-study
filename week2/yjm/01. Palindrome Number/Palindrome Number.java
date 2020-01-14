class Solution {
    public boolean isPalindrome(int x) {
        if ( x < 0 ) return false;
        String str_x = "" + x;
        int str_x_len = str_x.length();
        int last_idx_x = str_x_len - 1;
        for ( int i = 0; i < str_x_len / 2; i++ ) {
            if ( str_x.charAt(i) != str_x.charAt(last_idx_x - i) ) {
                return false;
            }
        }
        return true;
    }
}