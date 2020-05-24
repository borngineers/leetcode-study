package p125;

class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            while (i < s.length() && !isAlphanumeric(s.charAt(i))) {
                i++;
            }
            while (j >= 0 && !isAlphanumeric(s.charAt(j))) {
                j--;
            }
            if (i == s.length() || j == -1) return true;
            char x = Character.toUpperCase(s.charAt(i));
            char y = Character.toUpperCase(s.charAt(j));
            if (x != y) return false;
            i++;
            j--;
        }
        return true;
    }

    private Boolean isAlphanumeric(char x) {
        return (x >= 'a' && x <= 'z') || (x >= 'A' && x <= 'Z') || (x >= '0' && x <= '9');
    }
}

//class Solution {
//    public boolean isPalindrome(String s) {
//        String temp = s.replaceAll("[^a-zA-Z0-9]", "").toUpperCase();
//        int i = 0;
//        int j = temp.length() - 1;
//        while (i < j) {
//            if (temp.charAt(i) != temp.charAt(j)) return false;
//            i++;
//            j--;
//        }
//        return true;
//    }
//}