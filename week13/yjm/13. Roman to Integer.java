public class LeetCode13 {
    /**
     * 13. Roman to Integer
     * https://leetcode.com/problems/roman-to-integer/
     *
     * Example 1:
     * Input: "III"
     * Output: 3
     *
     * Example 2:
     * Input: "IV"
     * Output: 4
     *
     * Example 3:
     * Input: "IX"
     * Output: 9
     *
     * Example 4:
     * Input: "LVIII"
     * Output: 58
     * Explanation: L = 50, V= 5, III = 3.
     *
     * Example 5:
     * Input: "MCMXCIV"
     * Output: 1994
     * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
     * */

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.romanToInt("I")); // 3
        System.out.println(solution.romanToInt("IV")); // 4
        System.out.println(solution.romanToInt("IX")); // 9
        System.out.println(solution.romanToInt("LVIII")); // 58
        System.out.println(solution.romanToInt("MCMXCIV")); // 1994
    }
    static class Solution {
        public int romanToInt(String s) {
            int len = s.length();
            int sum = 0;
            for (int i = 1; i < len; i++) {
                if ( ROMAN.valueOf(s.charAt(i - 1)) >= ROMAN.valueOf(s.charAt(i)) ) {
                    sum += ROMAN.valueOf(s.charAt(i - 1));
                } else {
                    sum -= ROMAN.valueOf(s.charAt(i - 1));
                }
            }
            sum += ROMAN.valueOf(s.charAt(len - 1));
            return sum;
        }
    }

    static enum ROMAN {
        I(1),
        V(5),
        X(10),
        L(50),
        C(100),
        D(500),
        M(1000);

        private int value;
        ROMAN(int value) {
            this.value = value;
        }

        public static int valueOf(char ch) {
            switch (ch) {
                case 'I' : return 1;
                case 'V' : return 5;
                case 'X' : return 10;
                case 'L' : return 50;
                case 'C' : return 100;
                case 'D' : return 500;
                case 'M' : return 1000;
                default: return 0;
            }
        }

        @Override
        public String toString() {
            return value+"";
        }
    }
}
