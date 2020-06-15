# [Leetcode] 7. Reverse Integer

주어진 정수를 역전한 수를 반환한다.

## Solution

나머지 연산자를 통해 낮은 자리수부터 계속 더해간다. 이때, 자리수가 하나씩 올라갈수록 더해가는 수에 10을 곱해 낮은 자리수의 위상을 높여준다. 예를 들어 `1234`는 다음과 같이 계산될 수 있다.

```
((4 * 10 + 3) * 10 + 2) * 10 + 1 = 4321
```

나머지 연산자를 음수를 포함하기 때문에 음수가 입력되는 경우에도 정상적으로 동작한다. 다만 역전한 수가 `int` 범위를 초과할 수 있기 때문에 역전한 수를 `long` 타입으로 선언해 저장하고 정답을 반환하기 전에 명시적으로 `int` 형으로 바꾸어 두 수가 같은지 비교한다. 두 수가 다르다면 `overflow`가 발생했다는 뜻이므로 `0`을 반환한다.

```java
class Solution {
    public int reverse(int x) {
        long answer = 0;
        while (x != 0) {
            answer = answer * 10 + x % 10;
            x /= 10;
        }
        return answer == (int) answer ? (int) answer : 0;
    }
}
```

| Time Complexity | Runtime | Memory |
|-----------------|---------|--------|
| O(D) (D: digit) | 1 ms | 36.8 MB |
