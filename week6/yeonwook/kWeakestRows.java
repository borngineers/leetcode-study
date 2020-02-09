package test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution1 {
	
	public static void main(String args[]) {
		
		Solution11 c1 = new Solution11();
		
		/*
		Input: mat = 
				[[1,1,0,0,0],
				 [1,1,1,1,0],
				 [1,0,0,0,0],
				 [1,1,0,0,0],
				 [1,1,1,1,1]], 
				k = 3
		 */
		int[][] mat = new int[][] {{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}};
		int k =3;
		//System.out.println(c1.kWeakestRows(mat, k));
		
		
		/*
		Input: mat = 
		[[1,0,0,0],
		 [1,1,1,1],
		 [1,0,0,0],
		 [1,0,0,0]], 
		k = 2
		 */
		int[][] mat2 = new int[][] {{1,0,0,0},{1,1,1,1},{1,0,0,0},{1,0,0,0}};
		int k2 =2;
		//System.out.println(c1.kWeakestRows(mat2, k2));
		
		/*
		[[1,1,1,1,1],[1,0,0,0,0],[1,1,0,0,0],[1,1,1,1,0],[1,1,1,1,1]]
		3
		 */
		int[][] mat3 = new int[][] {{1,1,1,1,1},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,0},{1,1,1,1,1}};
		int k3 =3;
		System.out.println(c1.kWeakestRows(mat3, k3));
		
	}

}

class Solution11  {
	
    public int[] kWeakestRows(int[][] mat, int k) {
        
    	int len = mat.length;
    	int[] returnArr = new int[k];
    	
    	if(len <= 1) {
    		return returnArr;
    	}
    	
    	int subLen = mat[0].length;
    	List<Item> resultList = new ArrayList<Item>();
    	
    	for(int i=0; i<len; i++) {
    		
    		Item item = new Item();
			item.setIndex(i);
			item.setValue(0);
    		
    		for(int j=0; j<subLen; j++) {
    			
    			if(mat[i][j]==1) {
    				
    				item.setValue(item.getValue()+1);
    				
    			}
    		}
    		
    		resultList.add(item);
    	}
    	
    	Collections.sort(resultList, new Comparator<Item>() {
    		@Override
        	public int compare(Item o1, Item o2) {
        		// TODO Auto-generated method stub
        		if(o1.getValue() > o2.getValue()) {
        			return 1;
        		} 
        		if(o1.getValue() < o2.getValue()) {
        			return -1;
        		}
        		if(o1.getIndex() > o2.getIndex()) {
        			return 1;
        		}
        		if(o1.getIndex() < o2.getIndex()) {
        			return -1;
        		}
        		
        		return 0;
        	}
    	});
    	
    	for(int i=0; i<k; i++) {
    		returnArr[i] = resultList.get(i).getIndex();
    	}
    	
    	for(int a : returnArr) {
    		System.out.println(a);
    	}
    	
    	return returnArr;
    }
    
    
}

class Item {
	
	private int index;
	private int value;
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}

}