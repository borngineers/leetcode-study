package leetcode.week09;

import java.util.Arrays;

public class S344 {
    public static void main(String[] args) {
        reverseString(new char[]{'h', 'e', 'l', 'l', 'o'});
        reverseString(new char[]{'n','e','t'});
        reverseString(new char[]{'m','o','s','s'});
    }

    public static void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        int middle = s.length / 2;

        for(int i = 0; i < middle; i++){
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }

        System.out.println(Arrays.toString(s));
    }
}
