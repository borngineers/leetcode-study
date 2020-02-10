package test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

public class Solution4 {
	
	public static void main(String args[]) {
		
		Solution c1 = new Solution();
		
		//arr = [6,4,14,6,8,13,9,7,10,6,12], d = 2
		int[] arr = new int[] {6,4,14,6,8,13,9,7,10,6,12};
		int d = 2;
		//System.out.println(c1.maxJumps(arr, d));
		
		//arr = [3,3,3,3,3], d = 3
		int[] arr2 = new int[] {3,3,3,3,3};
		int d2 = 3;
		//System.out.println(c1.maxJumps(arr2, d2));
		
		//arr = [7,6,5,4,3,2,1], d = 1
		int[] arr3 = new int[] {7,6,5,4,3,2,1};
		int d3 = 3;
		//System.out.println(c1.maxJumps(arr3, d3));
		
		//arr = [7,1,7,1,7,1], d = 2
		int[] arr4 = new int[] {7,1,7,1,7,1};
		int d4 = 2;
		//System.out.println(c1.maxJumps(arr4, d4));
		
		//arr = [66], d = 1
		int[] arr5 = new int[] {66};
		int d5 = 1;
		//System.out.println(c1.maxJumps(arr5, d5));
		
		//[31,85,59,34,56,87,1,28,27,85,5,80,70,37,52,92,24,58,63,42,54,50,58,51,35,90,13,80,90,59,78,29,97,85,8,15,76,77,62,89,70,19,87,97,39,62,70,85,89,93,78,6,58,35,95,47,73,30,54,22,80,38,12,20,57,30,51,49,56,39,55,80,34,1,48,26,11,82,93,67,45,83,94,28,7,15,39,66,95,45,89,58,34,97,61,63]
		//33
		
		int[] arr6 = new int[] {31,85,59,34,56,87,1,28,27,85,5,80,70,37,52,92,24,58,63,42,54,50,58,51,35,90,13,80,90,59,78,29,97,85,8,15,76,77,62,89,70,19,87,97,39,62,70,85,89,93,78,6,58,35,95,47,73,30,54,22,80,38,12,20,57,30,51,49,56,39,55,80,34,1,48,26,11,82,93,67,45,83,94,28,7,15,39,66,95,45,89,58,34,97,61,63};
		int d6 = 33;
		
		System.out.println(arr6.length);
		System.out.println(c1.maxJumps(arr6, d6));
		
	}
}

class Solution {

	public int maxJumps(int[] arr, int d) {
		
		HashMap<Integer, Node> cacheNodeMap = new HashMap<Integer, Node>();
	 
		int len = arr.length;
		
		for(int i=0; i<len; i++) {
			
			makeNode(i, arr, cacheNodeMap);
			
			int findLeftIndex = findLeftNode(arr, i, d);
			
			if(findLeftIndex != -1) {
				makeNode(findLeftIndex, arr, cacheNodeMap);
				cacheNodeMap.get(i).setLeft(cacheNodeMap.get(findLeftIndex));
			}
			
			int findRightIndex = findRightNode(arr, i, d);
			
			if(findRightIndex != -1) {
				makeNode(findRightIndex, arr, cacheNodeMap);
				cacheNodeMap.get(i).setRight(cacheNodeMap.get(findRightIndex));
			}
		}
		
		Iterator<Integer> i = cacheNodeMap.keySet().iterator();
		
		int maxJump = 0;
		int tempJum = 0;
		
		while(i.hasNext()) {
			
			int key = i.next();
			
			tempJum = getDepth(cacheNodeMap.get(key));
			System.out.println("index : "+key+" value : "+cacheNodeMap.get(key).getValue() + " depth : " + tempJum);
			
			if(tempJum>maxJump) {
				maxJump = tempJum;
			}
		}
	 
		return maxJump;
	}
 
	public int findRightNode(int[] arr, int index, int d) {
		
		int len = arr.length;
		int maxVal = 0;
		int findIndex = -1;
		int cnt = 0;
		int tempIndex = index;
	 
		while(cnt<d && tempIndex<len-1) {
			tempIndex++;
			
			if(arr[tempIndex] > arr[index]) {
				break;
			}
			
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
	 
		while(cnt<d && tempIndex>0) {
			tempIndex--;
			
			if(arr[tempIndex] > arr[index]) {
				break;
			}
			
			if(arr[tempIndex]>maxVal && arr[tempIndex]<arr[index]) {
				maxVal = arr[tempIndex];
				findIndex = tempIndex;
			}
			
			cnt++;
		}
	 
		return findIndex;
	}
	
	
	public void makeNode(int index, int[] arr, HashMap<Integer, Node> cacheNodeMap) {
		if(!cacheNodeMap.containsKey(index)) {
			Node node = new Node(arr[index]);
			cacheNodeMap.put(index, node);
		}
	}
	
	public int getDepth(Node node) {
		
		if(node==null) {
			return 0;
		}
		
		return Math.max(getDepth(node.getLeft()), getDepth(node.getRight()))+1;
	}
	
	
	public void inOrderFind(Node node) {
		
		if(node==null) {
			return ;
		}
		
		System.out.println(node.getValue());
		inOrderFind(node.getLeft());
		inOrderFind(node.getRight());
	}
}


class Node {
	private Node left;
	private Node right;

	private int value;
	
	Node(int value) {
		left = null;
		right = null;
		this.value = value;
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
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}