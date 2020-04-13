package solved;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P1405 {

    class Solution {
        class Happy {
            char ch;
            int k;

            Happy(char ch, int k) {
                this.ch = ch;
                this.k = k;
            }
        }

        private String answer;
        private PriorityQueue<Happy> pq;

        Solution() {
            answer = "";
            pq = new PriorityQueue<>(new Comparator<Happy>() {
                @Override
                public int compare(Happy o1, Happy o2) {
                    if (o1.k < o2.k) return 1;
                    else if (o1.k > o2.k) return -1;
                    return 0;
                }
            });
        }

        public String longestDiverseString(int a, int b, int c) {
            if (a > 0) pq.add(new Happy('a', a));
            if (b > 0) pq.add(new Happy('b', b));
            if (c > 0) pq.add(new Happy('c', c));

            while (!pq.isEmpty()) {
                Happy happy = pq.poll();

                int size = answer.length();
                if (size >= 2 && answer.charAt(size - 1) == happy.ch && answer.charAt(size - 2) == happy.ch) {
                    if (pq.isEmpty()) break;
                    Happy temp = pq.poll();
                    pq.add(happy);
                    happy = temp;
                }

                answer += happy.ch;
                if (--happy.k > 0) {
                    pq.add(happy);
                }
            }

            return answer;
        }
    }

}