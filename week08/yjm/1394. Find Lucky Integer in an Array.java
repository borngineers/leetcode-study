class Solution {
    public int findLucky(int[] arr) {
        Arrays.sort(arr);
        int max = -1;
        int currentNum = 0;
        int count = 0;
        for (int num : arr) {
            if (currentNum != num) {
                if (currentNum == count) {
                    max = Math.max(max, count);
                }
                currentNum = num;
                count = 1;
                continue;
            }
            count++;
        }
        if (currentNum != count) count = -1;
        max = Math.max(max, count);
        if (max == 0) return -1;
        return max;
    }
}
