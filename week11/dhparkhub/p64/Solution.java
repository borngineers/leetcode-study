package solved.p64;

class Solution {
    private int[][] grid;
    private int[][] cache;

    public int minPathSum(int[][] grid) {
        this.grid = grid;
        int maxRow = grid.length;
        int maxCol = grid[0].length;
        cache = new int[maxRow][maxCol];
        return getMinPathSum(maxRow - 1, maxCol - 1);
    }

    private int getMinPathSum(int r, int c) {
        if (r == 0 && c == 0) return grid[r][c];
        if (cache[r][c] != 0) return cache[r][c];
        if (r == 0) return cache[r][c] = grid[r][c] + getMinPathSum(r, c - 1);
        if (c == 0) return cache[r][c] = grid[r][c] + getMinPathSum(r - 1, c);
        return cache[r][c] = grid[r][c] + Math.min(getMinPathSum(r - 1, c), getMinPathSum(r, c - 1));
    }
}