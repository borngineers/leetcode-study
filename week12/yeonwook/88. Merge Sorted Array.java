class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int[] temps = new int[m+n];
        
        int i = 0;
        int j = 0;
        int k = 0;
        
        while(i<m || j<n) {
            
            System.out.print(k);
            System.out.print(i);
            System.out.print(j);
            System.out.println();
            if(i==m) {
                temps[k] = nums2[j];
                j++;
                k++;
                continue;
            } 
            if(j==n) {
                temps[k] = nums1[i];
                i++;
                k++;
                continue;
            }
            if(nums1[i] <= nums2[j]) {
                temps[k] = nums1[i];
                i++;
                k++;
                
            } else {
                temps[k] = nums2[j];
                j++;
                k++;
            }
            
        }
        
        for(int z=0; z<m+n; z++) {
            nums1[z] = temps[z];
        }
    }
}
