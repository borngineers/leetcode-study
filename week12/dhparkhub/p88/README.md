# [Leetcode] 88. Merge Sorted Array

정렬된 2개의 배열을 하나로 병합한다.

## Solution 1

`nums1` 배열의 남은 공간에 `nums2` 배열의 원소를 입력한 다음 `nums1` 배열을 정렬한다.

```java
import java.util.Arrays;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[i-m];
        }
        Arrays.sort(nums1);
    }
}
```

| Time Complexity | Runtime | Memory |
|-----------------|---------|--------|
| O(MNlogMN) | 0 ms | 40 MB |

## Solution 2

`nums1` 배열의 마지막 인덱스부터 `nums1` 배열과 `nums2` 배열의 원소 중 큰 원소를 순차적으로 채워나간다. `nums2` 배열의 원소를 모두 쓸 경우 `nums1` 배열을 정렬되어 있는 상태이니 함수를 종료하면 된다.

```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (true) {
            if (j < 0) break;
            if (i < 0 || nums1[i] < nums2[j]) {
                nums1[k--] = nums2[j--];
                continue;
            }
            nums1[k--] = nums1[i--];
        }
    }
}
```

| Time Complexity | Runtime | Memory |
|-----------------|---------|--------|
| O(MN) | 0 ms | 39.9 MB |
