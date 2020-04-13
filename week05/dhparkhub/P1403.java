package solved;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P1403 {

    class Solution {
        private List<Integer> tempList;
        private List<Integer> answer;

        Solution() {
            tempList = new ArrayList<>();
            answer = new ArrayList<>();
        }

        public List<Integer> minSubsequence(int[] nums) {
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                tempList.add(nums[i]);
            }

            Collections.sort(tempList, Collections.reverseOrder());

            int tempSum = 0;
            for (int i=0; i<tempList.size(); i++) {
                tempSum += tempList.get(i);
                answer.add(tempList.get(i));
                if (tempSum > (sum - tempSum)) {
                    break;
                }
            }

            return answer;
        }
    }

}
