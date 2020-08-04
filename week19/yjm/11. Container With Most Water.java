public class LeetCode11 {
    /**
     * 11. Container With Most Water
     * https://leetcode.com/problems/container-with-most-water/
     *
     * Example:
     * Input: [1,8,6,2,5,4,8,3,7]
     * Output: 49
     */

    public static void main(String[] args) {
        Solution solution = new Solution();

        int result = solution.maxArea2(new int[]{1,8,6,2,5,4,8,3,7});
        System.out.println(result); // 49
    }

    static class Solution {
        // Runtime: 339 ms, faster than 18.98% of Java online submissions for Container With Most Water.
        // Memory Usage: 39.4 MB, less than 90.29% of Java online submissions for Container With Most Water.
        public int maxArea(int[] height) {
            int maxVal = 0;
            for (int i = 0; i < height.length - 1; i++) {
                for (int j = i + 1; j < height.length; j++) {
                    maxVal = Math.max(calcAreaSize(i, height[i], j, height[j]), maxVal);
                }
            }

            return maxVal;
        }

        // Runtime: 2 ms, faster than 96.92% of Java online submissions for Container With Most Water.
        // Memory Usage: 40.1 MB, less than 9.59% of Java online submissions for Container With Most Water.
        public int maxArea2(int[] height) {
            int maxVal = 0;
            int prevHeight = 0;
            int startIndex = 0;
            int endIndex = height.length - 1;

            while (startIndex < endIndex) {
                if (height[startIndex] < height[endIndex]) {
                    if (prevHeight < height[startIndex]) {
                        maxVal = Math.max(maxVal, calcAreaSize(startIndex, height[startIndex], endIndex, height[endIndex]));
                        prevHeight = height[startIndex];
                    }
                    startIndex++;
                } else {
                    if (prevHeight < height[endIndex]) {
                        maxVal = Math.max(maxVal, calcAreaSize(startIndex, height[startIndex], endIndex, height[endIndex]));
                        prevHeight = height[endIndex];
                    }
                    endIndex--;
                }
            }

            return maxVal;
        }

        public int calcAreaSize(int ax, int ay, int bx, int by) {
            return Math.abs(bx - ax) * Math.min(by, ay);
        }
    }
}
