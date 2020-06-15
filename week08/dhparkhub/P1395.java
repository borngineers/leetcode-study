package solved;

public class P1395 {

    class Solution {
        public int numTeams(int[] rating) {
            init(rating);
            pickThreeSoldiers(0, 0);
            return answer;
        }

        public void pickThreeSoldiers(int index, int count) {
            // if pick three soldiers
            if (count == 3) {
                if (picked[0] < picked[1] && picked[1] < picked[2]) {
                    answer++;
                } else if (picked[0] > picked[1] && picked[1] > picked[2]) {
                    answer++;
                }
                return;
            }

            if (index == rating.length) {
                return;
            }

            // pass
            pickThreeSoldiers(index + 1, count);

            // pick soldiers[index]
            picked[count] = rating[index];
            pickThreeSoldiers(index + 1, count + 1);
        }

        public void init(int[] rating) {
            answer = 0;
            this.rating = rating;
            picked = new int[3];
        }

        private int answer;
        private int[] rating;
        private int[] picked;
    }

}
