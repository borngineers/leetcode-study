package week05;

public class MinCostClimbingStairs {

    public static void main(String[]args) {

        System.out.println(minCostClimbingStairs(new int[]{10, 15, 20}));

        System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }

    public static int minCostClimbingStairs(int[] cost) {

        // runtime : 0ms
        // memory : 39.4MB

        // s[n] = Max(s[n] + s[n-1], s[n] + s[n-2])

        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        dp[2] = Math.min(cost[2] + dp[0], cost[2] + dp[1]);

        final int size = cost.length;

        for(int i = 3; i < size; i++){
            dp[i] = Math.min(cost[i] + dp[i-2], cost[i] + dp[i-1]);
        }

        return Math.min(dp[size-1], dp[size-2]);
    }
}
