package p268;

class Solution {
    public int missingNumber(int[] nums) {
        int temp = 0;
        for (int num : nums) {
            temp += num;
        }
        int sum = (nums.length * (nums.length + 1)) / 2;
        return sum - temp;
    }
}

//import java.util.BitSet;
//
//class Solution {
//    public int missingNumber(int[] nums) {
//        BitSet bitSet = new BitSet(nums.length + 1);
//        for (int num : nums) {
//            bitSet.set(num);
//        }
//        for (int i = 0; i <= nums.length; i++) {
//            if (!bitSet.get(i)) {
//                return i;
//            }
//        }
//        return -1;
//    }
//}

//import java.util.HashMap;
//import java.util.Map;
//
//class Solution {
//    private Map<Integer, Boolean> map = new HashMap<>();
//
//    public int missingNumber(int[] nums) {
//        for (int num : nums) {
//            map.put(num, true);
//        }
//        for (int i=0; i<=nums.length; i++) {
//            if (!map.containsKey(i)) {
//                return i;
//            }
//        }
//        return -1;
//    }
//}