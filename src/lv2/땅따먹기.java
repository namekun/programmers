package lv2;

import java.util.Arrays;
import java.util.stream.IntStream;

public class 땅따먹기 {
    public static void main(String[] args) {
        int[][] land = {{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}};
        땅따먹기 test = new 땅따먹기();
        int solution = test.solution(land);
        System.out.println(solution);
    }

    public int solution(int[][] land) {
        IntStream.range(1, land.length)
                .forEach(i -> {
                    land[i][0] += max(land[i - 1][1], land[i - 1][2], land[i - 1][3]);
                    land[i][1] += max(land[i - 1][0], land[i - 1][2], land[i - 1][3]);
                    land[i][2] += max(land[i - 1][0], land[i - 1][1], land[i - 1][3]);
                    land[i][3] += max(land[i - 1][0], land[i - 1][1], land[i - 1][2]);
                });

        for(int [] arr : land){
            System.out.println(Arrays.toString(arr));
        }

        return max(land[land.length - 1]);
    }

    private int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    private int max(int[] arr) {
        return Arrays.stream(arr).max().getAsInt();
    }
}
