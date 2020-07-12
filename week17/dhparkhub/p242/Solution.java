package p242;

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] a = new int[26];
        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i) - 'a']++;
            a[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (a[i] != 0) {
                return false;
            }
        }
        return true;
    }
}

//class Solution {
//    public boolean isAnagram(String s, String t) {
//        int[] a = new int[26];
//        int[] b = new int[26];
//        for (int i = 0; i < s.length(); i++) {
//            int index = s.charAt(i) - 'a';
//            a[index]++;
//        }
//        for (int i = 0; i < t.length(); i++) {
//            int index = t.charAt(i) - 'a';
//            b[index]++;
//            if (b[index] > a[index]) {
//                return false;
//            }
//        }
//        for (int i = 0; i < 26; i++) {
//            if (a[i] != b[i]) {
//                return false;
//            }
//        }
//        return true;
//    }
//}