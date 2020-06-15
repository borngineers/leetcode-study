package problem1949;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Resolver resolver = new Resolver();
        int t, n, k;
        int[][] map = new int[8][8];

        Scanner scanner = new Scanner(System.in);
        t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            n = scanner.nextInt();
            k = scanner.nextInt();
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    map[r][c] = scanner.nextInt();
                }
            }
            resolver.init(n, k, map);
            int answer = resolver.resolve();
            System.out.println(String.format("#%d %d", i, answer));
        }
    }

    static class Resolver {

        final int[] MR = {0, 0, -1, 1};
        final int[] MC = {-1, 1, 0, 0};

        int n, k, h;
        int[][] map = new int[8][8];
        boolean[][] visited = new boolean[8][8];

        void init(int n, int k, int[][] map) {
            this.n = n;
            this.k = k;
            this.map = map;
            this.h = 0;
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    h = Math.max(h, map[r][c]);
                    visited[r][c] = false;
                }
            }
        }

        boolean valid(int r, int c) {
            return r >= 0 && r < n && c >= 0 && c < n;
        }

        int getMaxPath(int r, int c, boolean cheat) {
            visited[r][c] = true;
            int temp = 0;
            for (int i = 0; i < 4; i++) {
                int mr = r + MR[i];
                int mc = c + MC[i];
                if (!valid(mr, mc)) continue;
                if (visited[mr][mc]) continue;
                if (map[mr][mc] < map[r][c]) {
                    temp = Math.max(temp, getMaxPath(mr, mc, cheat));
                    continue;
                }
                if (cheat) continue;
                for (int j = 1; j <= k; j++) {
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

        int resolve() {
            int answer = 0;
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    if (map[r][c] == h) {
                        answer = Math.max(answer, getMaxPath(r, c, false));
                    }
                }
            }
            return answer;
        }
    }

}