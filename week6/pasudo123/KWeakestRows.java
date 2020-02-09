package week06;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KWeakestRows {

    public static void main(String[]args) {

    }

    class SoldierArea {

        int row;
        int count;

        public SoldierArea(final int row, final int count) {
            this.row = row;
            this.count = count;
        }
    }

    public int[] kWeakestRows(int[][] mat, int k) {

        /**
         * (1) 군인의 수를 헤아린다.
         * (2) 한 행에 군인의 수를 헤아려야 한다.
         * (3) k 개까지 개수로 군인의 수가 적은 순서대로 행을 반환한다.
         * (4) k 개 이내의 군인의 수가 동일한 행들은 값이 적은 행으로 반환한다.
         */

        final Comparator<SoldierArea> soldierAreaComparator = new Comparator<SoldierArea>() {
            @Override
            public int compare(SoldierArea o1, SoldierArea o2) {
                if(o1.count == o2.count) {
                    return o1.row - o2.row;
                }

                return o1.count - o2.count;
            }
        };

        final PriorityQueue<SoldierArea> pq = new PriorityQueue<>(soldierAreaComparator);


        final int rows = mat.length;
        final int cols = mat[0].length;

        for(int row = 0; row < rows; row++) {

            int count = 0;

            for(int col = 0; col < cols; col++) {
                count += mat[row][col];
            }

            pq.add(new SoldierArea(row, count));
        }

        final int[] result = new int[k];

        for(int i = 0; i < k; i++) {
            result[i] = pq.poll().row;;
        }

        return result;
    }
}
