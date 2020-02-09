package test;

import java.util.ArrayList;
import java.util.List;

public class Solution4 {
	
	public static void main(String args[]) {
		
		Solution c1 = new Solution();
		
		//arr = [6,4,14,6,8,13,9,7,10,6,12], d = 2
		int[] arr = new int[] {6,4,14,6,8,13,9,7,10,6,12};
		int d = 2;
		System.out.println(c1.maxJumps(arr, d));
		//arr = [3,3,3,3,3], d = 3
		//arr = [7,6,5,4,3,2,1], d = 1
		//arr = [7,1,7,1,7,1], d = 2
		//arr = [66], d = 1
		
	}
}

class Solution {

	List<Integer> cacheList = new ArrayList<Integer>();

	public int maxJumps(int[] arr, int d) {
	 
		int len = arr.length;
		//왼쪽쪽 으로 d만큼중 가장 근접 대상 탐색
		//오른쪽 으로 d만큼중 가장 근접 대상 탐색
		
		System.out.println(findHighRight(arr, 2, 2));
		
		for(int i=0; i<len; i++) {
			
		}
	 
	 
	 
		return 0;
	}
 
	public int findHighRight(int[] arr, int index, int d) {
	 
		int len = arr.length;
		int maxVal = 0;
		int maxIndex = 0;
		int cnt = 0;
		int tempIndex = index;
	 
		while(cnt<d && tempIndex<len) {
			
			//System.out.println("tempIndex : " + tempIndex);
			
			tempIndex++;
			
			if(arr[tempIndex]>maxVal && arr[tempIndex]<arr[index]) {
				maxVal = arr[tempIndex];
				maxIndex = tempIndex;
			}
			
			cnt++;
		}
		 
		return maxIndex;
	}
 
	public int findHighLeft(int[] arr, int index, int d) {
	 
		int maxVal = 0;
		int maxIndex = 0;
		int cnt = 0;
		int tempIndex = index;
	 
		while(cnt<d && index>0) {
			tempIndex--;
			
			if(arr[tempIndex]>maxVal && arr[tempIndex]<arr[index]) {
				maxVal = arr[tempIndex];
				maxIndex = tempIndex;
			}
			
			cnt++;
		}
	 
		return maxIndex;
	}
}