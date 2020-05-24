package p56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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