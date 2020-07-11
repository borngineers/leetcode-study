import java.util.ArrayList;
import java.util.List;

public class LeetCode54 {
    /**
     * 54. Spiral Matrix
     * https://leetcode.com/problems/spiral-matrix/
     *
     * Example 1:
     * Input:
     * [
     *  [ 1, 2, 3 ],
     *  [ 4, 5, 6 ],
     *  [ 7, 8, 9 ]
     * ]
     * Output: [1,2,3,6,9,8,7,4,5]
     *
     * Example 2:
     * Input:
     * [
     *   [1, 2, 3, 4],
     *   [5, 6, 7, 8],
     *   [9,10,11,12]
     * ]
     * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
     */

    public static void main(String[] args) {
        Solution solution = new Solution();

        List<Integer> result = solution.spiralOrder(new int[][]{{1,2,3}, {4,5,6}, {7,8,9}});  // [1,2,3,6,9,8,7,4,5]
        for (int a : result) {
            System.out.print(a + " / ");
        }
        System.out.println("");

        result = solution.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9,10,11,12}});  // [1,2,3,4,8,12,11,10,9,5,6,7]
        for (int a : result) {
            System.out.print(a + " / ");
        }
        System.out.println("");
    }

    static class Solution {
        int gRow = 0;
        int gCol = 0;
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> result = new ArrayList<>();
            gRow = matrix.length;
            if (gRow < 1) {
                return result;
            }
            gCol = matrix[0].length;

            int totalSize = gRow * gCol;
            boolean[][] cache = new boolean[gRow][gCol];

            int[] rowCondition = new int[]{0,1,0,-1};
            int[] colCondition = new int[]{1,0,-1,0};

            int selectRow = 0;
            int selectCol = 0;

            result.add(matrix[selectRow][selectCol]);
            cache[selectRow][selectCol] = true;

            while (result.size() < totalSize) {
                for (int i = 0; i < 4; i++) {
                    while (isValidIndex(selectRow + rowCondition[i], selectCol + colCondition[i])) {
                        if (cache[selectRow + rowCondition[i]][selectCol + colCondition[i]]) {
                            break;
                        }
                        selectRow += rowCondition[i];
                        selectCol += colCondition[i];

                        result.add(matrix[selectRow][selectCol]);
                        cache[selectRow][selectCol] = true;
                    }
                }
            }
            return result;
        }

        private boolean isValidIndex(int row, int col) {
            return (0 <= row && row < gRow) && (0 <= col && col < gCol);
        }
    }
}
