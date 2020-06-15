# [Leetcode] 1424. Diagonal Traverse II

주어진 이차원 배열을 대각선 순회하여 얻은 배열을 반환한다.

## Solution

이차원 배열의 행과 열을 좌표로 봤을 때, 좌표의 합이 같은 것끼리 묶어서 리스트에 담으면 된다. 단, 리스트를 순차적으로 탐색하기 때문에 리스트에는 역순으로 숫자를 담는다. 모든 리스트 크기의 합 만큼 배열을 생성한 다음, 리스트에 담긴 순차적으로 배열에 숫자를 담아 반환한다.

```java
class Solution {
    private final Map<Integer, LinkedList<Integer>> map = new LinkedHashMap<>();

    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int totalSize = 0;
        for (int i = 0; i < nums.size(); i++) {
            totalSize += nums.get(i).size();
            for (int j = 0; j < nums.get(i).size(); j++) {
                int key = i + j;
                int value = nums.get(i).get(j);
                LinkedList<Integer> list = map.getOrDefault(key, new LinkedList<Integer>());
                list.addFirst(value);
                map.put(key, list);
            }
        }

        int[] answer = new int[totalSize];
        int index = 0;
        for (int key : map.keySet()) {
            for (int i : map.get(key)) {
                answer[index++] = i;
            }
        }

        return answer;
    }
}
```

| Time Complexity | Runtime | Memory |
|-----------------|---------|--------|
| - | 43 ms | 65.8 MB |
