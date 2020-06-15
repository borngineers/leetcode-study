package week02;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by pasudo123 on 2020-01-09
 * Email: oraedoa@gmail.com
 **/
public class ValidParentheses {

    private static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    private static BufferedReader reader = new BufferedReader(inputStreamReader);

    private static OutputStreamWriter outputStreamWriter = new OutputStreamWriter(System.out);
    private static BufferedWriter writer = new BufferedWriter(outputStreamWriter);

    public static void main(String[] args) throws IOException {

        writer.write(isValid("()") + "");
        writer.newLine();

        writer.write(isValid("()[]{}") + "");
        writer.newLine();

        writer.write(isValid("(}") + "");
        writer.newLine();

        writer.write(isValid("]") + "");
        writer.newLine();

        writer.write(isValid("") + "");
        writer.newLine();

        writer.flush();
    }

    public static boolean isValid(String s) {

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
