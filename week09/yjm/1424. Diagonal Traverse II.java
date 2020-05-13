import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LeetCode1424 {
    /**
     * 1424. Diagonal Traverse II
     * https://leetcode.com/problems/diagonal-traverse-ii/
     *
     * Example 1:
     * Input: nums = [[1,2,3],[4,5,6],[7,8,9]]
     * Output: [1,4,2,7,5,3,8,6,9]
     *
     * Example 2:
     * Input: nums = [[1,2,3,4,5],[6,7],[8],[9,10,11],[12,13,14,15,16]]
     * Output: [1,6,2,8,7,3,9,4,12,10,5,13,11,14,15,16]
     *
     * Example 3:
     * Input: nums = [[1,2,3],[4],[5,6,7],[8],[9,10,11]]
     * Output: [1,4,2,5,3,8,6,9,7,10,11]
     *
     * Example 4:
     * Input: nums = [[1,2,3,4,5,6]]
     * Output: [1,2,3,4,5,6]
     *
     * Constraints:
     * 1 <= nums.length <= 10^5
     * 1 <= nums[i].length <= 10^5
     * 1 <= nums[i][j] <= 10^9
     * There at most 10^5 elements in nums.
     * */

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.findDiagonalOrder2(
                Arrays.asList(
                        Arrays.asList(1,2,3,4,5),
                        Arrays.asList(6,7),
                        Arrays.asList(8),
                        Arrays.asList(9,10,11),
                        Arrays.asList(12,13,14,15,16)
                ));
        for (int a : result) {
            System.out.print(a + ", ");
        }
    }

    static class Solution {
        public int[] findDiagonalOrder(List<List<Integer>> nums) {
            int rowSize = nums.size();
            int max = 0;
            int numCount = 0;
            for (List<Integer> item : nums) {
                numCount += item.size();
                max = Math.max(max, item.size());
            }
            max = Math.max(max, rowSize);

            int[][] map = new int[max][max];

            for (int i = 0; i < max; i++) {
                for (int j = 0; j < max; j++) {
                    if (i < rowSize && j < nums.get(i).size()) {
                        map[i][j] = nums.get(i).get(j);
                    } else {
                        map[i][j] = 0;
                    }
                }
            }

            int[] retList = new int[numCount];
            int addCount = 0;
            for (int i = 0; i < max; i++) {
                int selectedRow = i;
                int col = 0;
                while (selectedRow > -1) {
                    int cellNum = map[selectedRow][col];
                    System.out.print(cellNum + " ");
                    if (cellNum != 0) {
                        retList[addCount] = cellNum;
                        addCount++;
                    }
                    col++;
                    selectedRow--;
                }
            }

            for (int j = 1; j < max; j++) {
                int row = max-1;
                int col = j;
                while (row > -1 && col < max) {
                    int cellNum = map[row][col];
                    if (cellNum != 0) {
                        retList[addCount] = cellNum;
                        addCount++;
                    }
                    col++;
                    row--;
                }
            }

            return retList;
        }

        public int[] findDiagonalOrder2(List<List<Integer>> nums) {
            int rowSize = nums.size();
            int totalCount = 0;
            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

            for (int i = 0; i < rowSize; i++) {
                for (int j = 0; j < nums.get(i).size(); j++) {
                    int key = i + j;
                    if (map.containsKey(key)) {
                        map.get(key).add(0, nums.get(i).get(j));
                    } else {
                        map.put(i + j, new ArrayList<>(Arrays.asList(nums.get(i).get(j))));
                    }
                    totalCount++;
                }
            }

            int[] retList = new int[totalCount];
            int keycount = 0;
            int idx = 0;
            while (map.containsKey(keycount)) {
                for (int cell : map.get(keycount)) {
                    retList[idx] = cell;
                    idx++;
                }
                keycount++;
            }

            return retList;
        }
    }
}
