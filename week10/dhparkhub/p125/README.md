# [Leetcode] 125. Valid Palindrome

주어진 문자열이 `Palindrome`인지 반환한다.

## Solution 1

문자열에서 영대소문자와 숫자를 제외한 나머지 문자를 제거하고 남은 문자열이 `Palindrome`인지 체크한다. 문자열의 양쪽 끝에서 서로 대칭인 문자가 같은지 체크하는 방식으로 `Palindrome`을 판별한다.

```java
class Solution {
    public boolean isPalindrome(String s) {
        String temp = s.replaceAll("[^a-zA-Z0-9]", "").toUpperCase();
        int i = 0;
        int j = temp.length() - 1;
        while (i < j) {
            if (temp.charAt(i) != temp.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
```

| Time Complexity | Runtime | Memory |
|-----------------|---------|--------|
| O(N) | 24 ms | 40.2 MB |

## Solution 2

주어진 문자열의 양쪽 끝에서 서로 대칭인 문자를 비교하여 `Palindrome`을 판별한다. 단 영대소문자나 숫자가 아닌 경우 무시하고 진행한다.

```java
class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            while (i < s.length() && !isAlphanumeric(s.charAt(i))) {
                i++;
            }
            while (j >= 0 && !isAlphanumeric(s.charAt(j))) {
                j--;
            }
            if (i == s.length() || j == -1) return true;
            char x = Character.toUpperCase(s.charAt(i));
            char y = Character.toUpperCase(s.charAt(j));
            if (x != y) return false;
            i++;
            j--;
        }
        return true;
    }

    private Boolean isAlphanumeric(char x) {
        return (x >= 'a' && x <= 'z') || (x >= 'A' && x <= 'Z') || (x >= '0' && x <= '9');
    }
}
```

| Time Complexity | Runtime | Memory |
|-----------------|---------|--------|
| O(N) | 2 ms | 39.8 MB |
