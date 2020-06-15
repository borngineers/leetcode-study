package practice;

import java.util.ArrayList;

public class Solution4 {
	
	public static void main(String args[]) {
		
		Solution c1 = new Solution();
		
		int[][] paths = {{0,0,0},{0,1,0},{0,0,0}};
		
		System.out.println(c1.uniquePathsWithObstacles(paths));
		
	}
}

class Solution {
	
	ArrayList<Integer> arrayCache = new ArrayList<Integer>();
	
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		
		int colLen = obstacleGrid.length;
		int rowLen = obstacleGrid[0].length;
		int preRow = 0;
		int preColumn = 0;
		
		for(int i=0; i<colLen; i++) {
			
    		for(int j=0; j<rowLen; j++) {
    			if(obstacleGrid[i][j] == 1) {
    				obstacleGrid[i][j] = 0;
    				continue;
    			} 
    			
    			if(i==0 && j==0) {
    				obstacleGrid[i][j] = 1;
    				continue;
    			} 
    			
    			preRow = (i==0)? 0 : obstacleGrid[i-1][j];
    			preColumn = (j==0)? 0 : obstacleGrid[i][j-1];

    			obstacleGrid[i][j] = preColumn + preRow;
    		}
    	}
    	
		return  obstacleGrid[colLen-1][rowLen-1] ;
    }
	
}