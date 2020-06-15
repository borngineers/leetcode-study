# [Leetcode] 3. Longest Substring Without Repeating Characters

임의의 문자열에 대하 `substring` 중 같은 문자가 하나도 없는 `substring`의 최대 길이를 반환한다.

## Solution

문자열을 순차적으로 탐색하면서 `substring`을 시작할 문자의 인덱스를 저장하고, 각 문자에 대해 인덱스를 `HashMap`에 저장한다. 임의의 문자를 탐색할 때 해당 문자가 한 번도 나오지 않았거나, 나왔어도 시작 인덱스부다 작다면 `substring`을 계속 이어나간다. 만약 해당 문자가 존재하고 시작 인덱스보다 같거나 크다면 `substring`을 갱신하고 시작 인덱스를 1 증가시킨다. 반복문이 끝났을 때, 마지막 `substring`을 빼먹을 수도 있기 때문에 한 번 더 계산해준다.

```java
class Solution {
    private final Map<Character, Integer> indexMap = new HashMap<>();

    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int startIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            char tempChar = s.charAt(i);
            if (indexMap.containsKey(tempChar) && indexMap.get(tempChar) >= startIndex) {
                maxLength = Math.max(maxLength, i - startIndex);
                startIndex = indexMap.get(tempChar) + 1;
            }
            indexMap.put(tempChar, i);
        }
        return Math.max(maxLength, s.length() - startIndex);
    }
}
```

| Time Complexity | Runtime | Memory |
|-----------------|---------|--------|
| O(N) | 6 ms | 39.5 MB |
