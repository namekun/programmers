package lv2;

import java.util.*;

public class 삼각달팽이 {
    public static void main(String[] args) {
        삼각달팽이 test = new 삼각달팽이();
        int[] solution = test.solution(4);
        System.out.println(Arrays.toString(solution));
    }

    public int[] solution(int n) {
        int[][] matrix = new int[n][n];
        int x = 0, y = 0;
        int max = (n * (n + 1)) / 2;
        int value = 1;
        matrix[0][0] = 1;

        while(value < max){
            // move x
            while (x + 1 < n && matrix[x + 1][y] == 0) {
                matrix[++x][y] = ++value;
            }

            // move y
            while (y + 1 < n && matrix[x][y + 1] == 0) {
                matrix[x][++y] = ++value;
            }

            // move x-1, y-1
            while (y - 1 > 0 && x - 1 > 0 && matrix[x - 1][y - 1] == 0) {
                matrix[--x][--y] = ++value;
            }
        }

        List<Integer> answer = new ArrayList<>();
        for (int[] arr : matrix) {
            for (int innerValue : arr) {
                if (innerValue != 0) {
                    answer.add(innerValue);
                }
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
