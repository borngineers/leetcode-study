public class LeetCode7 {
    /**
     * 7. Reverse Integer
     * https://leetcode.com/problems/reverse-integer/
     *
     * Example 1:
     * Input: 123
     * Output: 321
     *
     * Example 2:
     * Input: -123
     * Output: -321
     *
     * Example 3:
     * Input: 120
     * Output: 21
     * */

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse(123)); // -321
        System.out.println(solution.reverse(120)); // -321
        System.out.println(solution.reverse(-123)); // -321
        System.out.println(solution.reverse(1234567899)); // -321
//        System.out.println(solution.reverse(9876543211)); // -321
    }

    static class Solution {
        public int reverse(int x) {
            if (-10 < x && x < 10) {
                return x;
            }

            Long result = 0L;
            Long reverseNum = 0L;
            Long targetNum = Long.valueOf(x);

            while (true) {
                result = result * 10L;
                reverseNum = targetNum % 10L;
                result += reverseNum;
                targetNum = targetNum / 10L;
                if ( -10L < targetNum && targetNum < 10L ) {
                    result = result * 10L + targetNum;
                    break;
                }
            }
            if(Long.valueOf((int)Math.pow(-2,31)) < result && result < Long.valueOf((int)Math.pow(2,31)-1)){
                return result.intValue();
            }
            return 0;
        }
    }

}
