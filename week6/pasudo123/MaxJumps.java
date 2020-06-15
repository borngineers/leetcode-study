package week06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxJumps {

    public static void main(String[] args) {

        System.out.println(maxJumps(new int[]{6, 4, 14, 6, 8, 13, 9, 7, 10, 6, 12}, 2));
//        System.out.println(maxJumps(new int[]{7,6,5,4,3,2,1}, 1));
//        System.out.println(maxJumps(new int[]{3,3,3,3,3}, 3));
    }

    static int distance = -1;
    static int maxValue = 0;

    public static int maxJumps(int[] arr, int d) {

        /**
         * 이전값, 위치, 재귀
         */

        final int size = arr.length;

        distance = d;

        int[] visited = new int[size];      // 방문 배열

        for (int i = 0; i < size; i++) {
            visited[i] = 1;
            jump(arr[i], i, arr, visited);
            visited[i] = 0;
        }

        return maxValue;
    }

    public static void jump(int nowHeight,
                            int startIndex,
                            int[] arr,
                            int[] visited) {

        maxValue = Math.max(visited[startIndex], maxValue);

        final List<Integer> leftIndexList = new ArrayList<>();
        boolean isInOfLeftIndex = true;
        boolean isLeftMovable = true;

        final List<Integer> rightIndexList = new ArrayList<>();
        boolean isInOfRightIndex = true;
        boolean isRightMovable = true;

        // 방문은 안했고, 나보다 값이 작다.
        // 그 이전에 근데 방문했던 값이 나보다 크다.
        for (int d = 1; d <= distance; d++) {

            int leftIndex = startIndex - d;
            int rightIndex = startIndex + d;

            /** 왼쪽 **/
            if (leftIndex < 0) {
                isInOfLeftIndex = false;
            }

            if (isInOfLeftIndex && arr[leftIndex] >= nowHeight) {
                isLeftMovable = false;
            }

            if (isInOfLeftIndex && isLeftMovable && visited[leftIndex] == 0) {
                leftIndexList.add(leftIndex);
            }

            /** 오른쪽 **/
            if (rightIndex >= arr.length) {
                isInOfRightIndex = false;
            }

            if (isInOfRightIndex && arr[rightIndex] >= nowHeight) {
                isRightMovable = false;
            }

            if (isInOfRightIndex && isRightMovable && visited[rightIndex] == 0) {
                rightIndexList.add(rightIndex);
            }
        }

        // 왼쪽 이동
        for (int leftIndex : leftIndexList) {
            visited[leftIndex] = visited[startIndex] + 1;
            jump(arr[leftIndex], leftIndex, arr, visited);
            visited[leftIndex] = 0;
        }

        // 오른쪽 이동
        for (int rightIndex : rightIndexList) {
            visited[rightIndex] = visited[startIndex] + 1;
            jump(arr[rightIndex], rightIndex, arr, visited);
            visited[rightIndex] = 0;
        }
    }
}
