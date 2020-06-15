package week07;

public class MinSteps {

    // practice
    // leetcode

    // p, r, a, i, c
    // practice ->
    // XXXctXXe
    // leectode

    public static void main(String[]args) {

        System.out.println(minSteps("bab", "aba"));
        System.out.println(minSteps("leetcode", "practice"));
        System.out.println(minSteps("anagram", "mangaar"));
        System.out.println(minSteps("xxyyzz", "xxyyzz"));
        System.out.println(minSteps("friend", "family"));
    }

    public static int minSteps(String s, String t) {

        int[] count = new int['z' - 'a' + 1];
        final int sStrSize = s.length();

        for(int i = 0; i < sStrSize; i++){
            char c = s.charAt(i);
            count[c - 'a']++;
        }

        final int tStrSize = t.length();

        for(int i = 0; i < tStrSize; i++){
            char c = t.charAt(i);
            count[c - 'a']--;
        }

        int sum = 0;
        int alphabetSize = count.length;
        for(int i = 0; i < alphabetSize; i++){
            sum += (count[i] < 0) ? Math.abs(count[i]) : 0;
        }

        return sum;
    }
}
