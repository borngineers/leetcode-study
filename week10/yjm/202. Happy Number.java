public class LeetCode202 {
    /**
     * 202. Happy Number
     * https://leetcode.com/problems/happy-number/
     *
     * Example:
     * Input: 19
     * Output: true
     * Explanation:
     * 12 + 92 = 82
     * 82 + 22 = 68
     * 62 + 82 = 100
     * 12 + 02 + 02 = 1
     * */

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isHappy(19)); // true
        System.out.println(solution.isHappy(52)); // false
        System.out.println(solution.isHappy(596)); // false
        System.out.println(solution.isHappy(3)); // false
    }
}

class Solution {
    public boolean isHappy(int n) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        while (n != 1) {
            if (map.containsKey(n)) {
                return false;
            } else {
                map.put(n, false);
            }
            int subSum = 0;
            while ( n != 0 ) {
                subSum += (int) Math.pow((n % 10), 2);
                n = n / 10;
            }
            n = subSum;
        }
        return true;
    }
}
