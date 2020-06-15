package leetcode.week03;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class S020 {
    public boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }

        final Map<Character, Character> openSet = new HashMap<Character, Character>() {{
            put('(', ')');
            put('{', '}');
            put('[', ']');
        }};

        final Stack<Character> stack = new Stack<>();
        final int size = s.length();

        for (int i = 0; i < size; i++) {
            char c = s.charAt(i);

            if(openSet.containsKey(c)){
                stack.push(c);
                continue;
            }

            if(stack.isEmpty()){
                return false;
            }

            if(openSet.get(stack.peek()) == c){
                stack.pop();
                continue;
            }

            return false;
        }

        return stack.isEmpty();
    }
}
