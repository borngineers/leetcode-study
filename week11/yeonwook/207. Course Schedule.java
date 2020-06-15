class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
    	
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        for(int[] course : prerequisites) {
            
            if(graph.containsKey(course[1])) {
                graph.get(course[1]).add(Integer.valueOf(course[0]));
            } else {
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(Integer.valueOf(course[0]));
                graph.put(course[1], arr);
            }
        }
        
        int cnt=0;
        
        int[] visited = new int[numCourses];
        
        for(int i=0; i<numCourses; i++) {
        	
        	if(!findFinish(graph, visited, i)) {
        		  return false;
        	}
        }
        
        return true;
    }
    
    public boolean findFinish( Map<Integer, List<Integer>> graph, int[] visited, int i) {
    	
    	if(visited[i] == 1) {
    		  return true;
    	}
    	if(visited[i] == -1) {
    		  return false;
    	}
    	
    	if(graph.containsKey(i)) {
            
        visited[i] = -1;
    		
    		List<Integer> postCourse = graph.get(i);
            
    		for(int j : postCourse) {
    			  if(!findFinish(graph, visited, j)) {
    				    return false;
    			  }
    		}
            
        visited[i] = 1;
    	}
        
    	return true;
    }
}
