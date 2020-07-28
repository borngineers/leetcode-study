import java.util.*;

public class LeetCode118 {
    /**
     * 118. Pascal's Triangle
     * https://leetcode.com/problems/pascals-triangle/
     *
     * Example:
     * Input: 5
     * Output:
     * [
     *      [1],
     *     [1,1],
     *    [1,2,1],
     *   [1,3,3,1],
     *  [1,4,6,4,1]
     * ]
     * */
    public static void main(String[] args) {
        Solution solution = new Solution();

        List<List<Integer>> result = solution.generate(5);
        for (List<Integer> cell : result) {
            for (int a : cell) {
                System.out.print(a + " / ");
            }
            System.out.println("");
        }
    }

    static class Solution {
//        Runtime: 1 ms, faster than 40.67% of Java online submissions for Pascal's Triangle.
//        Memory Usage: 39.2 MB, less than 5.14% of Java online submissions for Pascal's Triangle.
        public List<List<Integer>> generate(int numRows) {
            if (numRows == 0) { return new ArrayList<>(); }
            return calcPascal(numRows);
        }

        public List<List<Integer>> calcPascal(int num) {
            if (num == 1) { return new ArrayList<>(Arrays.asList(Arrays.asList(1))); }
            List<List<Integer>> ret = calcPascal(num - 1);
            List<Integer> lastList = ret.get(ret.size() - 1);
            List<Integer> newList = new ArrayList<>();
            int lastListSize = lastList.size();
            int sizeLimit = lastListSize + 1;
            for (int i = 0; i < sizeLimit; i++) {
                if (i == 0 || i == sizeLimit - 1) { newList.add(lastList.get(0)); }
                else {
                    newList.add(lastList.get(i) + lastList.get(i - 1));
                }
            }
            ret.add(newList);
            return ret;
        }
    }
}
