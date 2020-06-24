package published.p38;

class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String s = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            int k = 1;
            while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                i++;
                k++;
            }
            sb.append(String.format("%d%c", k, s.charAt(i)));
            i++;
        }
        return sb.toString();
    }
}