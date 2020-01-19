package week03;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LongestSubStringWithoutRepeatingCharacters {

    public static void main(String[]args) {

        System.out.println(lengthOfLongestSubstring("abcabcdbabsdgb"));   // 6

        System.out.println(lengthOfLongestSubstring("abbccccc"));         // 2

        System.out.println(lengthOfLongestSubstring("aab"));              // 2

        System.out.println(lengthOfLongestSubstring("abcabcbb"));         // 3

        System.out.println(lengthOfLongestSubstring("acb"));              // 3

        System.out.println(lengthOfLongestSubstring("ohomm"));          // 3

        System.out.println(lengthOfLongestSubstring("tmmzuxt"));          // 3
    }

    public static int lengthOfLongestSubstring(String s) {

        final int length = s.length();

        if (length == 0) {
            return 0;
        }

        final Map<Character, Integer> map = new HashMap<>();
        final Queue<Character> queue = new LinkedList<>();

        int maxLength = 1;
        int startIndex = 0;
        map.put(s.charAt(0), 0);
        queue.add(s.charAt(0));

        for(int i = 1; i < length; i++){

            final char ch = s.charAt(i);

            if(map.containsKey(ch)){

                final int foundIndex = map.get(ch);
                maxLength = (maxLength > (i - startIndex)) ? maxLength : (i - startIndex);

                while(!queue.isEmpty()) {

                    final char element = queue.poll();
                    map.remove(element);

                    if(element == ch){
                        break;
                    }
                }

                startIndex = foundIndex + 1;
            }

            map.put(ch, i);
            queue.add(ch);
        }

        maxLength = (maxLength > queue.size()) ? maxLength : queue.size();

        return maxLength;
    }
}
