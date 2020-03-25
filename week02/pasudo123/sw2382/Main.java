package sw2382;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    private static final String FORMAT = "#%d %d";

    public static void main(String[]args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int K = sc.nextInt();
            List<Microbe> microbes = new ArrayList<>();

            for(int k = 0; k < K; k++){
                int row = sc.nextInt();
                int col = sc.nextInt();
                int count = sc.nextInt();
                Direction direction = Direction.getDirection(sc.nextInt());
                microbes.add(Microbe.create(N, row, col, count, direction));
            }

            Crowd crowd = new Crowd(N, M, microbes);
            System.out.println(String.format(FORMAT, test_case, crowd.getResult()));
        }
    }

    enum Direction{
        UP(1),
        DOWN(2),
        LEFT(3),
        RIGHT(4);

        private int num;

        Direction(int num){
            this.num = num;
        }

        public static Direction getDirection(int num){
            return Stream.of(Direction.values())
                    .filter(direction -> direction.num == num)
                    .findAny()
                    .orElseThrow(() -> new IllegalArgumentException("잘못된 인자가 들어왔습니다."));
        }
    }

    static class Microbe{
        int N;
        int row;
        int col;
        int count;
        Direction direction;

        private Microbe(int N, int row, int col, int count, Direction direction){
            this.N = N;
            this.row = row;
            this.col = col;
            this.count = count;
            this.direction = direction;
        }

        public static Microbe create(int N, int row, int col, int count, Direction direction){
            return new Microbe(N, row, col, count, direction);
        }

        public boolean isExist(){
            return count != 0;
        }

        public int getCount(){
            return count;
        }

        public void move(){
            switch(direction){
                case UP:
                    row -= 1;
                    if(row == 0){
                        count /= 2;
                        direction = Direction.DOWN;
                    }
                    break;
                case DOWN:
                    row += 1;
                    if(row == N - 1){
                        count /= 2;
                        direction = Direction.UP;
                    }
                    break;
                case LEFT:
                    col -= 1;
                    if(col == 0){
                        count /= 2;
                        direction = Direction.RIGHT;
                    }
                    break;
                case RIGHT:
                    col += 1;
                    if(col == N - 1){
                        count /= 2;
                        direction = Direction.LEFT;
                    }
                    break;
            }
        }
    }

    static class Crowd{
        int N;
        int M;
        List<Microbe> microbes;
        Map<Point, List<Microbe>> map = new HashMap<>();

        class Point {
            int row;
            int col;

            public Point(int row, int col){
                this.row = row;
                this.col = col;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Point point = (Point) o;
                return row == point.row &&
                        col == point.col;
            }

            @Override
            public int hashCode() {
                return Objects.hash(row, col);
            }
        }

        public Crowd(int N, int M, List<Microbe> microbes){
            this.N = N;
            this.M = M;
            this.microbes = microbes;
        }

        public int getResult(){

            int time = M;
            while(time > 0){
                microbes = move();
                map.clear();
                time -=1 ;
            }

            return getSumOfMicrobeCount(microbes);
        }

        private List<Microbe> move(){
            microbes.forEach(Microbe::move);

            microbes = microbes.stream()
                    .filter(Microbe::isExist)
                    .collect(Collectors.toList());


            microbes.forEach(microbe -> {
                final Point currentPoint = new Point(microbe.row, microbe.col);
                List<Microbe> list = map.getOrDefault(currentPoint, new ArrayList<>());
                list.add(microbe);
                map.put(currentPoint, list);
            });

            final List<Microbe> newMicrobes = new ArrayList<>();

            for(Point point : map.keySet()){
                List<Microbe> list = map.get(point);
                int sum = getSumOfMicrobeCount(list);
                Microbe maxMicrobe = list.stream()
                        .max(Comparator.comparing(Microbe::getCount))
                        .orElseThrow(NoSuchFieldError::new);

                maxMicrobe.count = sum;
                newMicrobes.add(maxMicrobe);
            }

            return newMicrobes;
        }

        private int getSumOfMicrobeCount(List<Microbe> microbes){
            return microbes.stream()
                    .mapToInt(microbe -> microbe.count)
                    .sum();
        }
    }
}
