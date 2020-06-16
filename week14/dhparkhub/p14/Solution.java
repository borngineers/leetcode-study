package published.p14;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        StringBuilder sb = new StringBuilder();
        String temp = strs[0];
        for (int i = 0; i < temp.length(); i++) {
            boolean canAdd = true;
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || temp.charAt(i) != strs[j].charAt(i)) {
                    canAdd = false;
                    break;
                }
            }
            if (!canAdd) break;
            sb.append(temp.charAt(i));
        }
        return sb.toString();
    }
}