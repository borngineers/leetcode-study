package leetcode.week06;

public class S125 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("0P"));
        System.out.println(isPalindrome("mom"));
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));

        // 3ms success
    }

    public static boolean isPalindrome(String s) {

        if(s.length() == 0){
            return true;
        }

        StringBuilder builder = new StringBuilder();
        final int size = s.length();
        for(int i = 0; i < size; i++){
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'
                    || s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'
                    || s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                builder.append(s.charAt(i));
            }
        }

        int firstIndex = 0;
        int lastIndex = builder.length() - 1;

        while(firstIndex < lastIndex){

            char c1 = Character.toLowerCase(builder.charAt(firstIndex++));
            char c2 = Character.toLowerCase(builder.charAt(lastIndex--));

            if(c1 != c2){
                return false;
            }
        }

        return true;
    }
}
