package solved;

import java.util.PriorityQueue;

public class P1405 {

    class Solution {
        private String answer;
        private int[] count;
        private PriorityQueue<Character> pq;

        Solution() {
            answer = "";
            pq = new PriorityQueue((x, y) -> count[(char)y - 'a'] - count[(char)x - 'a']);
        }

        public String longestDiverseString(int a, int b, int c) {
            count = new int[]{a, b, c};

            if (a > 0) pq.add('a');
            if (b > 0) pq.add('b');
            if (c > 0) pq.add('c');

            while (!pq.isEmpty()) {
                char temp = pq.poll();

                int size = answer.length();
                if (size >= 2 && answer.charAt(size - 1) == temp && answer.charAt(size - 2) == temp) {
                    if (pq.isEmpty()) break;
                    answer += pq.peek();
                    if (--count[pq.peek() - 'a'] == 0) {
                        pq.poll();
                    }
                    pq.add(temp);
                    continue;
                }

                answer += temp;
                if (--count[temp - 'a'] != 0) {
                    pq.add(temp);
                }
            }

            return answer;
        }
    }

}