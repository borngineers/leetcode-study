# [Leetcode] 22. Generate Parentheses

주어진 괄호 쌍을 가지고 유효한 괄호 문자열을 배열에 담아 반환한다.

## Solution

기본적으로 조합을 사용하여 문제를 해결한다. 여는 괄호는 최대 `N`개까지 사용할 수 있으며 여는 괄호를 쓸 때마다 여는 괄호를 쓴 개수를 카운트한다. 닫는 괄호 역시 쓴 개수를 카운트하나 여는 괄호보다 적게 썼을 경우에만 닫는 괄호를 카운트할 수 있다. 여는 괄호를 다 사용하면 문자열의 뒷부분에 짝이 필요한 만큼 닫는 괄호 문자를 이어붙여 리스트에 추가한다.

```java
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
```

| Time Complexity | Runtime | Memory |
|-----------------|---------|--------|
| - | 1 ms | 39.6 MB |
