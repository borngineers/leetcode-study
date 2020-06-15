import java.util.*;

public class LeetCode56 {
    /**
     * 56. Merge Intervals
     * https://leetcode.com/problems/merge-intervals/
     * <p>
     * Example 1:
     * Input: [[1,3],[2,6],[8,10],[15,18]]
     * Output: [[1,6],[8,10],[15,18]]
     * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
     * <p>
     * Example 2:
     * Input: [[1,4],[4,5]]
     * Output: [[1,5]]
     * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
     */

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] result = solution.merge(new int[][]{
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        }); // [[1,6],[8,10],[15,18]]
        for (int[] item : result) {
            System.out.println(item[0] + " / " + item[1]);
        }
        System.out.println("---");

        result = solution.merge(new int[][]{
                {1, 4},
                {0, 4}
        }); // [[0, 4]]
        for (int[] item : result) {
            System.out.println(item[0] + " / " + item[1]);
        }
        System.out.println("---");

        result =solution.merge(new int[][]{
                {1, 4},
                {0, 0}
        }); // [[0, 0], [1, 4]]
        for (int[] item : result) {
            System.out.println(item[0] + " / " + item[1]);
        }
        System.out.println("---");

        result = solution.merge(new int[][]{
                {1, 4},
                {0, 5}
        }); // [[0, 5]]
        for (int[] item : result) {
            System.out.println(item[0] + " / " + item[1]);
        }
        System.out.println("---");

        result = solution.merge(new int[][]{
                {2, 3},
                {4, 5},
                {6, 7},
                {8, 9},
                {1, 10}
        }); // [[1, 10]]
        for (int[] item : result) {
            System.out.println(item[0] + " / " + item[1]);
        }
        System.out.println("---");
    }

    static class Solution {
        // Runtime: 2 ms, faster than 99.61% of Java online submissions for Merge Intervals.
        // Memory Usage: 41.1 MB, less than 59.42% of Java online submissions for Merge Intervals.
        public int[][] merge(int[][] intervals) {
            Queue<Pair> pairQueue = new LinkedList<>();

            for (int i = 0; i < intervals.length; i++) {
                Pair newPair = new Pair(intervals[i]);
                if (pairQueue.size() > 0) {
                    int queueSize = pairQueue.size();
                    for (int j = 0; j < queueSize; j++) {
                        Pair prevPair = pairQueue.poll();
                        if (newPair.isNotOverlapWithNextPair(prevPair)) {
                            pairQueue.add(prevPair);
                        } else {
                            newPair.mergePair(prevPair);
                        }
                    }
                }
                pairQueue.add(newPair);
            }
            int[][] ret = new int[pairQueue.size()][];
            for (int i = 0; i < ret.length; i++) {
                Pair item = pairQueue.poll();
                ret[i] = new int[]{item.a, item.b};
            }
            return ret;
        }
    }

    static class Pair {
        int a;
        int b;
        public Pair(int[] num) {
            this.a = num[0];
            this.b = num[1];
        }
        public boolean isNotOverlapWithNextPair(Pair newItem) {
            return (newItem.a < this.a && newItem.b < this.a) || (this.b < newItem.a && this.b < newItem.b);
        }
        public void mergePair(Pair nextItem) {
            this.a = Math.min(this.a, nextItem.a);
            this.b = Math.max(this.b, nextItem.b);
        }
    }
}
