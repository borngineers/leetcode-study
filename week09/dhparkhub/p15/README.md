# [Leetcode] 15. 3Sum

배열의 원소 중 3개를 뽑아 합의 `0`이 되는 조합의 개수를 찾아 반환한다.

## Solution

3개의 합이 `0`이 되는 문제를 2개의 합이 `0`이 되는 문제로 바꾸기 위해 임의의 두 수를 뽑아 더하고 나머지 하나의 숫자와 더했을 때 `0`이 되는 경우의 수를 구한다. 배열을 정렬하고 3중 반복문을 사용하여 첫 번째 수와 두 번째 수를 선택하고 배열의 나머지 원소 중에서 세 수의 합이 `0`을 만족하는 숫자를 이진 탐색으로 찾는다. 중복된 케이스를 방지하기 위해 첫 번째 수와 두 번째 수를 뽑을 때 이전과 같은 숫자가 뽑힌다면 넘어간다.

```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);// O(N * logN)

        List<List<Integer>> answer = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i - 1 >= 0 && nums[i] == nums[i - 1]) continue;// skip same case

            for (int j = i + 1; j < nums.length - 1; j++) {
                if (j - 1 >= i + 1 && nums[j] == nums[j - 1]) continue;// skip same case

                int twoSum = nums[i] + nums[j];
                int tempIndex = Arrays.binarySearch(nums, j + 1, nums.length, -twoSum);
                if (tempIndex < 0) continue;
                answer.add(Arrays.asList(nums[i], nums[j], -twoSum));// O(logN)
            }
        }// O(N^2 * logN)

        return answer;
    }
}
```

| Time Complexity | Runtime | Memory |
|-----------------|---------|--------|
| O(N^2 * logN) | 95 ms | 43.3 MB |
