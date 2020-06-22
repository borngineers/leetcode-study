package leetcode.week08;

import java.util.LinkedList;
import java.util.Queue;

public class S289 {
    public static void main(String[] args) {
        // 살아있는 경우 : 상하좌우, 대각선에 인구 2 미만이 있으면 나는 죽는다.
        // 살아있는 경우 : 상하좌우, 대각선에 인구 2~3 이면 살아남는다.
        // 살아있는 경우 : 상하좌우, 대각선에 인구 3 초과면 나는 죽는다.
        // 죽어있는 경우 : 상하좌우, 대각선에 인구 3이면 살아난다.
    }

    public static void gameOfLife(int[][] board) {

        final int rows = board.length;
        final int cols = board[0].length;

        final Queue<Cell> queue = new LinkedList<>();

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++){
                int aliveCount = 0;

                // 좌상
                if(row - 1 >= 0 && col - 1 >= 0){ aliveCount += board[row-1][col-1]; }

                // 좌
                if(col - 1 >= 0){ aliveCount += board[row][col-1]; }

                // 상
                if(row - 1 >= 0){ aliveCount += board[row-1][col]; }

                // 우상
                if(row - 1 >= 0 && col + 1 < cols) { aliveCount += board[row-1][col+1]; }

                // 우
                if(col + 1 < cols) { aliveCount += board[row][col+1]; }

                // 우하
                if(row + 1 < rows && col + 1 < cols) { aliveCount += board[row+1][col+1]; }

                // 하
                if(row + 1 < rows) { aliveCount += board[row+1][col]; }

                // 좌하
                if(row + 1 < rows && col - 1 >= 0) { aliveCount += board[row+1][col-1]; }

                queue.add(new Cell(row, col, isAlivePossible(board[row][col], aliveCount)));
            }
        }

        while(!queue.isEmpty()){
            final Cell cell = queue.poll();
            board[cell.row][cell.col] = cell.alive ? 1 : 0;
        }
    }

    private static boolean isAlivePossible(int currentState, int aliveNeighborsCount) {
        if(aliveNeighborsCount < 2) { return false; }
        if(aliveNeighborsCount == 3 && currentState == 0) {return true;}
        if(aliveNeighborsCount <= 3 && currentState == 1) {return true;}
        return false;
    }

    static class Cell{
        private final int row;
        private final int col;
        private final boolean alive;
        public Cell(final int row,
                    final int col,
                    final boolean alive){
            this.row = row;
            this.col = col;
            this.alive = alive;
        }
    }
}
