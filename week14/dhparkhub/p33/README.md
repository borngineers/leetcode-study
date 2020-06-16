# [Leetcode] 33. Search in Rotated Sorted Array

주어진 배열에서 원하는 `Target`의 값을 찾아 그 인덱스를 반환한다.

## Solution

배열이 길이가 0이거나 1인 경우에는 손쉽게 정답을 찾을 수 있다. 또한 `Pivot`이 첫 번째 원소인 경우, 즉 오름차순 배열인 경우 전체 배열에서 이진 탐색을 통해 `Target` 값을 찾아 인덱스를 반환하면 된다.

문제는 `Pivot`을 중심으로 배열의 오름차순이 흐트러졌을 경우, 원래 배열에서의 최소 원소를 찾아야 한다.

```java
// find minimum number's index
int l = 0, r = nums.length - 1;
while (l < r) {
    int m = l + (r - l) / 2;
    if (nums[m] > nums[r]) {
        l = m + 1;
        continue;
    }
    r = m;
}// O(logN)
```

최소 원소를 찾았으면, 해당 원소를 기점으로 양쪽이 오름차순 배열이 된다. 이때 `Target`의 값이 인덱스가 0인 원소보다 같거나 크다면 최소 원소를 기준으로 왼쪽 편을 탐색하면 되고, 반대라면 오른쪽을 찾으면 된다. 만약 `Target` 원소를 찾지 못한다면 -1을 반환한다.

```java
class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return nums[0] == target ? 0 : -1;

        // ascending case
        if (nums[0] < nums[nums.length - 1]) {
            int index = Arrays.binarySearch(nums, 0, nums.length, target);// O(logN)
            return index >= 0 ? index : -1;
        }

        // find minimum number's index
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] > nums[r]) {
                l = m + 1;
                continue;
            }
            r = m;
        }// O(logN)

        int index = 0;
        if (target >= nums[0]) {
            index = Arrays.binarySearch(nums, 0, l, target);// O(logN)
        } else {
            index = Arrays.binarySearch(nums, l, nums.length, target);// O(logN)
        }

        return index >= 0 ? index : -1;
    }
}
```

| Time Complexity | Runtime | Memory |
|-----------------|---------|--------|
| O(logN) | 0 ms | 39.1 MB |
