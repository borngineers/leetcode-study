package test;
import java.util.HashMap;
import java.util.Map;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		
	}
	
	public int findLucky(int[] arr) {
        
		Map<Integer, Integer> checkMap = new HashMap<Integer, Integer>();
		int max = -1;
		
		for(int a : arr) {
			
			if(checkMap.containsKey(a)) {
				
				checkMap.put(a, checkMap.get(a)+1);
				
			} else {
				checkMap.put(a, 1);
			}
		}
		
		for(Integer a : checkMap.keySet()) {
			if(a == checkMap.get(a)) {
				if(a > max) {
					max = a;
				}
			}
		}
		
		return max;
    }
	
}

