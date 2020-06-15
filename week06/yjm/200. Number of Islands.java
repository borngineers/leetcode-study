public class LeetCode200 {
    /**
     * 200. Number of Islands
     * https://leetcode.com/problems/number-of-islands/
     *
     * Example 1:
     * Input:
     * 11110
     * 11010
     * 11000
     * 00000
     * Output: 1
     *
     * Example 2:
     * Input:
     * 11000
     * 11000
     * 00100
     * 00011
     * Output: 3
     * */

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] map = new char[4][5];
        map[0] = new char []{'1','1','0','0','0'};
        map[1] = new char []{'1','1','0','0','0'};
        map[2] = new char []{'0','0','1','0','0'};
        map[3] = new char []{'0','0','0','1','1'};
        int result = solution.numIslands(map);
        System.out.println(result);
    }

    static class Solution {
        int[] moveUpDown = new int[]{-1,1,0,0};
        int[] moveLeftRight = new int[]{0,0,-1,1};

        public int numIslands(char[][] grid) {
            if (grid.length == 0) return 0;
            if (grid[0].length == 0) return 0;

            int sumCount = 0;
            int rowSize = grid.length;
            int colSize = grid[0].length;

            for (int i = 0; i < rowSize; i++) {
                for (int j = 0; j < colSize; j++) {
                    if (grid[i][j] == '0') continue;
                    searchMap(grid, i, j);
                    sumCount++;
                }
            }

            return sumCount;
        }

        public void searchMap(char[][] map, int row, int col) {
            map[row][col] = '0';
            for (int i = 0; i < 4; i++) {
                int moveRow = row + moveUpDown[i];
                int moveCol = col + moveLeftRight[i];
                if (!isValid(map, moveRow, moveCol)) continue;
                if (map[moveRow][moveCol] == '0') continue;
                searchMap(map, moveRow, moveCol);
            }
        }

        public boolean isValid(char[][] map, int row, int col) {
            if (0 <= row && row < map.length
                    && 0 <= col && col < map[0].length
                    && map[row][col] == '1') return true;
            return false;
        }
    }

}
