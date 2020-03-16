package problem1952;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt();
        for (int i = 1; i <= tc; i++) {
            for (int j = 0; j < 4; j++) {
                solution.cost[j] = scanner.nextInt();
            }
            for (int j = 0; j < 12; j++) {
                solution.plan[j] = scanner.nextInt();
            }
            int answer = solution.solve();
            System.out.println(String.format("#%d %d", i, answer));
        }
    }

    private int getMinCost(int month, int total) {
        if (month >= 12) return total;
        if (plan[month] == 0) return getMinCost(month + 1, total);
        int case1 = getMinCost(month + 1, total + plan[month] * cost[0]);
        int case2 = getMinCost(month + 1, total + cost[1]);
        int case3 = getMinCost(month + 3, total + cost[2]);
        return Math.min(case1, Math.min(case2, case3));
    }

    private int solve() {
        return Math.min(cost[3], getMinCost(0, 0));
    }

    private int[] cost = new int[4];
    private int[] plan = new int[12];

}