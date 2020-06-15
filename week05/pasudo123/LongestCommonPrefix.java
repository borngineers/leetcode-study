package week05;

import java.util.*;

public class LongestCommonPrefix {

    public static void main(String[]args) {

        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));

        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));

        System.out.println(longestCommonPrefix(new String[]{"a", "a"}));
    }

    public static String longestCommonPrefix(String[] strs) {

        // runtime : 3ms -> 1ms
        // memory : 39MB -> 37.5MB

        if(strs.length == 0){
            return "";
        }

        if(strs.length == 1) {
            return strs[0];
        }

        List<String> list = new ArrayList<>();

        int minSize = Integer.MAX_VALUE;

        String refValue = "";

        for(String s : strs) {
            if(minSize > s.length()) {
                minSize = s.length();
                refValue = s;
            }

            list.add(s);
        }

        final int length = refValue.length();
        int endIndex = -1;

        for(int i = 0; i < length; i++){

            char ch = refValue.charAt(i);

            for(String s : list) {
                if(ch == s.charAt(i)){
                    continue;
                }

                endIndex = i;
                i = length;
                break;
            }
        }

        return refValue.substring(0, (endIndex == -1) ? refValue.length() : endIndex);
    }
}
