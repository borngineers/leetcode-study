package test;

import test.Solution;

public class Solution4 {
	
	public static void main(String args[]) {
		
		Solution ss = new Solution();
		/*
		seats = [['#','.','#','#','.','#'],
	                ['.','#','#','#','#','.'],
	                ['#','.','#','#','.','#']]
	    */
		char[][] seats = new char[][] {
			{'#','.','#','#','.','#'},
			{'.','#','#','#','#','.'},
			{'#','.','#','#','.','#'}		
		};
		
		
		System.out.println(ss.maxStudents(seats));
		
		/*
		Input: seats = [['.','#'],
		                ['#','#'],
		                ['#','.'],
		                ['#','#'],
		                ['.','#']]
		*/
		char[][] seats2 = new char[][] {
			{'.','#'},
			{'#','#'},
			{'#','.'},	
			{'#','#'},
			{'.','#'}
		};
		
		
		System.out.println(ss.maxStudents(seats2));
		
		/*
		Input: seats = [['#','.','.','.','#'],
		                ['.','#','.','#','.'],
		                ['.','.','#','.','.'],
		                ['.','#','.','#','.'],
		                ['#','.','.','.','#']]
		*/                		
		char[][] seats3 = new char[][] {
			{'#','.','.','.','#'},
			{'.','#','.','#','.'},
			{'.','.','#','.','.'},	
			{'.','#','.','#','.'},
			{'#','.','.','.','#'}
		};
		
		
		System.out.println(ss.maxStudents(seats3));
		
		/*
		[['#','.','#'],['#','#','.'],['.','#','.']]
		*/
		
		char[][] seats4 = new char[][] {
			{'#','.','#'},
			{'#','#','.'},
			{'.','#','.'}	
		};
		
		System.out.println(ss.maxStudents(seats4));
		
		
	}
}

class Solution {

    public int maxStudents(char[][] seats) {
        
    	int rowLen = seats[0].length;
    	
    	int max = 0;
    	char[][] temps = null;
    	
    	for(int i=0; i<rowLen; i++) {
    		
    		temps = deepCopy(seats);
    		int cnt = 0;
    		int colLen = seats.length;
    		//int i =5;
    		
    		for(int j=colLen-1; j>=0; j--) {
    			
    			if(temps[j][i]=='.') {
    				
    				cnt++;
    				
    				if(i+1 < rowLen) {
    					temps[j][i+1] = '#';
    				}
    				if(i+1 < rowLen && j-1 >= 0) {
    					temps[j-1][i+1] = '#';
    				}
    				if(i-1 >= 0) {
    					temps[j][i-1] = '#';
    				}
    				if(i-1 >= 0 && j-1 >= 0) {
    					temps[j-1][i-1] = '#';
    				}
    			}
    			
    			
    		}
    		
    		int rightIndex = i;
    		int leftIndex = i;
    		
    		while( leftIndex >=0 || rightIndex < seats[0].length) {
    			
    			rightIndex++;
    			leftIndex--;
    			
    			//오른쪽으로 한줄 씩 옮겨 간다
    			if(leftIndex >= 0) {
    				for(int j=colLen-1; j>=0; j--) {
            			
            			if(temps[j][leftIndex]=='.') {
            				
            				cnt++;
            				
            				if(leftIndex-1 >= 0) {
            					temps[j][leftIndex-1] = '#';
            				}
            				if(leftIndex-1 >= 0 && j-1 >= 0) {
            					temps[j-1][leftIndex-1] = '#';
            				}
            			}
            			
            		}
    			}
        		
        		
        		//오른쪽으로 한줄 씩 옮겨 간다
    			if(rightIndex < seats[0].length) {
    				for(int j=colLen-1; j>=0; j--) {
            			
            			if(temps[j][rightIndex]=='.') {
            				
            				cnt++;
            				
            				if(rightIndex+1<seats[0].length) {
            					temps[j][rightIndex+1] = '#';
            				}
            				if(rightIndex+1<seats[0].length && j-1 >= 0) {
            					temps[j-1][rightIndex+1] = '#';
            				}
            			}
            			
            		}
    			}
        		
    		}
    		
    		if(cnt>max) {
    			max = cnt;
    		}
    		
    		
        	for(int k=0; k<temps.length; k++) {
        		for(int j=0; j<temps[0].length; j++) {
        			System.out.print(temps[k][j]);
        		}
        		System.out.println();
        	}
        	
        	System.out.println("=========");
    		
    		
    	}
    	
    	
    	
    	//System.out.println(max);
    	
    	return max;
    }
    
    
    private static char[][] deepCopy(char[][] original2) {
        if(original2 == null) return null;
        char[][] result = new char[original2.length][original2[0].length];
         
        for(int i=0; i<original2.length; i++){
            System.arraycopy(original2[i], 0, result[i], 0, original2[0].length);
        }
         
        return result;
    }
    
 
}