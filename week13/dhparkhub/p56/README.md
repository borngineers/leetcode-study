# [Leetcode] 56. Merge Intervals

간격의 범위들이 주어지고 겹치는 간격을 최대한 합쳐 배열에 담아 반환한다.

## Solution

주어진 간격들을 첫 번째 숫자를 기준으로 오름차순으로 정렬한다. 배열을 순차적으로 탐색하면서 임의의 간격과 겹치거나 연결할 수 있는 간격은 최대한 합친 뒤 리스트에 담는다.

```java
class Solution {
    private final List<List<Integer>> list = new ArrayList<>();

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(o -> o[0]));
        for (int i = 0; i < intervals.length; i++) {
            int startTime = intervals[i][0];
            int endTime = intervals[i][1];
            while (++i < intervals.length) {
                int nStartTime = intervals[i][0];
                int nEndTime = intervals[i][1];
                if (nStartTime > endTime) {
                    i--;
                    break;
                }
                endTime = Math.max(endTime, nEndTime);
            }
            list.add(Arrays.asList(startTime, endTime));
        }

        int[][] answer = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = new int[]{list.get(i).get(0), list.get(i).get(1)};
        }
        return answer;
    }
}
```

| Time Complexity | Runtime | Memory |
|-----------------|---------|--------|
| O(NlogN) | 8 ms | 41.9 MB |
