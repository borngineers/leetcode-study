class Solution {
    public int maxArea(int[] height) {
        int beginIndex = 0;
        int lastIndex = height.length - 1;
        
        int maxArea = -1;
        
        while(beginIndex < lastIndex) {
            final int horizon = lastIndex - beginIndex;
            maxArea = Math.max(maxArea, horizon * Math.min(height[beginIndex], height[lastIndex]));
            
            if(height[beginIndex] < height[lastIndex]) {
                beginIndex++;
            } else {
                lastIndex--;
            }
        }
        
        return maxArea;
    }
}
