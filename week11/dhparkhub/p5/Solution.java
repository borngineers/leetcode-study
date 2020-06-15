package solved.p5;

class Solution {
    private String s;
    private String answer = "";

    public String longestPalindrome(String s) {
        this.s = s;
        for (int i = 0; i < s.length(); i++) {
            palindromize(i, i);
            palindromize(i, i + 1);
        }
        return answer;
    }

    private void palindromize(int i, int j) {
        if (i < 0) return;
        if (j >= s.length()) return;
        if (s.charAt(i) == s.charAt(j)) {
            String temp = s.substring(i, j + 1);
            if (temp.length() > answer.length()) {
                answer = temp;
            }
            palindromize(i - 1, j + 1);
        }
    }
}