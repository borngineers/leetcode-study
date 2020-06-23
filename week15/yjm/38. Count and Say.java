public class LeetCode38 {
    /**
     * 38. Count and Say
     * https://leetcode.com/problems/count-and-say/
     *
     * 1.     1
     * 2.     11
     * 3.     21
     * 4.     1211
     * 5.     111221
     *
     * Example 1:
     *
     * Input: 1
     * Output: "1"
     * Explanation: This is the base case.
     *
     * Example 2:
     * Input: 4
     * Output: "1211"
     * Explanation: For n = 3 the term was "21" in which we have two groups "2" and "1", "2" can be read as "12" which means frequency = 1 and value = 2, the same way "1" is read as "11", so the answer is the concatenation of "12" and "11" which is "1211".
     */

    public static void main(String[] args) {
        Solution solution = new Solution();

        String result = solution.countAndSay(8);
        System.out.println(result);

        result = solution.countAndSay(9);
        System.out.println(result);

        result = solution.countAndSay(10);
        System.out.println(result);
    }

    static class Solution {
        // Runtime: 1 ms, faster than 91.65% of Java online submissions for Count and Say.
        // Memory Usage: 36.5 MB, less than 95.03% of Java online submissions for Count and Say.
        public String countAndSay(int n) {
            return check(n);
        }

        public String check(int n) {
            if (n == 1) { return "1"; }
            if (n == 2) { return "11"; }
            if (n == 3) { return "21"; }
            if (n == 4) { return "1211"; }
            if (n == 5) { return "111221"; }

            String prevStr = check(n - 1);
            return count(prevStr);
        }

        public String count(String str) {
            char[] charArray = str.toCharArray();
            char temp = charArray[0];
            int cnt = 0;
            StringBuilder sb = new StringBuilder();

            for (char c : charArray) {
                if (temp != c) {
                    sb.append(cnt);
                    sb.append(temp);
                    temp = c;
                    cnt = 0;
                }
                cnt++;
            }
            sb.append(cnt);
            sb.append(temp);

            return sb.toString();
        }
    }

}
