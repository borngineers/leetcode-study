package leetcode.week07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S014 {
    public static void main(String[] args) {

    }

    public static String longestCommonPrefix(String[] strs) {
        List<String> list = Arrays.asList(strs);
        if(list.size() == 0){
            return "";
        }

        int minCount = list.stream()
                .mapToInt(String::length)
                .min().getAsInt();

        while(minCount != 0){
            String substr = list.get(0).substring(0, minCount);
            int finalMinCount = minCount;
            boolean isAllMatch = list.stream().map(value -> value.substring(0, finalMinCount))
                    .allMatch(s -> s.equalsIgnoreCase(substr));

            if(isAllMatch){
                return substr;
            }

            minCount--;
        }

        return "";
    }
}
