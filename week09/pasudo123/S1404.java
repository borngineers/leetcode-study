package leetcode.week02;

import java.math.BigInteger;

public class S1404 {

    public static void main(String[]args) { ;
        System.out.println(numSteps("1111110011101010110011100100101110010100101110111010111110110010"));
    }

    public static int numSteps(String s) {

        int len = s.length();

        // 2진수 10진수 변환
        BigInteger num = (s.charAt(len - 1) == '1') ? BigInteger.ONE : BigInteger.ZERO;
        BigInteger value = BigInteger.ONE;
        BigInteger two = new BigInteger("2");
        for(int i = len - 2; i >= 0; i--){
            num = (s.charAt(i) == '1')
                    ? num.add(value.multiply(two))
                    : num;

            value = value.multiply(two);
        }
        // http://www.unitconversion.org/numbers/binary-to-base-10-conversion.html

        // 10진수 1로
        return recursiveDivide(num, 0);
    }

    private static int recursiveDivide(BigInteger num, int round){

        if(num.equals(BigInteger.ZERO) || num.equals(BigInteger.ONE)){
            return round;
        }

        return (num.mod(new BigInteger("2")).equals(BigInteger.ZERO))
                ? recursiveDivide(num.divide(new BigInteger("2")), round + 1)
                : recursiveDivide(num.add(new BigInteger("1")), round + 1);
    }
}
