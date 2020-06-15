package leetcode.week06;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class S056 {

    public static void main(String[] args) {

    }

    public static int[][] merge(int[][] intervals) {

        // 정렬
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        final Stack<Integer[]> stack = new Stack<>();
        final int intervalSize = intervals.length;
        for(int index = 0; index < intervalSize; index++){
            final int[] interval = intervals[index];

            if(stack.isEmpty()){
                stack.push(new Integer[]{interval[0], interval[1]});
                continue;
            }

            final Integer[]lastInterval = stack.pop();

            if(lastInterval[1] >= interval[0]){
                stack.push(new Integer[]{lastInterval[0], Math.max(lastInterval[1], interval[1])});
                continue;
            }

            // lastInterval[1] < interval[0])
            stack.push(lastInterval);
            stack.push(new Integer[]{interval[0], interval[1]});
        }

        final int size = stack.size();
        int lastIndex = size - 1;
        final int[][] mergeIntervals = new int[size][2];

        while(!stack.isEmpty()){
            final Integer[] interval = stack.pop();
            mergeIntervals[lastIndex][0] = interval[0];
            mergeIntervals[lastIndex][1] = interval[1];
            lastIndex--;
        }

        return mergeIntervals;
    }
}
