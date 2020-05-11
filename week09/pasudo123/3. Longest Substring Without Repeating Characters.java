package leetcode.week05;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class S003 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));

        System.out.println(lengthOfLongestSubstring("abacdbc"));
        System.out.println(lengthOfLongestSubstring("ab"));

    }

    public static int lengthOfLongestSubstring(String s) {
        final int size = s.length();

        if(size == 0){
            return 0;
        }

        if(size == 1){
            return 1;
        }

        final Map<Character, Integer> set = new HashMap<>();
        final Queue<Character> queue = new LinkedList<>();
        int maxLength = -1;

        for(int index = 0; index < size; index++){
            final char c = s.charAt(index);

            if(!set.containsKey(c)){
                queue.add(c);
                set.put(c, index);
                continue;
            }

            maxLength = Math.max((index - 1) - set.get(queue.peek()) + 1, maxLength);

            while(!queue.isEmpty()){
                final char popChar = queue.poll();
                set.remove(popChar);

                if(popChar == c){
                    break;
                }
            }

            queue.add(c);
            set.put(c, index);
        }

        return Math.max(maxLength, queue.size());
    }
}
