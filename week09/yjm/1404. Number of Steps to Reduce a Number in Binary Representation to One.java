class Solution {
    /**
     * 1404. Number of Steps to Reduce a Number in Binary Representation to One
     * https://leetcode.com/contest/weekly-contest-183/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/
     *
     * Example 1:
     * Input: s = "1101"
     * Output: 6
     * Explanation: "1101" corressponds to number 13 in their decimal representation.
     * Step 1) 13 is odd, add 1 and obtain 14.
     * Step 2) 14 is even, divide by 2 and obtain 7.
     * Step 3) 7 is odd, add 1 and obtain 8.
     * Step 4) 8 is even, divide by 2 and obtain 4.
     * Step 5) 4 is even, divide by 2 and obtain 2.
     * Step 6) 2 is even, divide by 2 and obtain 1.
     *
     * Example 2:
     * Input: s = "10"
     * Output: 1
     * Explanation: "10" corressponds to number 2 in their decimal representation.
     * Step 1) 2 is even, divide by 2 and obtain 1.
     *
     * Example 3:
     * Input: s = "1"
     * Output: 0
     * */
    public int numSteps(String s) {
        String binaryNumber = s;
        int count = 0;

        while (binaryNumber.length() > 1) {
            if (binaryNumber.charAt(binaryNumber.length()-1) == '1') {
                // odd
                binaryNumber = addOne(binaryNumber);
            }else {
                // even
                binaryNumber = binaryNumber.substring(0, binaryNumber.length()-1);
            }
            count++;
        }
        return count;
    }

    private String addOne(String num) {
        boolean flag = true;
        StringBuilder sb = new StringBuilder("");
        for (int i = num.length() - 1; i >= 0; i--) {
            if (flag) {
                if (num.charAt(i) == '0') {
                    sb.insert(0, "1");
                    flag = false;
                } else {
                    sb.insert(0, "0");
                    flag = true;
                }
            } else {
                sb.insert(0, num.charAt(i));
            }
        }
        if (flag) sb.insert(0, "1");
        return sb.toString();
    }
}
