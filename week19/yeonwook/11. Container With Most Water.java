class Solution {
    public int maxArea(int[] height) {
        
        if(height.length <= 1) return  0;
        
        int answer = 0;
        for(int i=0; i<height.length; i++) {
            for(int j=0; j<height.length; j++) {
                if(i==j) continue;
                answer = Math.max(answer, (j-i)*Math.min(height[i], height[j]));
            }
        }
        
        return answer;
    }
}
