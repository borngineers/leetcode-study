package leetcode.week04;

public class S121 {

    public static void main(String[]args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    public static int maxProfit(int[]prices) {
        int minBuy = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int price : prices) {
            minBuy = Math.min(minBuy, price);
            maxProfit = Math.max(maxProfit, price - minBuy);
        }

        return maxProfit;
    }
}
