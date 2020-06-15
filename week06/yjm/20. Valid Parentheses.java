import java.util.Stack;

public class LeetCode20 {
    /**
     * 20. Valid Parentheses
     * https://leetcode.com/problems/two-sum/
     *
     * Example 1:
     * Input: "()"
     * Output: true
     *
     * Example 2:
     * Input: "()[]{}"
     * Output: true
     *
     * Example 3:
     * Input: "(]"
     * Output: false
     *
     * Example 4:
     * Input: "([)]"
     * Output: false
     *
     * Example 5:
     * Input: "{[]}"
     * Output: true
     * */

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("(]"));
    }

    static class Solution {
        public boolean isValid(String s) {
            if (s.length() % 2 != 0) return false;

            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                if ('(' == c || '{' == c || '[' == c) {
                    stack.push(c);
                    continue;
                }
                if (')' == c || '}' == c || ']' == c) {
                    if (stack.size() == 0) return false;
                    char open = stack.pop();
                    if (open == '(' && c == ')') {
                        continue;
                    } else if (open == '{' && c == '}') {
                        continue;
                    } else if (open == '[' && c == ']') {
                        continue;
                    } else {
                        return false;
                    }
                }
            }
            if (stack.size() == 0) return true;
            return false;
        }
    }
}
