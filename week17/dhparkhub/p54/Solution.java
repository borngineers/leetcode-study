package p54;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private int[][] matrix;
    private final List<Integer> answer = new ArrayList<>();

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return answer;
        }
        this.matrix = matrix;
        int r = 0;
        int c = 0;
        int maxR = matrix.length - 1;
        int maxC = matrix[0].length - 1;
        int maxCnt = (matrix.length - 1) / 2;
        for (int i = 0; i <= maxCnt; i++) {
            print(r++, c++, maxR--, maxC--);
            if (r > maxR || c > maxC) break;
        }
        return answer;
    }

    private void print(int r, int c, int maxR, int maxC) {
        if (r == maxR) {
            for (int i = c; i <= maxC; i++) {
                answer.add(matrix[r][i]);
            }
            return;
        }
        if (c == maxC) {
            for (int i = r; i <= maxR; i++) {
                answer.add(matrix[i][c]);
            }
            return;
        }
        for (int i = c; i < maxC; i++) {
            answer.add(matrix[r][i]);
        }
        for (int i = r; i < maxR; i++) {
            answer.add(matrix[i][maxC]);
        }
        for (int i = maxC; i > c; i--) {
            answer.add(matrix[maxR][i]);
        }
        for (int i = maxR; i > r; i--) {
            answer.add(matrix[i][c]);
        }
    }
}