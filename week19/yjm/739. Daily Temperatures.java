class Solution {
    // Runtime: 780 ms
    // Memory Usage: 68.2 MB
    public int[] dailyTemperatures(int[] T) {
        int[] waitDays = new int[T.length];

        for (int i = 0; i < T.length; i++) {
            int wait = 0;
            for (int j = i + 1; j < T.length; j++) {
                if (T[i] < T[j]) {
                    wait = j - i;
                    break;
                }
            }
            waitDays[i] = wait;
        }
        return waitDays;
    }
}
