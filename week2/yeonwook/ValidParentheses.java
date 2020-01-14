import java.util.HashMap;
import java.util.Scanner;

public class ValidParentheses {
	
	static char stack[] ;
	static int index = -1;
	static HashMap<Character, Character> answerSet;
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("input 값 입력 : ");
		String checkData = sc.next();
		System.out.println(isValid(checkData));
		
	}
	
	
    public static boolean isValid(String s) {
		answerSet = new HashMap<Character, Character>();
		answerSet.put('}', '{');
		answerSet.put(']', '[');
		answerSet.put(')', '(');
		
    	stack = new char[100];
    	int len = s.length();
    	char charArray[] = s.toCharArray();
    	
    	for(int i=0;i<len;i++) {
    		char target = charArray[i];
    		
    		if(!answerSet.containsKey(target)) {
    			push(target);
    		} else {
    			char popValue = pop();
        		if(popValue==' ') {
        			return false;
        		}   
        		if(answerSet.get(target)!=popValue) {
    				return false;
    			}
    		}
    	}
    	
    	if(index!=-1) {
    		return false;
    	}
    	
    	return true;
    }

    public static char pop() {
    	
    	if(index==-1) {
    		return 0;
    	} else {
    		char returnValue = stack[index];
    		stack[index] = ' ';
    		index--;
    		return returnValue;
    	}
    }
    
    public static void push(char x) {
    	
    	//System.out.println("Push : " + x);
    	stack[++index] = x;
    }