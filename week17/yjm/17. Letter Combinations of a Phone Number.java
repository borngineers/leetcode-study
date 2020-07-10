import java.util.ArrayList;
import java.util.List;

public class LeetCode17 {
    /**
     * 17. Letter Combinations of a Phone Number
     * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
     * <p>
     * Example:
     * Input: "23"
     * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     */

    public static void main(String[] args) {
        Solution solution = new Solution();

        List<String> result = solution.letterCombinations("23");  // 3
        for (String a : result) {
            System.out.print(a + " / ");
        }
        System.out.println("");

        result = solution.letterCombinations("232");  // 3
        for (String a : result) {
            System.out.print(a + " / ");
        }
        System.out.println("");
    }

    static class Solution {
        // Runtime: 1 ms, faster than 84.20% of Java online submissions for Letter Combinations of a Phone Number.
        // Memory Usage: 40 MB, less than 14.85% of Java online submissions for Letter Combinations of a Phone Number.
        public List<String> letterCombinations(String digits) {
            List<String> result = new ArrayList<>();
            if ("".equals(digits)) {
                return result;
            }

            result.add("");
            char[] chars = digits.toCharArray();
            for (char c : chars) {
                char[] alphas = getCharsFromNum(c);
                result = mergeAlphas(result, alphas);
            }

            return result;
        }

        private List<String> mergeAlphas(List<String> list, char[] secondChars) {
            List<String> result = new ArrayList<>();
            if (list.size() == 0) {
                for (char b : secondChars) {
                    result.add(new StringBuilder().append(b).toString());
                }
            } else {
                for (String a : list) {
                    for (char b : secondChars) {
                        result.add(new StringBuilder().append(a).append(b).toString());
                    }
                }
            }
            return result;
        }

        private char[] getCharsFromNum(char c) {
            // '2' == 50 / 'a' == 97 / 'b' == 98 / 'c' == 99
            // '3' == 51 / 'd' == 100 / 'e' == 101 / 'f' == 102
            // '4' == 52 / 'g' == 103 / 'h' == 104 / 'i' == 105
            // '5' == 53 / 'j' == 106 / 'k' == 107 / 'l' == 108
            // '6' == 54 / 'm' == 109 / 'n' == 110 / 'o' == 111
            // '7' == 55 / 'p' == 112 / 'q' == 113 / 'r' == 114 / 's' == 115
            // '8' == 56 / 't' == 116 / 'u' == 117 / 'v' == 118
            // '9' == 57 / 'w' == 119 / 'x' == 120 / 'y' == 121 / 'z' == 122
            // (a - 50) * 3 + 97
            switch (c) {
                case '2':
                    return new char[]{'a', 'b', 'c'};
                case '3':
                    return new char[]{'d', 'e', 'f'};
                case '4':
                    return new char[]{'g', 'h', 'i'};
                case '5':
                    return new char[]{'j', 'k', 'l'};
                case '6':
                    return new char[]{'m', 'n', 'o'};
                case '7':
                    return new char[]{'p', 'q', 'r', 's'};
                case '8':
                    return new char[]{'t', 'u', 'v'};
                case '9':
                    return new char[]{'w', 'x', 'y', 'z'};
                default:
                    return null;
            }
        }
    }
}
