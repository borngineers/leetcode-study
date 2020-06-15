package practice;

import practice.A;

public class Solution {
	
	public static void main(String[] args) {
		A ss = new A();
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
		
		
		//System.out.println(ss.maxStudents(seats));
		
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
		
		
		//System.out.println(ss.maxStudents(seats2));
		
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
		
		
		//System.out.println(ss.maxStudents(seats3));
		
		/*
		[['#','.','#'],['#','#','.'],['.','#','.']]
		*/
		
		char[][] seats4 = new char[][] {
			{'#','.','#'},
			{'#','#','.'},
			{'.','#','.'}	
		};
		
		//System.out.println(ss.maxStudents(seats4));
		
		/*
		[[['#','.','#','.','.'],['.','#','#','#','#'],['#','.','.','#','#'],['#','.','#','.','.'],['#','.','#','#','.']]]
		*/
		
		char[][] seats5 = new char[][] {
			{'#','.','#','.','.'},
			{'.','#','#','#','#'},
			{'#','.','.','#','#'},
			{'#','.','#','.','.'},
			{'#','.','#','#','.'}	
		};
		
		//System.out.println(ss.maxStudents(seats5));
		
		/*
		[['#','#','.'],['#','.','.'],['.','.','#']]
		*/
		
		char[][] seats6 = new char[][] {
			{'#','#','.'},
			{'#','.','.'},
			{'.','.','#'}
		};
		
		//System.out.println(ss.maxStudents(seats6));
		
		/*
		['.','.','#','#'],['.','#','.','.'],['#','.','.','#'],['#','#','#','.']]
		*/
		
		char[][] seats7 = new char[][] {
			{'.','.','#','#'},
			{'.','#','.','.'},
			{'#','.','.','#'},
			{'#','#','#','.'}
		};
		
		//System.out.println(ss.maxStudents(seats7));
		
		/*
		['#','#','#','.','#'],['.','.','#','.','.'],['#','.','#','.','#'],['.','.','.','.','.'],['.','.','.','#','.']
		*/
		
		char[][] seats8 = new char[][] {
			{'#','#','#','.','#'},
			{'.','.','#','.','.'},
			{'#','.','#','.','#'},
			{'.','.','.','.','.'},
			{'.','.','.','#','.'}
		};
		
		System.out.println(ss.maxStudents(seats8));
		
	}
}

class A {
	
	
	public int maxStudents(char[][] seats) {
		
		int rowLen = seats[0].length;
		int colLen = seats.length;
		int cnt = 0;
		
		int rowIndex = findMaxCol(seats, rowLen, colLen);
		
		
		while(rowIndex != -1) {
			System.out.println(rowIndex);
			
			for(int i=0; i<colLen; i++) {
				
				if(seats[i][rowIndex]=='.') {
					cnt++;
					
					seats[i][rowIndex] = '#';
					
					if(i-1 >= 0 && rowIndex+1 < rowLen) {
						seats[i-1][rowIndex+1] = '#';
					}
					if(rowIndex+1 < rowLen) {
						seats[i][rowIndex+1] = '#';
					}
					if(i+1 < colLen && rowIndex+1 < rowLen) {
						seats[i+1][rowIndex+1] = '#';
					}
					if(i-1 >= 0 && rowIndex-1 >= 0) {
						seats[i-1][rowIndex-1] = '#';
					}
					if(rowIndex-1 >= 0) {
						seats[i][rowIndex-1] = '#';
					}
					if(i+1 < colLen && rowIndex-1 >= 0) {
						seats[i+1][rowIndex-1] = '#';
					}
				}
			}
			
			rowIndex = findMaxCol(seats, rowLen, colLen);
		}
		
		return cnt;
	}
	
	public int findMaxCol(char[][] seats, int rowLen, int colLen) {
		
		int max = 0;
		int cnt = 0;
		int rowIndex = 0;
		
		for(int i=0; i<rowLen; i++) {
			cnt = 0;
			for(int j=0; j<colLen; j++) {
				if(seats[j][i]=='.') {
					cnt++;
				}
			}
			if(cnt>=max) {
				max = cnt;
				rowIndex = i;
			}
		}
		
		if(max==0) {
			return -1;
		}
		
		return rowIndex;
	}
}
