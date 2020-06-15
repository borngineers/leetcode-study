package test;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		int[] rating = new int[] {2,5,3,4,1};
		System.out.println("test");
		
		System.out.println(numTeams(rating));
	}
	
    public static int numTeams(int[] rating) {
        
    	int ascendingCnt = 0;
    	for(int i=0; i<rating.length-2; i++) {
    		
    		int j=i+1;
    		while(j<rating.length-1) {
    			
    			if(rating[i]<rating[j]) {
    				
    				int z=j+1;
    				while(z<rating.length) {
        				
    	    			if(rating[j]<rating[z]) {
    	    				ascendingCnt++;
    	    			}
        				z++;
        			}
    				
    			}
    			    			
    			j++;
    		}
    	}
    	
    	int descendingCnt = 0;
    	for(int i=rating.length-1; i>=2; i--) {
    		
    		int j=i-1;
    		while(j>=1) {
    			
    			if(rating[j]>rating[i]) {
    				int z=j-1;
    				while(z>=0) {
    					
    					if(rating[z]>rating[j]) {
    						descendingCnt++;
    						
    					}
    					z--;
    				}
    			}
    			
    			j--;
    		}
    	}
    	
    	return ascendingCnt+descendingCnt;
    }
	
}

