package leetcode.week05;

public class S007 {
    public static void main(String[] args) {
        System.out.println(reverse(-2147483648));
//        System.out.println(reverse(-123));
//        System.out.println(reverse(120));
//        System.out.println(reverse(-120));
//        System.out.println(reverse(0));
    }

    public static int reverse(int x) {
        if(x == 0){ return x; }
        boolean isNegative = false;
        long currentValue = x;
        if(currentValue < 0){
            isNegative = true;
            currentValue = currentValue * -1;
        }

        final StringBuilder builder = new StringBuilder();

        while(currentValue != 0){
            builder.append((currentValue % 10));
            currentValue /= 10;
        }

        long ret = Long.parseLong(builder.toString());
        if(ret > Integer.MAX_VALUE){
            return 0;
        }

        return isNegative ? (int)(-1 * ret) : (int)ret;
    }
}
