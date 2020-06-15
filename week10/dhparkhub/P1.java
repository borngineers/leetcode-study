package published;

import java.util.HashMap;
import java.util.Map;

public class P1 {

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] answer = new int[2];

            // for storing index of number
            Map<Integer, Integer> map = new HashMap<>();

            // find two numbers with a sum of target
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(target - nums[i])) {
                    answer[0] = map.get(target - nums[i]);
                    answer[1] = i;
                    break;
                }
                map.put(nums[i], i);
            }

            return answer;
        }
    }

}
