package leetcode.week04;

public class S005 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("abb"));
    }

    static int resultStart = 0;
    static int resultLength = 0;

    // reference : https://www.youtube.com/watch?v=DK5OKKbF6GI
    public static String longestPalindrome(String s) {
        resultStart = 0;
        resultLength = 0;
        int length = s.length();

        if(length == 1){
            return s;
        }

        for(int start = 0; start < length - 1; start++){
            expandRange(s, start, start);
            expandRange(s, start, start + 1);
        }

        return s.substring(resultStart, resultStart + resultLength);
    }
    private static void expandRange(String str, int begin, int end){
        while(begin >= 0 && end < str.length()
                && str.charAt(begin) == str.charAt(end)) {
            begin--;
            end++;
        }

        if(resultLength < end - begin - 1) {
            resultStart = begin + 1;
            resultLength = end - begin - 1;
        }
    }
}
