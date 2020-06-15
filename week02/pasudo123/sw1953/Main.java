package sw1953;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    private static final String FORMAT = "#%d %d";

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {

            int rows = sc.nextInt();
            int cols = sc.nextInt();
            int R = sc.nextInt();
            int C = sc.nextInt();
            int L = sc.nextInt();

            int[][] maps = new int[rows][cols];
            for(int r = 0; r < rows; r++){
                for(int c = 0; c < cols; c++){
                    maps[r][c] = sc.nextInt();
                }
            }

            TrackerMachine tm = TrackerMachine.create(rows, cols, R, C, L, maps);
            System.out.println(String.format(FORMAT, test_case, tm.getMaxMyPlace()));
//            tm.print();
        }
    }

    static class Point {
        int row;
        int col;

        Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static class TrackerMachine {
        private static Manhole[][] manholeMap;
        private static int[][] tempMap;
        private int rows;
        private int cols;
        private int R;
        private int C;
        private int L;
        private Queue<Point> queue = new LinkedList<>();
        private int maxValue = 0;

        private TrackerMachine(int rows, int cols, int R, int C, int L) {
            this.rows = rows;
            this.cols = cols;
            this.R = R;
            this.C = C;
            this.L = L;
        }

        static TrackerMachine create(int rows, int cols, int R, int C, int L, int[][] map) {
            manholeMap = new Manhole[rows][cols];
            tempMap = new int[rows][cols];
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    manholeMap[r][c] = Manhole.getType(map[r][c]);
                }
            }
            return new TrackerMachine(rows, cols, R, C, L);
        }

        public int getMaxMyPlace() {
            if(L == 0){ return 0; }

            queue.add(new Point(R, C));

            int time = L;
            while(time > 0) {
                Queue<Point> nextQueue = move(queue, time);
                queue.clear();
                queue = nextQueue;
                time -= 1;
            }

            return maxValue;
        }

        public Queue<Point> move(Queue<Point> queue, int time){

            Queue<Point> nextPoints = new LinkedList<>();

            while(!queue.isEmpty()){
                final Point point = queue.poll();
                final Manhole manhole = manholeMap[point.row][point.col];

                if(manhole == Manhole.EMPTY || manhole == Manhole.VISITED){
                    continue;
                }

                List<Point> points = manhole.getMovableList(point.row, point.col);
                points = points.stream()
                        .filter(this::isValidRange)
                        .filter(nextPoint -> isConnect(point, nextPoint))
                        .collect(Collectors.toList());

                manholeMap[point.row][point.col] = Manhole.VISITED;
                tempMap[point.row][point.col] = time;

                nextPoints.addAll(points);

                maxValue += 1;
            }

            return nextPoints;
        }

        private boolean isConnect(Point currentPoint, Point nextPoint){
            Manhole nextManhole = manholeMap[nextPoint.row][nextPoint.col];

            if(currentPoint.row == nextPoint.row){
                if(currentPoint.col > nextPoint.col){
                    // 왼쪽 이동 가능 여부
                    return (nextManhole == Manhole.LEFT_RIGHT
                            || nextManhole == Manhole.UP_RIGHT
                            || nextManhole == Manhole.DOWN_RIGHT
                            || nextManhole == Manhole.ALL);
                } else {
                    assert currentPoint.col < nextPoint.col;
                    // 오른쪽 이동 가능 여부
                    return (nextManhole == Manhole.LEFT_RIGHT
                            || nextManhole == Manhole.DOWN_LEFT
                            || nextManhole == Manhole.UP_LEFT
                            || nextManhole == Manhole.ALL);
                }
            } else if(currentPoint.row < nextPoint.row){
                // 아래쪽 이동 가능 여부
                return (nextManhole == Manhole.UP_DOWN
                        || nextManhole == Manhole.UP_RIGHT
                        || nextManhole == Manhole.UP_LEFT
                        || nextManhole == Manhole.ALL);
            } else {
                // 위쪽 이동 가능 여부
                return (nextManhole == Manhole.UP_DOWN
                        || nextManhole == Manhole.DOWN_RIGHT
                        || nextManhole == Manhole.DOWN_LEFT
                        || nextManhole == Manhole.ALL);
            }
        }

        private boolean isValidRange(Point point){
            return !(point.row < 0 || point.row >= rows || point.col < 0 || point.col >= cols);
        }

        public void print() {
            for(int r = 0; r < rows; r++){
                for(int c = 0; c < cols; c++){
                    System.out.print(String.format("%4s", tempMap[r][c]));
                }
                System.out.println();
            }
        }

        enum Manhole {
            VISITED(100),
            EMPTY(0),
            ALL(1), UP_DOWN(2), LEFT_RIGHT(3),
            UP_RIGHT(4), DOWN_RIGHT(5), DOWN_LEFT(6), UP_LEFT(7);

            private int type;

            Manhole(int type) {
                this.type = type;
            }

            static Manhole getType(int type) {
                return Stream.of(values())
                        .filter(manhole -> manhole.type == type)
                        .findAny()
                        .orElseThrow(() -> new IllegalArgumentException("새로운 인자 값이 들어왔음"));
            }

            public List<Point> getMovableList(int startRow, int startCol) {
                final Point up = new Point(startRow - 1, startCol);
                final Point down = new Point(startRow + 1, startCol);
                final Point right = new Point(startRow, startCol + 1);
                final Point left = new Point(startRow, startCol - 1);

                switch (this) {
                    case ALL:
                        return Arrays.asList(up, down, right, left);
                    case UP_DOWN:
                        return Arrays.asList(up, down);
                    case LEFT_RIGHT:
                        return Arrays.asList(left, right);
                    case UP_RIGHT:
                        return Arrays.asList(up, right);
                    case DOWN_RIGHT:
                        return Arrays.asList(down, right);
                    case DOWN_LEFT:
                        return Arrays.asList(down, left);
                    case UP_LEFT:
                        return Arrays.asList(up, left);
                    default:
                        return Collections.emptyList();
                }
            }
        }
    }
}
