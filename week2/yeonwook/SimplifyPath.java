import java.util.HashMap;
import java.util.Scanner;

public class SimplifyPath {
	
	static char stack[] ;
	static int index = -1;
	static HashMap<Character, Character> answerSet;
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("input 값 입력 : ");
		String checkData = sc.next();
		
		String result = simplifyPath(checkData);
		System.out.println("--------------------");
		System.out.println("결과값 : " +result);
		
	}
	
	public static String simplifyPath(String path) {
		
    	stack = new char[100];
    	int len = path.length();
    	char charArray[] = path.toCharArray();
    	
    	for(int i=0;i<len;i++) {
    		char target = charArray[i];
    		
    		System.out.println("--------------------");
    		System.out.println("검사값 : " + target);
    		
    		boolean result = valid(target);
    		
    		if(result) {
    			push(target);
    		}
    	}
    	
    	if(peek()=='/' && index!=0) {
    		pop();
    	}
    	
		return String.valueOf(stack).trim();
	}

	
    public static void pop() {
    	
    	if(index==-1) {
    		push('/');
    	} else {
    		System.out.println("POP : " + stack[index]);
    		stack[index] = ' ';
    		index--;
    	}
    }
    
    public static char peek() {
    	
    	if(index==-1) {    		
    		return 0;
    	} else {
    		System.out.println("PEEK : " + stack[index]);
    		return stack[index];
    	}
    }    
    
    public static void push(char x) {
    	System.out.println("PUSH : " + x);
    	stack[++index] = x;
    }
    
    public static boolean valid(char x) {
    	
    	if(x=='/') {
    		// peek
    		// '/'이면 pass
    		char temp = peek();
    		
    		if(temp=='/') {
    			return false;
    		} 
    		if(temp=='.') {
    			pop();
    			return false;
    		}
    	}
    	
    	if(x=='.') {
    		// peek
    		// '.'이면 세번 pop ex) . / a
    		char temp = peek();
    		if(temp=='.') {
    			pop();
    			pop();
    			pop();
    			
    			return false;
    		} else {
    			return true;
    		}
    	}
    	
		return true;
    	
    }
    
    
}