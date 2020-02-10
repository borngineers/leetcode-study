package practice;

import java.util.HashMap;
import java.util.Iterator;

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

	HashMap<Integer, Node> cacheNodeMap = new HashMap<Integer, Node>();

	public int maxJumps(int[] arr, int d) {
	 
		int len = arr.length;
		
		for(int i=0; i<len; i++) {
			
			makeNode(i);
			
			int findLeftIndex = findLeftNode(arr, i, d);
			
			if(findLeftIndex != -1) {
				makeNode(findLeftIndex);
				cacheNodeMap.get(i).setLeft(cacheNodeMap.get(findLeftIndex));
			}
			
			int findRightIndex = findRightNode(arr, i, d);
			
			if(findRightIndex != -1) {
				makeNode(findRightIndex);
				cacheNodeMap.get(i).setRight(cacheNodeMap.get(findRightIndex));
			}
		}
		
		
		Iterator<Integer> i = cacheNodeMap.keySet().iterator();
		
		while(i.hasNext()) {
			
		}
	 
	 
		return 0;
	}
 
	public int findRightNode(int[] arr, int index, int d) {
		 
		int len = arr.length;
		int maxVal = 0;
		int findIndex = -1;
		int cnt = 0;
		int tempIndex = index;
	 
		while(cnt<d && tempIndex<len) {
			tempIndex++;
			
			if(arr[tempIndex]>maxVal && arr[tempIndex]<arr[index]) {
				maxVal = arr[tempIndex];
				findIndex = tempIndex;
			}
			
			cnt++;
		}
		 
		return findIndex;
	}
 
	public int findLeftNode(int[] arr, int index, int d) {
	 
		int maxVal = 0;
		int findIndex = -1;
		int cnt = 0;
		int tempIndex = index;
	 
		while(cnt<d && index>0) {
			tempIndex--;
			
			if(arr[tempIndex]>maxVal && arr[tempIndex]<arr[index]) {
				maxVal = arr[tempIndex];
				findIndex = tempIndex;
			}
			
			cnt++;
		}
	 
		return findIndex;
	}
	
	
	public void makeNode(int index) {
		if(cacheNodeMap.containsKey(index)) {
			Node node = new Node();
			cacheNodeMap.put(index, node);
		}
	}
}


class Node {
	private Node left;
	private Node right;
	
	Node() {
		left = null;
		right = null;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

}