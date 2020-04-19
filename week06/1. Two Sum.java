package leetcode.week03;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class S001 {

    public int[] twoSum(int[]nums, int target) {

        int[]returnArrays = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for(Integer key : map.keySet()) {
            int minValue = target - key;

            if(!map.containsKey(minValue)) {
                continue;
            }

            int index1 = map.get(key);
            int index2 = map.get(minValue);

            if(index1 == index2){
                List<Integer> list = IntStream.range(0, nums.length)
                        .filter(index -> nums[index] == key)
                        .boxed()
                        .sorted()
                        .collect(Collectors.toList());

                index1 = list.get(0);
                index2 = list.get(1);
            }

            returnArrays[0] = Math.min(index1, index2);
            returnArrays[1] = Math.max(index1, index2);

            break;
        }

        return returnArrays;
    }
}
