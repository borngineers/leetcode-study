package leetcode.week07;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class S387 {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("cc"));
    }

    public static int firstUniqChar(String s) {

        if(s.length() == 0){
            return -1;
        }

        final Map<Character, Object> charMap = new LinkedHashMap<>();
        final Map<Character, Boolean> map = new LinkedHashMap<>();
        final Map<Character, Integer> indexMap = new LinkedHashMap<>();
        final char[] array = s.toCharArray();
        int index = 0;
        for(char c : array){
            boolean isExist = map.getOrDefault(c, Boolean.FALSE);
            if(isExist){
                charMap.remove(c);
                index++;
                continue;
            }

            charMap.put(c, new Object());
            map.put(c, Boolean.TRUE);
            indexMap.put(c, index++);
        }

        if(charMap.size() == 0){
            return -1;
        }

        return indexMap.get(charMap.keySet().iterator().next());
    }
}
