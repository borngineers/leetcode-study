import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWExpert1953 {
    /**
     * [탈주범 검거]
     *    교도소로 이송 중이던 흉악범이 탈출하는 사건이 발생하여 수색에 나섰다.
     *    탈주범은 탈출한 지 한 시간 뒤, 맨홀 뚜껑을 통해 지하터널의 어느 한 지점으로 들어갔으며,
     *    지하 터널 어딘가에서 은신 중인 것으로 추정된다.
     *    터널끼리 연결이 되어 있는 경우 이동이 가능하므로 탈주범이 있을 수 있는 위치의 개수를 계산하여야 한다.
     *    탈주범은 시간당 1의 거리를 움직일 수 있다.
     *    지하 터널은 총 7 종류의 터널 구조물로 구성되어 있으며 각 구조물 별 설명은 [표 1]과 같다.
     *    1: 상하좌우
     *    2: 상하
     *    3: 좌우
     *    4: 상우
     *    5: 하우
     *    6: 하좌
     *    7: 상좌
     *
     * [제약 사항]
     * 1. 시간 제한 : 최대 50개 테이트 케이스를 모두 통과하는데, C/C++/Java 모두 1초
     * 2. 지하 터널 지도의 세로 크기 N, 가로 크기 M은 각각 5 이상 50 이하이다. (5 ≤ N, M ≤ 50)
     * 3. 맨홀 뚜껑의 세로 위치 R 은 0 이상 N-1이하이고 가로 위치 C 는 0 이상 M-1이하이다. (0 ≤ R ≤ N-1, 0 ≤ C ≤ M-1)
     * 4. 탈출 후 소요된 시간 L은 1 이상 20 이하이다. (1 ≤ L ≤ 20)
     * 5. 지하 터널 지도에는 반드시 1개 이상의 터널이 있음이 보장된다.
     * 6. 맨홀 뚜껑은 항상 터널이 있는 위치에 존재한다.
     *
     * [입력]
     * 첫 줄에 총 테스트 케이스의 개수 T가 주어진다.
     * 두 번째 줄부터 T개의 테스트 케이스가 차례대로 주어진다.
     * 각 테스트 케이스의 첫 줄에는 지하 터널 지도의 세로 크기 N, 가로 크기 M, 맨홀 뚜껑이 위치한장소의 세로 위치 R, 가로 위치 C, 그리고 탈출 후 소요된 시간 L 이 주어진다.
     * 그 다음 N 줄에는 지하 터널 지도 정보가 주어지는데, 각 줄마다 M 개의 숫자가 주어진다.
     * 숫자 1 ~ 7은 해당 위치의 터널 구조물 타입을 의미하며 숫자 0 은 터널이 없는 장소를 의미한다.
     *
     * [출력]
     * 테스트 케이스의 개수만큼 T줄에 T개의 테스트 케이스 각각에 대한 답을 출력한다.
     * 각 줄은 “#x”로 시작하고 공백을 하나 둔 다음 정답을 기록한다. (x는 1부터 시작하는 테스트 케이스의 번호이다)
     * 출력해야 할 정답은 탈주범이 위치할 수 있는 장소의 개수이다.
     *
     * */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		int mapHeightN, mapWidthM = 0;
		Manhole manhole = new Manhole();

		int[][] mapInfo = new int[50][50];
		int time = 0;
        ArrestExcaper arrestExcaper = new ArrestExcaper();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            mapHeightN = sc.nextInt();
            mapWidthM = sc.nextInt();
            manhole.R = sc.nextInt();
            manhole.C = sc.nextInt();
            time = sc.nextInt();

            for (int n = 0; n < mapHeightN; n++) {
                for (int m = 0; m < mapWidthM; m++) {
                    mapInfo[n][m] = sc.nextInt();
                }
            }

            arrestExcaper.settingInfo(mapHeightN, mapWidthM, time, mapInfo);
            int result = arrestExcaper.calc(manhole.R, manhole.C);
            // 답안 출력용
            System.out.println(String.format("#%d %d", test_case, result));
        }
    }

    static class Manhole {
        int R, C = 0;
    }

    static class ArrestExcaper {
        int width, height, time = 0;
        int[][] map;
        boolean[][] visited;
        int maxCount = 0;
        Queue<Pipe> pipeQueue = new LinkedList<>();
        Queue<Pipe> tempQueue = new LinkedList<>();
        private int[]moveUpDown = new int[] {-1, 1, 0, 0};
        private int[]moveLeftRight = new int[] {0, 0, -1, 1};

        public void settingInfo(int n, int m, int t, int[][] map) {
            this.height = n;
            this.width = m;
            this.time = t;
            this.map = map;
            this.visited = new boolean[height][width];
            pipeQueue.clear();
            tempQueue.clear();
            maxCount = 0;
        }

        public int calc(int row, int col) {
            int currentRow = row;
            int currentCol = col;
            int pipeType = map[currentRow][currentCol];
            pipeQueue.add(new Pipe(currentRow, currentCol, pipeType));

            while (time > 0) {
                while (pipeQueue.size() > 0) {
                    tempQueue.add(pipeQueue.poll());
                }
                while (tempQueue.size() > 0) {
                    willVisitPipe(tempQueue.poll());
                }
                time--;
            }

            return maxCount;
        }

        public void willVisitPipe(Pipe currentPipe) {
            if (visited[currentPipe.row][currentPipe.col]) return;
            visited[currentPipe.row][currentPipe.col] = true;
            maxCount++;

            for (int i = 0; i < 4; i++) {
                int moveRow = currentPipe.row + moveUpDown[i];
                int moveCol = currentPipe.col + moveLeftRight[i];

                if (!isValid(moveRow, moveCol)) continue;
                if (visited[moveRow][moveCol]) continue;
                if (map[moveRow][moveCol] == 0) continue;

                if (checkConnectedPipe(i, currentPipe.type, map[moveRow][moveCol])) {
                    pipeQueue.add(new Pipe(moveRow, moveCol, map[moveRow][moveCol]));
                }
            }
        }

        public boolean checkConnectedPipe(int direction, int curPipeType, int movePipeType) {
            switch (curPipeType) {
                case 1:
                    if (direction == 0) {
                        if (movePipeType != 3 && movePipeType != 4 && movePipeType != 7) return true;
                    } else if (direction == 1) {
                        if (movePipeType != 3 && movePipeType != 5 && movePipeType != 6) return true;
                    } else if (direction == 2) {
                        if (movePipeType != 2 && movePipeType != 6 && movePipeType != 7) return true;
                    } else if (direction == 3) {
                        if (movePipeType != 2 && movePipeType != 4 && movePipeType != 5) return true;
                    }
                    break;
                case 2:
                    if (direction == 0) {
                        if (movePipeType != 3 && movePipeType != 4 && movePipeType != 7) return true;
                    } else if (direction == 1) {
                        if (movePipeType != 3 && movePipeType != 5 && movePipeType != 6) return true;
                    }
                    break;
                case 3:
                    if (direction == 2) {
                        if (movePipeType != 2 && movePipeType != 6 && movePipeType != 7) return true;
                    } else if (direction == 3) {
                        if (movePipeType != 2 && movePipeType != 4 && movePipeType != 5) return true;
                    }
                    break;
                case 4:
                    if (direction == 0) {
                        if (movePipeType != 3 && movePipeType != 4 && movePipeType != 7) return true;
                    } else if (direction == 3) {
                        if (movePipeType != 2 && movePipeType != 4 && movePipeType != 5) return true;
                    }
                    break;
                case 5:
                    if (direction == 1) {
                        if (movePipeType != 3 && movePipeType != 5 && movePipeType != 6) return true;
                    } else if (direction == 3) {
                        if (movePipeType != 2 && movePipeType != 4 && movePipeType != 5) return true;
                    }
                    break;
                case 6:
                    if (direction == 1) {
                        if (movePipeType != 3 && movePipeType != 5 && movePipeType != 6) return true;
                    } else if (direction == 2) {
                        if (movePipeType != 2 && movePipeType != 6 && movePipeType != 7) return true;
                    }
                    break;
                case 7:
                    if (direction == 0) {
                        if (movePipeType != 3 && movePipeType != 4 && movePipeType != 7) return true;
                    }else if (direction == 2) {
                        if (movePipeType != 2 && movePipeType != 6 && movePipeType != 7) return true;
                    }
                    break;
                default:
                    break;

            }
            return false;
        }

        public boolean isValid(int row, int col) {
            return 0 <= row && row < this.height && 0 <= col && col < this.width;
        }
    }

    static class Pipe {
        int row;
        int col;
        int type;

        public Pipe(int row, int col, int type) {
            this.row = row;
            this.col = col;
            this.type = type;
        }
    }
}
