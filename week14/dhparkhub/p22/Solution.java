package published.p22;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private int maxN;
    private final List<String> answer = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        maxN = n;
        generateParenthesis("", 0, 0, 0);
        return answer;
    }

    private void generateParenthesis(String s, int open, int close, int total) {
        if (total == maxN) {
            StringBuilder sb = new StringBuilder(s);
            for (int i = close; i < total; i++) {
                sb.append(')');
            }
            answer.add(sb.toString());
            return;
        }
        if (open == maxN || close == maxN) return;
        generateParenthesis(s + '(', open + 1, close, total + 1);
        if (open > close) {
            generateParenthesis(s + ')', open, close + 1, total);
        }
    }
}