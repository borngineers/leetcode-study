package leetcode.week06;

import java.util.*;

public class S1424 {
    public static void main(String[] args) {

    }

    public static int[] findDiagonalOrder(List<List<Integer>> nums) {
        final Map<Integer, List<Integer>> map = new HashMap<>();
        int total = 0;

        final int size = nums.size();
        for(int i = 0; i < size; i++){
            final int rowSize = nums.get(i).size();
            for(int j = 0; j < rowSize; j++){
                List<Integer> list = map.getOrDefault(i + j, new ArrayList<Integer>());
                list.add(nums.get(i).get(j));
                map.put(i + j, list);
                total++;
            }
        }

        int[] result = new int[total];
        int k = 0;
        for(int i = 0; i < map.size(); i++){
            for(int j = map.get(i).size() - 1; j >= 0; j--){
                result[k++] = map.get(i).get(j);
            }
        }

        return result;
    }
}
