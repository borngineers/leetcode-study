package problem1949;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt();
        for (int i=1; i<=tc; i++) {
            solution.n = scanner.nextInt();
            solution.k = scanner.nextInt();

            solution.init();

            for (int r=0; r<solution.n; r++) {
                for (int c=0; c<solution.n; c++) {
                    solution.map[r][c] = scanner.nextInt();
                    solution.h = Math.max(solution.h, solution.map[r][c]);
                }
            }

            int answer = solution.solve();
            System.out.println(String.format("#%d %d", i, answer));
        }
    }

    private void init() {
        h = 0;
        for (int r=0; r<n; r++) {
            for (int c=0; c<n; c++) {
                visited[r][c] = false;
            }
        }
    }

    private boolean valid(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }

    private int getMaxPath(int r, int c, boolean cheat) {
//        String out = String.format("(%d %d %s)", r, c, cheat ? "true" : "false");
//        System.out.println(out);

        visited[r][c] = true;
        int temp = 0;
        for (int i=0; i<4; i++) {
            int mr = r + MR[i];
            int mc = c + MC[i];
            if (!valid(mr, mc)) continue;
            if (visited[mr][mc]) continue;
            if (map[mr][mc] < map[r][c]) {
                temp = Math.max(temp, getMaxPath(mr, mc, cheat));
                continue;
            }
            if (cheat) continue;
            for (int j=1; j<=k; j++) {
                if (map[mr][mc] - j >= 0 && map[mr][mc] - j < map[r][c]) {
                    map[mr][mc] -= j;
                    temp = Math.max(temp, getMaxPath(mr, mc, true));
                    map[mr][mc] += j;
                    break;
                }
            }
        }
        visited[r][c] = false;
        return 1 + temp;
    }

    private int solve() {
        int answer = 0;
        for (int r=0; r<n; r++) {
            for (int c=0; c<n; c++) {
                if (map[r][c] == h) {
                    answer = Math.max(answer, getMaxPath(r, c, false));
//                    System.out.println(String.format("%d %d: %d", r, c, getMaxPath(r, c, false)));
                }
            }
        }
        return answer;
    }

    private int n, k, h;
    private int[][] map = new int[8][8];
    private boolean[][] visited = new boolean[8][8];

    private static final int[] MR = {0, 0, -1, 1};
    private static final int[] MC = {-1, 1, 0, 0};

}