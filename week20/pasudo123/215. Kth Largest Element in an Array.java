class Solution {
    public int findKthLargest(int[] nums, int k) {
        final List<Integer> list = new ArrayList<>();
        for(int num : nums) {
            list.add(num);
        }

        Collections.sort(list);
        return list.get(list.size() - k);   
    }
}
