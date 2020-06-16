# [Leetcode] 14. Longest Common Prefix

주어진 문자열들의 공통 접두어 중 가장 긴 문자열을 반환한다.

## Solution

임의의 문자열 하나를 기준으로 잡고 첫 번째 문자부터 탐색하면서 나머지 문자열과 공통 접두어가 있는지 탐색해 나간다.

```java
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        StringBuilder sb = new StringBuilder();
        String temp = strs[0];
        for (int i = 0; i < temp.length(); i++) {
            boolean canAdd = true;
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || temp.charAt(i) != strs[j].charAt(i)) {
                    canAdd = false;
                    break;
                }
            }
            if (!canAdd) break;
            sb.append(temp.charAt(i));
        }
        return sb.toString();
    }
}
```

| Time Complexity | Runtime | Memory |
|-----------------|---------|--------|
| - | 1 ms | 37.6 MB |
