import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        int mapSizeN = 0, digSizeK = 0;
        for(int test_case = 1; test_case <= T; test_case++)
        {
            mapSizeN = sc.nextInt();
            digSizeK = sc.nextInt();
            final int[][] mapInfo = new int[mapSizeN][mapSizeN];
            for (int row = 0; row < mapSizeN; row++) {
                for (int col = 0; col < mapSizeN; col++) {
                    mapInfo[row][col] = sc.nextInt();
                }
            }
 
            MakeHikingTrail makeHikingTrail = new MakeHikingTrail(mapSizeN, digSizeK, mapInfo);
            makeHikingTrail.settingMapInfo();
 
            int maxLength = makeHikingTrail.calcMacPathLength();
            System.out.println(String.format("#%d %d", test_case, maxLength));
 
        }
    }
    
    static class MakeHikingTrail {
        private int mapSize = 0, digSize = 0, maxHeight = 0;
        final int[][] mapInfo;
        final boolean[][] visitedMapInfo;
 
        private int[]moveUpDown = new int[] {-1, 1, 0, 0};
        private int[]moveLeftRight = new int[] {0, 0, -1, 1};
 
        public MakeHikingTrail(int n, int k, int[][] map) {
            mapSize = n;
            digSize = k;
            this.mapInfo = map;
            this.visitedMapInfo = new boolean[mapSize][mapSize];
        }
 
        public void settingMapInfo() {
            for (int row = 0; row < mapSize; row++) {
                for(int i = 0; i < mapSize; i++){
                    visitedMapInfo[row][i] = false;
                    maxHeight = Math.max(maxHeight, mapInfo[row][i]);
                }
            }
        }
 
        public int calcMacPathLength(){
            int maxLength = 0;
            for(int row = 0; row < mapSize; row++){
                for(int col = 0; col < mapSize; col++){
                    if(maxHeight == mapInfo[row][col]){
                        maxLength = Math.max(maxLength, getMaxPathLength(row, col, true));
                    }
                }
            }
            return maxLength;
        }
 
        public int getMaxPathLength(int row, int col, boolean canDig) {
            int temp = 0;
            visitedMapInfo[row][col] = true;
            for (int i = 0; i < 4; i++) {
                int moveRow = row + moveUpDown[i];
                int moveCol = col + moveLeftRight[i];
 
                if (!isValid(moveRow, moveCol)) continue;
                if (visitedMapInfo[moveRow][moveCol]) continue;
 
                if (mapInfo[moveRow][moveCol] < mapInfo[row][col]) {
                    temp = Math.max(temp, getMaxPathLength(moveRow, moveCol, canDig));
                }else {
                    if(canDig){
                        for (int j = 1; j <= digSize; j++) {
                            int digHeight = mapInfo[moveRow][moveCol] - j;
                            if(0 <= digHeight && digHeight < mapInfo[row][col]){
                                mapInfo[moveRow][moveCol] -= j;
                                temp = Math.max(temp, getMaxPathLength(moveRow, moveCol, false));
                                mapInfo[moveRow][moveCol] += j;
                                break;
                            }
                        }
                    }
                }
            }
            visitedMapInfo[row][col] = false;
            return temp+1;
        }
 
        public boolean isValid(int row, int col) {
            return 0 <= row && row < this.mapSize && 0 <= col && col < this.mapSize;
        }
 
    }
}
