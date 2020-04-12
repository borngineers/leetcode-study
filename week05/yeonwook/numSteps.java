package test;

import java.math.BigInteger;

public class Practice {
	
	public static void main(String args[]) {
		
	
		//String a = "1111011110000011100000110001011011110010111001010111110001";
		//"1101"
		String a = "1101";
		System.out.println(new Solution().numSteps(a));
		
	}
}


class Solution {
	
	/**
	 * 질문 1. s[0] == '1' 뭐징?ㅋㅋ
	 */
	
    //첫 번째 parseInt로 변환 후 재귀 함수 호출
	//데이터 크기 때문에 통과 못함
    public int findOne(int a) {
    	
    	if(a==1) {
    		return 0;
    	}
    	
    	boolean even = true;
    	if(a % 2 == 1) {
    		even = false;
    	}
    	
    	if(even) {
    		return findOne(a/2)+1;
    	} else {
    		return findOne(a+1)+1;
    	}
    }
    
    //두 번쨰 BigInteger 사용
    //BigInteger에서 컴파일 에러.. BigInteger 사용 못하나봄 
    public int numSteps2(String s) {
    	
    	
    	if(s.length() == 1) {
    		return 0;
    	}
    	
    	int steps = 0;
    	char[] chars = s.toCharArray();
    	int i = s.length()-1;
    	BigInteger bigValue = new BigInteger("0");
    	
    	for(char a : chars) {
    		int b = Character.getNumericValue(a);
    		int c = (int) (b * Math.pow(2, i));
    		bigValue = bigValue.add(BigInteger.valueOf(c));
    		i--;		
    	}
    	
    	while(bigValue.compareTo(BigInteger.valueOf(1))!=0) {
    		
    		BigInteger[] remainder = bigValue.divideAndRemainder(BigInteger.valueOf(2));
    		
    		if(remainder[1].compareTo(BigInteger.valueOf(0))==0) { //짝수
    			bigValue = bigValue.divide(BigInteger.valueOf(2));
    			steps++;
    		} else { //홀수
    			bigValue = bigValue.add(BigInteger.valueOf(1));
    			steps++;
    		}
    	}
    	
    	
    	return steps;
    }
    
    //구글링 해서 참고해서 풀었음..
    //return에 carry왜 더해주는지 이해가 안감..ㅜ
    public int numSteps(String s) {
    	
    	if(s.length() == 1) {
    		return 0;
    	}
    	
    	int steps = 0;
    	char[] chars = s.toCharArray();
    	int len = s.length();
    	int carry = 0;

    	for(int i = len-1; i > 0; --i) {
    		
    		
    		if(chars[i] - '0' + carry == 1) { //홀수 더해주고 나눠준다
    			System.out.println("odd");
    			carry = 1;
    			steps += 2;		
    		} else { //짝수 : 나눠준다
    			System.out.println("even");
    			steps += 1;
    		}
    		
    	}
    	
    	return steps+carry;
    }

}