package week02;

import java.io.*;

/**
 * Created by pasudo123 on 2020-01-09
 * Email: oraedoa@gmail.com
 **/
public class PalindromeNumber {

    private static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    private static BufferedReader reader = new BufferedReader(inputStreamReader);

    private static OutputStreamWriter outputStreamWriter = new OutputStreamWriter(System.out);
    private static BufferedWriter writer = new BufferedWriter(outputStreamWriter);

    public static void main(String[]args) throws IOException {

        writer.write(isPalindrome(121) + "");
        writer.newLine();

        writer.write(isPalindrome(-121) + "");
        writer.newLine();

        writer.write(isPalindrome(10) + "");
        writer.newLine();

        writer.write(isPalindrome(0) + "");
        writer.newLine();

        writer.write(isPalindrome(11) + "");
        writer.newLine();

        writer.write(isPalindrome(111) + "");
        writer.newLine();

        writer.flush();
    }

    public static boolean isPalindrome(int x) {

        if(x < 0){
            return false;
        }

        final String number = String.valueOf(x);
        int startIndex = 0;
        int endIndex = number.length() - 1;

        // O(n)
        while(endIndex - startIndex > 0){

            char front = number.charAt(startIndex++);
            char end = number.charAt(endIndex--);

            if(front != end){
                return false;
            }
        }

        return true;
    }
}
