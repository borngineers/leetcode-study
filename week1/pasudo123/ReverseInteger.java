package week01;

import java.io.*;

/**
 * Created by pasudo123 on 2019-12-28
 * Email: oraedoa@gmail.com
 **/
public class ReverseInteger {

    private static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    private static BufferedReader reader = new BufferedReader(inputStreamReader);

    private static OutputStreamWriter outputStreamWriter = new OutputStreamWriter(System.out);
    private static BufferedWriter writer = new BufferedWriter(outputStreamWriter);

    public static void main(String[]args) throws IOException {

        ReverseInteger ri = new ReverseInteger();

        // case 1
        writer.write(ri.reverse(123) + "");
        writer.newLine();

        // case 2
        writer.write(ri.reverse(-123) + "");
        writer.newLine();

        // case 3
        writer.write(ri.reverse(1534236469) + "");
        writer.newLine();

        /** flush **/
        writer.flush();
    }

    public int reverse(int x) {

        String value = String.valueOf(x);
        StringBuffer buffer = new StringBuffer();

        // 음수 여부 판단
        boolean isNegative = (x < 0);
        int startIndex = (isNegative) ? 1 : 0;

        for(int i = value.length() - 1; i >= startIndex; i--) {
            buffer.append(value.charAt(i));
        }

        if(isNegative) {

            long returnValue = Long.parseLong("-" + buffer.toString());

            if(returnValue < Integer.MIN_VALUE) {
                return 0;
            }

            return (int)returnValue;
        }

        long returnValue = Long.parseLong(buffer.toString());

        if(returnValue > Integer.MAX_VALUE) {
            return 0;
        }

        return (int)returnValue;
    }
}
