package p322;

class Solution {
    private int[] coins;
    private int[][] cache;

    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        this.cache = new int[coins.length][amount + 1];
        return getMinCoins(0, amount);
    }

    private int getMinCoins(int index, int amount) {
        if (amount == 0) return 0;
        if (index == coins.length) return -1;
        if (cache[index][amount] != 0) return cache[index][amount];

        int ret = -1;
        for (int i = 0; ; i++) {
            int nAmount = amount - coins[index] * i;
            if (nAmount < 0) break;

            int temp = getMinCoins(index + 1, nAmount);
            if (temp == -1) continue;

            ret = ret == -1 ? i + temp : Math.min(ret, i + temp);
        }

        return cache[index][amount] = ret;
    }
}
